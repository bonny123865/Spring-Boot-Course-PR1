package com.example.resttemplate;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestTemplateController {
    @GetMapping("/getForObject")
    public String getForObject(){

        RestTemplate restTemplate = new RestTemplate();
        Student student = restTemplate.getForObject(
                "https://mocki.io/v1/2de8c6bf-f6b2-4ce3-ab91-6dbeee94e456",
                Student.class);

        System.out.println("Student 得出的 id 為 : " + student.getId());
        System.out.println("Student 得出的 name 為 : " + student.getName());
        System.out.println("Student 得出的 phone() 為 : " + student.getContactPhone());
        return "getForObject success";
    }

    @GetMapping("/getForObjectWithParam")
    public String getForObjectWithParam(){
        RestTemplate restTemplate = new RestTemplate();

        Map<String,Object> queryParamMap = new HashMap<>();
        queryParamMap.put("graduate" , true);

        Student student = restTemplate.getForObject(
                "https://mocki.io/v1/2de8c6bf-f6b2-4ce3-ab91-6dbeee94e456",
                Student.class);

        return "getForObjectWithParam success";
    }

    @GetMapping("/getForOEntity")
    public String getForOEntity(){
        RestTemplate restTemplate = new RestTemplate();

        //返回完整資訊
        ResponseEntity<Student> studentResponseEntity = restTemplate.getForEntity(
                "https://mocki.io/v1/2de8c6bf-f6b2-4ce3-ab91-6dbeee94e456",
                Student.class);

        System.out.println("http 狀態碼 為 : " + studentResponseEntity.getStatusCode());

        Student student = studentResponseEntity.getBody();

        System.out.println("Student 得出的 id 為 : " + student.getId());
        System.out.println("Student 得出的 name 為 : " + student.getName());
        System.out.println("Student 得出的 phone() 為 : " + student.getContactPhone());
        return "getForOEntity success";
    }

//    {
//        "id""null,"
//            "name":"John",
//        "content_phone":null
//    }

    @GetMapping("/postForObject")
    public String postForObject(){
        RestTemplate restTemplate = new RestTemplate();
        Student studentRequestBody = new Student();
        studentRequestBody.setName("John");

        Student result = restTemplate.postForObject(
                "https://mocki.io/v1/2de8c6bf-f6b2-4ce3-ab91-6dbeee94e456",
                studentRequestBody,
                Student.class);

        return "postForObject success";
    }

    @GetMapping("/postForEntity")
    public String postForEntity(){
        RestTemplate restTemplate = new RestTemplate();
        Student studentRequestBody = new Student();
        studentRequestBody.setName("John");

        ResponseEntity<Student> responseEntity = restTemplate.postForEntity(
                "https://mocki.io/v1/2de8c6bf-f6b2-4ce3-ab91-6dbeee94e456",
                studentRequestBody,
                Student.class);

        return "postForEntity success";
    }
//    根據不同參數
//    等同於 "設定header" : "header1", 123
//    挾帶參數 "graduate"  : true
    @GetMapping("/exchange")
    public String exchange() {
        RestTemplate restTemplate = new RestTemplate();

        //使用 exchange 發起 GET請求
        HttpHeaders requestHeader = new HttpHeaders();
        requestHeader.set("header1", "123");

        HttpEntity requestEntity = new HttpEntity(requestHeader);

        Map<String, Object> queryParamMap = new HashMap<>();
        queryParamMap.put("graduate", true);

        ResponseEntity<Student> getStudentEntity = restTemplate.exchange(
                "https://mocki.io/v1/2de8c6bf-f6b2-4ce3-ab91-6dbeee94e456",
                HttpMethod.GET,
                requestEntity,
                Student.class,
                queryParamMap);

        //使用 exchange 發起 POST請求
        //    等同於 "設定header" : "header1", 123、"Content-Type": "application/json"
        //    "設定Body" :
        //    {
        ////        "id""null,"
        ////            "name":"John",
        ////        "content_phone":null
        ////    }

        HttpHeaders requestHeaderPost = new HttpHeaders();
        requestHeaderPost.set("header1", "123");
        requestHeaderPost.setContentType(MediaType.APPLICATION_JSON);

        Student studentRequestBody = new Student();
        studentRequestBody.setName("John");

        HttpEntity requestEntityPost = new HttpEntity(studentRequestBody,requestHeaderPost);


        ResponseEntity<Student> postStudentEntity = restTemplate.exchange(
                "https://mocki.io/v1/2de8c6bf-f6b2-4ce3-ab91-6dbeee94e456",
                HttpMethod.POST,
                requestEntityPost,
                Student.class);

        return "exchange success";
    }




}

package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ObjectMapperController {
    @GetMapping("/convert")
    public String convert() throws JsonProcessingException {

        User user = new User();
        user.setId(1);
        user.setName("Bonny");
        user.setContentEmail("test.com");

        ObjectMapper objectMapper = new ObjectMapper();

        // 可以將 User 轉成 json 字串
        String jsonResult = objectMapper.writeValueAsString(user);
        System.out.println("json 得出的結果為 : "+jsonResult);

        // 可以將 json 字串  轉成  User
        String json="{\"id\":3," +
                "\"name\":\"Amy\"," +
                "\"age\":30," +
                "\"contact_Email\":\"123@test.com\"}";

        User userResult = objectMapper.readValue(json, User.class);
        System.out.println("User 得出的 id 為 : " + userResult.getId());
        System.out.println("User 得出的 name 為 : " + userResult.getName());
        System.out.println("User 得出的 Email 為 : " + userResult.getContentEmail());

        return "convert success.";
    }
}

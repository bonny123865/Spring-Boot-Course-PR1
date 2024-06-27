package com.demo_transaction.controller;

import com.demo_transaction.dto.TransferRequest;
import com.demo_transaction.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/transfer")
    public String transfer(@RequestBody TransferRequest transferRequest) {

        accountService.transfer(
                transferRequest.getFrom(),
                transferRequest.getTo(),
                transferRequest.getMoney()
        );

        return "轉帳成功!";
    }
}

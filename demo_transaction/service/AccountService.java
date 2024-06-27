package com.demo_transaction.service;

public interface AccountService {

    void transfer(Integer fromAccountId, Integer toAccountId, Integer money);
}

package com.demo_transaction.service;

import com.demo_transaction.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//可以使用一個交易來保護整個運作，加在Service上，因為會去存取Dao層
@Transactional
@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void transfer(Integer fromAccountId, Integer toAccountId, Integer money) {

        // Step1 : User A 扣除 轉帳金額
        accountDao.decreaseMoney(fromAccountId, money);

        // Step2 : User B 收到 轉入金額
        accountDao.addMoney(toAccountId, money);
    }
}

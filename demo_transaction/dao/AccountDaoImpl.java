package com.demo_transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AccountDaoImpl implements AccountDao {

    //跟資料庫進行溝通，要加上 namedParameterJdbcTemplate
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void decreaseMoney(Integer id, Integer money) {
        String sql = "UPDATE account SET balance = balance - :money WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("money", money);

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void addMoney(Integer id, Integer money) {
        String sql = "UPDATE account SET balance = balance + :money WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("money", money);

        namedParameterJdbcTemplate.update(sql, map);
    }
}

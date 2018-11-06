package com.example.girl.service;

import com.example.girl.domain.Girl;
import com.example.girl.exception.GirlException;
import com.example.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: superC
 * @Date: 2018/11/6 17:29
 */
@Component
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;


    public void getAge(Integer id) throws Exception{

        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            throw new GirlException(100,"你太小了");
        }else if(age >10 && age < 16){
            throw new GirlException(101,"你初中了吧");
        }

    }
}

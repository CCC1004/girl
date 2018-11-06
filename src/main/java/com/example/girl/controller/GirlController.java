package com.example.girl.controller;

import com.example.girl.domain.Girl;
import com.example.girl.domain.Result;
import com.example.girl.repository.GirlRepository;
import com.example.girl.service.GirlService;
import com.example.girl.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 获取列表
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> findAll(){
        logger.info("findAll------方法体-");
        return girlRepository.findAll();
    }



    /**
     * 添加,带验证
     */
    @PostMapping("/girls2")
    public Result<Girl> girlAdd2(@Valid Girl girl, BindingResult bindingResult){

        //若验证参数有错误
        if(bindingResult.hasErrors()){

            return ResultUtils.error(1,bindingResult.getFieldError().getDefaultMessage());

        }

        Girl girl1 = new Girl();
        girl1.setAge(girl.getAge());
        girl1.setCupSize(girl.getCupSize());
        girl1.setMoney(girl.getMoney());
        return ResultUtils.success(girlRepository.save(girl1));
    }

    /**
     * 添加
     */
    @PostMapping("/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cup,
                         @RequestParam("age") Integer age){
        Girl girl1 = new Girl();
        girl1.setAge(age);
        girl1.setCupSize(cup);
        return girlRepository.save(girl1);
    }

    /**
     * 通过id查询G???????????????????????/报错
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.getOne(id);
    }

    /**
     * 查询年龄
     */
    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }

    /**
     * 更新
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                            @RequestParam("cupSize") String cup,
                            @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cup);
        girl.setAge(age);
        girl.setId(id);
        return  girlRepository.save(girl);

    }

    /**
     * 删除
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

}

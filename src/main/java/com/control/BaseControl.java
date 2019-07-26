package com.control;

import com.bean.User;
import com.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangbiaof
 * @data 创建时间：2019/7/23 11:59
 */
@RestController
@RequestMapping(value = "/baseControl")
public class BaseControl {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/hello")
    public String sayHello(){
        User u = userMapper.GetUserByID(1000);
        System.out.println(u);
        return u.toString();
    }
}

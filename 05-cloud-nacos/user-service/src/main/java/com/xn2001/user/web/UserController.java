package com.xn2001.user.web;

import com.xn2001.user.config.PatternProperties;
import com.xn2001.user.pojo.User;
import com.xn2001.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope //搭配 @Value 使用
public class UserController {

    @Autowired
    private UserService userService;

    //@Value("${pattern.dateformat}")
    //private String dateformat;

    @Autowired
    private PatternProperties patternProperties;

    //@GetMapping("now")
    //public String now(){
    //    //格式化时间
    //    return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
    //}

    @GetMapping("now2")
    public String now2(){
        //格式化时间
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.dateformat));
    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}

package com.itzixi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Author 公众号【风间影月】
 * @Version 1.0
 * @Description HelloController
 **/
@RestController
public class HelloController {

    /**
     * @Description: hello 测试的路由api方法
     * @Author 风间影月
     * @param
     * @return Object
     */
    @GetMapping("hello")
    public Object hello() {
        return "Hello 风间影月~";
    }

}

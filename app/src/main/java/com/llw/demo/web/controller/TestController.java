package com.llw.demo.web.controller;

import com.llw.demo.common.base.BaseController;
import com.llw.demo.common.dto.vo.AdminVo;
import com.llw.demo.common.exception.BussinessException;
import com.llw.demo.model.User;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @discription:
 * @author: llw
 * @date: 2016-11-25
 */
@Controller
@RequestMapping("/test")
@Api(value = "/test", description = "Test的所有视图和接口")
public class TestController extends BaseController {

    @PostMapping("/login")
    @ResponseBody
    public User login(@RequestParam String username,
                      @RequestParam String password) throws Exception {
        System.out.println("entry controller");

//        throw new BussinessException("业务异常了！！");

        return new User();
//        return "username:" + "张三" + ", password:" + password;
    }

}

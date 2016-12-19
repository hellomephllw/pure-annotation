package com.llw.demo.web.controller;

import com.llw.demo.common.base.BaseController;
import com.llw.demo.common.base.BaseVo;
import com.llw.demo.common.dto.vo.ProductVo;
import com.llw.demo.common.dto.vo.SpecialVo;
import com.llw.demo.common.dto.vo.UserVo;
import com.llw.demo.model.User;
import com.llw.demo.service.IUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @discription: 用户表现层
 * @author: llw
 * @date: 2016-11-17
 */
@Controller
@Api(value = "/user", description = "User的所有视图和接口")
public class UserController extends BaseController {

//    @Autowired
//    IUserService userService;

    /**
     * 登陆rest api
     * 1.PostMapping表明为post请求
     * 2.ResponseBody表明响应消息体为mime
     * 3.如果参数不是必须的话，请效仿username的写法
     */
    @PostMapping("/api/user/login")
    @ResponseBody
    public BaseVo login(@RequestParam(required = false) String username,
                        @RequestParam String password) throws Exception {
        System.out.println("entry controller");

//        userService.login(username, password);

        return new BaseVo(1, "登陆成功！", null);
    }

    /** rest api =============================== */

    /**
     * 获取用户
     * 1.GetMapping表明为get请求，一般处理查询
     * 2.ResponseBody表明返回数据为mime
     * 3.ApiOperation用来生成api参考文档，value必须写清楚该请求的作用
     * 4.PathVariable用来获取在url上的值
     * 5.返回的值对象UserVo，值对象的属性必须按照要求写好解释，也可直接将pojo返回，根据实际需求
     */
    @GetMapping("/api/user/{userId}")
    @ResponseBody
    @ApiOperation(value = "获取用户", notes = "备注")
    public UserVo getUser(@PathVariable Long userId) throws Exception {

        return new UserVo();
    }

    /**
     * 添加用户
     * 1.PostMapping表明为post请求，一般处理新增
     * 2.RequestParam用来获取表单数据，post/get通用
     */
    @PostMapping("/api/user")
    @ResponseBody
    @ApiOperation(value = "添加用户", notes = "备注")
    public BaseVo addUser(@RequestParam String username,
                           @RequestParam String password) throws Exception {

        return new BaseVo(1, "成功删除！", null);
    }

    /**
     * 删除用户
     * 1.DeleteMapping表明为delete请求，一般处理删除
     */
    @DeleteMapping("/api/user/{userId}")
    @ResponseBody
    @ApiOperation(value = "删除用户", notes = "备注")
    public BaseVo deleteUser(@PathVariable Long userId) throws Exception {

        return new BaseVo(1, "成功删除！", null);
    }

    /**
     * 修改用户
     * 1.PatchMapping表明为patch请求，一般处理修改
     * 2.RequestBody表明请求的消息体为mime
     */
    @PatchMapping("/api/user/{userId}")
    @ResponseBody
    @ApiOperation(value = "更新用户", notes = "备注")
    public BaseVo updateUser(@PathVariable Long userId,
                             @RequestBody UserVo user) throws Exception {

        return new BaseVo(1, "更新成功！", null);
    }

    /** views =============================== */
    /**
     * 获取商品视图
     * 1.GetMapping表明为get请求，根据需要来指定请求类型
     * 2.ApiOperation的value一定要写清楚
     * 3.ApiOperation的response为api文档提供响应的视图对象说明，必须配置
     * 4.ApiOperation的responseContainer，若为集合，则配置该选项
     */
    @GetMapping("/view/user/hello")
    @ApiOperation(value = "商品视图", notes = "备注", response = ProductVo.class, responseContainer = "list")
    public ModelAndView getHello() throws Exception {
        List<ProductVo> products = new ArrayList<>();
        products.add(new ProductVo("苹果", "20"));
        products.add(new ProductVo("西瓜", "20"));

        return new ModelAndView("hello", "products", products);
    }

    /**
     * 获取所需视图
     */
    @PostMapping("/view/user/youneed")
    @ApiOperation(value = "所需页面", notes = "提供所需对象", response = SpecialVo.class)
    public ModelAndView getYouNeed() throws Exception {
        SpecialVo specialVo = new SpecialVo();

        return new ModelAndView("youneed", "special", specialVo);
    }

    /** session&cookie =============================== */
    /**
     * 处理session
     */
    @GetMapping("/api/session")
    @ResponseBody
    public String disposeSession(HttpSession session) throws Exception {

        return "处理session";
    }

    /**
     * 处理cookie
     */
    @GetMapping("/api/cookie")
    @ResponseBody
    public String disposeCookie(@CookieValue("JSESSIONID") String sessionId) throws Exception {

        return "处理cookie";
    }

    /** header =============================== */
    @GetMapping("/api/header")
    @ResponseBody
    public String disposeHeader(@RequestHeader HttpHeaders headers) throws Exception {

        System.out.println(headers.get("Keep-Alive"));
        System.out.println(headers.get("Accept-Encoding"));

        return "处理header";
    }

    /** servlet api =============================== */
    @GetMapping("/api/servlet")
    @ResponseBody
    public String disposeServletApi(HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        return "处理servlet api";
    }

    /** redirect =============================== */
    @GetMapping("/api/redirect")
    @ResponseBody
    public String disposeRedirect() throws Exception {

        return "redirect:https://www.baidu.com";
    }

}

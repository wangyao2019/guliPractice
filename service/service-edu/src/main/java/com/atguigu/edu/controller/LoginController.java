package com.atguigu.edu.controller;

import com.atguigu.commonutils.R;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("edu/user")
@CrossOrigin //跨域
public class LoginController {

    //login
    @PostMapping("login")
    public R login() {

        return R.success().data("token", "admin");
    }


    //info
    @GetMapping("info")
    public R info() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("roles", "[admin]");
        map.put("name", "admin");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return R.success().data(map);
    }

    //logout
    @PostMapping("logout")
    public R logout() {
        return R.success().data(null);
    }
}

package com.tnb.security.demo.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Map;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = {"/", "/index" })
    public String index(Map<String,Object> map, Principal principal) {
        map.put("principal", JSON.toJSONString(principal));
        return "index";
    }

}

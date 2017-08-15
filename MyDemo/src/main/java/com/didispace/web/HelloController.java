package com.didispace.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author 程序猿DD
 * @version 1.0.0
 * @blog http://blog.didispace.com
 *
 */
@Controller
public class HelloController {

    @RequestMapping(value = {"", "/home"}, method=RequestMethod.GET)
    public String index() {
        return "index";
    }
    
    @RequestMapping(value = "/helloadmin", method=RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String helloAdmin(){
        return "helloAdmin";
    }
    
    @RequestMapping(value = "/hellouser", method=RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String helloUser(){
        return "helloUser";
    }
    

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model){
       String msg = "test";
        model.addAttribute("msg", msg);
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String forbidden() {
        return "403";
    }
}
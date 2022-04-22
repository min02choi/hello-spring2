package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")    // 웹 어플리케이션에서 /hello가 들어오면 이 메소드를 호출
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";     // templates 아래의 hello.html을 찾음
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";    // templates 아래의 hello-template.html을 찾음
    }

    @GetMapping("hello-string")
    @ResponseBody                   // http 바디부에 내가 이걸 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;     // 페이지 소스 보기 -> html없이 "hello spring" 만
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

// resources:templates/ + (ViewName) + .html
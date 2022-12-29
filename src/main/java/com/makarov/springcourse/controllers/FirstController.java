package com.makarov.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request, Model model) {
        model.addAttribute("message", "Hello, " + request.getParameter("name") + " " + request.getParameter("surname"));
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname) {
        System.out.println(name);
        System.out.println(surname);
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(HttpServletRequest request, Model model) {
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        int result;

        String action = request.getParameter("action");

        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = a / b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);

        return "/first/calculator";
    }
}

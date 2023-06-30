package ru.test.java.planflight.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DefaultController {
    @GetMapping("/")
    public String redirectToSwagger(HttpServletRequest request) {
        return "redirect:swagger-ui.html#";
    }
}

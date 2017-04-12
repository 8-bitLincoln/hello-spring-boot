package com.example;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //return view
//@RestController //return object to view
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World! Is it working?";
    }

    @RequestMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", "username");
        return "greeting";
    }

//    private String getUserName()
//    {
//        return "%username% [" + RandomUtils.nextInt(0,20) + "]";
//    }

//    public static final int BEST_NUMBER = 7;

//    private static String USERNAME()
//    {
//        return "STATIC %username%";
//    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
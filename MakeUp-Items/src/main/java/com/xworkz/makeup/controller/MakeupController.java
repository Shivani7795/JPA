package com.xworkz.makeup.controller;

import com.xworkz.makeup.dto.MakeupDto;
import com.xworkz.makeup.service.MakeupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;
import java.util.List;

@Controller
@RequestMapping("/")
public class MakeupController {

    @Autowired
    private MakeupService makeupService;

    public MakeupController(){
        System.out.println("MakeupController constructor");
    }

    @GetMapping("/getIndex")
    public String getIndex(){
        System.out.println("returned index page");
        return "index";
    }

    @GetMapping("/redirectToMakeup")
    public String getMakeupForm(){
        System.out.println("returned tourism form");
        return "makeup";
    }

    @GetMapping("/ShowAllProducts")
    public String getAllEntity(Model model){
        System.out.println("getAllEntity method in controller");
        List<MakeupDto> list = makeupService.getAllEntity();
        list.forEach(System.out::println);
        model.addAttribute("listOfDto",list);
        return "listOfProducts";
    }

    @PostMapping("/items")
    public String getMakeup(MakeupDto dto, Model model){
        System.out.println("getMakeup method");
        System.out.println("controller data:" + dto);
        if (makeupService.validate(dto)){
            model.addAttribute("message","submitted successfully");
            return getAllEntity(model);
        }else {
            model.addAttribute("message","invalid details");
            model.addAttribute("dto",dto);
        }
        return "makeup";
    }



}

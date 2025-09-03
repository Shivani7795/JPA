package com.xworkz.login.controller;

import com.xworkz.login.dto.LoginDto;
import com.xworkz.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {
    public LoginController(){
        System.out.println("LoginController const");
    }
    @Autowired
    private LoginService loginService;

    @GetMapping("getIndex")
    public String register(){
        System.out.println("register method in controller");
        return "register";
    }

    @GetMapping("redirecTologin")
    public String Login(){
        System.out.println("Login method in controller");
        return "login";
    }

    public String save(@Valid LoginDto dto, BindingResult result, Model model){
        System.out.println("save method in controller");
        System.out.println("dto");

        if(result.hasErrors()){
            result.getFieldErrors().stream().map(fieldError -> fieldError.getField()+"--"+fieldError.getDefaultMessage())
                    .forEach(System.out::println);
            model.addAttribute("message","invalid details");
            model.addAttribute("dto",dto);
            return "register";
        }
        if(loginService.save(dto)){
            model.addAttribute("message","Invalid details");
            model.addAttribute("dto",dto);
            return "register";
        }
        if(loginService.save(dto)){
            model.addAttribute("message","submitted");
        }else{
            model.addAttribute("message","not submitted");
            model.addAttribute("dto",dto);
        }
        return "register";
    }
    public String login(@RequestParam String email,@RequestParam String password,Model model){
        System.out.println("controller login");
        System.out.println("email:"+email+"Password:"+password);
        LoginDto dto = loginService.acceptLogin(email, password);
        if (dto == null){
            model.addAttribute("message","invalid email or password");
            return "login";
        }
        model.addAttribute("dto",dto);
        return "view";
    }

}

package com.xworkz.login.restController;

import com.xworkz.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RegisterRestController {

    @Autowired
    private LoginService loginService;

    public RegisterRestController(){
        System.out.println("rest controller const");
    }

    @GetMapping("/loginemail")
    public String mailValidation(@RequestParam("regEmail")String email){
        System.out.println("validation mail");
        String existing = loginService.getByEmail(email);
        System.out.println(existing);

        if(existing ==null){
            return "";
        }
        return "Email already registered";
    }

    @GetMapping("/loginmobile")
    public String mobileValidation(@RequestParam("regPhone")String mobile){
        System.out.println("mobile validation");
        Long existingObj = loginService.getByMobile(Long.valueOf(mobile));
        System.out.println(existingObj);
        if (existingObj  == null){
            return "";
        }
        return "Mobile number already registered";
    }
}

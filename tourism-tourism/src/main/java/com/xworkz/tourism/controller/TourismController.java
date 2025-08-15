package com.xworkz.tourism.controller;

import com.xworkz.tourism.dto.TourismDto;
import com.xworkz.tourism.service.TourismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class TourismController {

    @Autowired
    private TourismService tourismService;

    public TourismController() {
        System.out.println("TourismController constructor");
    }

    @GetMapping("/redirectToTourism")
    public String getTourismForm() {
        System.out.println("returned tourism form page");
        return "tourism";
    }

    @GetMapping("/getIndex")
    public String getIndex() {
        System.out.println("returned index page");
        return "index";
    }

    @PostMapping("/tourism")
    public String getTourism(TourismDto dto, Model model) {
        System.out.println("getTourism method");
        System.out.println("Controller data: " + dto);
        if (tourismService.validate(dto)) {
            model.addAttribute("message", "Submitted successfully");
            return getAllEntity(model);
        } else {
            model.addAttribute("message", "Invalid details");
            model.addAttribute("dto", dto);
        }
        return "tourism";
    }

    @GetMapping("/getAllEntity")
    public String getAllEntity(Model model) {
        System.out.println("getAllEntity method in controller");
        List<TourismDto> list = tourismService.getAllEntity();
        list.forEach(System.out::println);
        model.addAttribute("listOfDto", list);
        return "listOfTourism";
    }

    @GetMapping("/view")
    public String getById(@RequestParam String id, Model model) {
        System.out.println("getById method in controller");
        System.out.println("Id: " + id);
        Optional<TourismDto> optionalTourismDTO=tourismService.findById(Integer.parseInt(id));
        if(optionalTourismDTO.isPresent())
        {
            System.out.println("Data found");
            System.out.println(optionalTourismDTO.get());
            model.addAttribute("ref",optionalTourismDTO.get());
        }else {
            System.out.println("Data not found");
            model.addAttribute("errorMessage", "No package found for ID: " + id);
        }
        return "DisplayId";
    }

    @GetMapping("update/id")
    public String Update(@PathVariable("id")String id,Model model){
        System.out.println("update method in controller");
        System.out.println("id"+id);
        Optional<TourismDto> optionalTourismDTO=tourismService.findById(Integer.parseInt(id));
        if(optionalTourismDTO.isPresent()){
            System.out.println("data is present");
            System.out.println(optionalTourismDTO.get());
            model.addAttribute("dto",optionalTourismDTO.get());
        }
        return "update";
    }
    @PostMapping("update")
    public String edit(TourismDto dto,Model model){
        System.out.println("edit method in controller");
        String


    }
}
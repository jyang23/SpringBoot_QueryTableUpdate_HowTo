package com.jy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class JustinController {

    @Autowired
    UserRepository userRepository;

    //------------------------------------------------------------------------------------------------------------------
    @RequestMapping("/")
    public String adminPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @RequestMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userRepository.findById(id).get());
        model.addAttribute("id",id);
        return "userform";
    }

    @PostMapping("/process")
    public String processForm(@Valid User user,
                              @RequestParam(value = "firstName", required = false) String firstName,
                              @RequestParam(value = "lastName", required = false) String lastName,
                              @RequestParam(name = "id", required = false) long id,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "userform";
        }
        System.out.println(firstName);
        System.out.println(lastName);
        userRepository.updateFirstName(id, firstName);
        userRepository.updateLastName(id, lastName);
        return "redirect:/";
    }
    //------------------------------------------------------------------------------------------------------------------
}

package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.data.UserData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping()
    public String displayAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping()
    public String processAddUserForm(@ModelAttribute @Valid User newUser, Errors errors, Model model) {
// add form submission handling code here
        if(errors.hasErrors()) {
            return "user/add";
        }
        UserData.add(newUser);
        model.addAttribute("users", UserData.getAll());
        return "user/index";

    }
}


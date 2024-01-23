package org.launchcode.controllers;

import org.launchcode.data.UserData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping()
    public String displayAddUserForm(Model model) {
        return "user/add";
    }

    @PostMapping()
    public String processAddUserForm(Model model, @ModelAttribute User user, @RequestParam String verify) {
// add form submission handling code here

        model.addAttribute("userName", user.getUserName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("verify",verify);

        if (user.getPassword().equals(verify)) {
            UserData.add(user);
            model.addAttribute("users", UserData.getAll());
            return "user/index";
        } else {
            model.addAttribute("error","Passwords don't match");
            return "user/add";
        }
    }
}


package ua.pp.darknsoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.darknsoft.services.user.UserCrudService;

/*@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    UserCrudService users;

    @GetMapping(value = "/users")
    public String showUser(Pageable page, Model dasModel) {
        dasModel.addAttribute("allUsers",users.getAll(page));
        dasModel.addAttribute("headers", "role_admin");
        dasModel.addAttribute("bodies", "user_list_paginator");
        return "adminPage";
    }
    @GetMapping(value = "/disabledusers")
    public String showDisabledUser(Pageable page, Model dasModel) {
        dasModel.addAttribute("allUsers",users.getAllDisabled(page));
        dasModel.addAttribute("headers", "role_admin");
        dasModel.addAttribute("bodies", "user_list_paginator");
        return "adminPage";
    }
}*/

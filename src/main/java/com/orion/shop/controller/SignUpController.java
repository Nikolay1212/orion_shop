package com.orion.shop.controller;

import com.orion.shop.form.SignUpForm;
import com.orion.shop.global.GlobalData;
import com.orion.shop.service.ConfirmService;
import com.orion.shop.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @Autowired
    private ConfirmService confirmService;

    @GetMapping("/signUp")
    public String getSignUpPage(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUpUser(@Valid SignUpForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("signUpForm", form);
            return "signUp";
        }
        signUpService.signUp(form);
        return "redirect:/signIn";
    }

    @GetMapping("/account/confirm/{confirm_id}")
    public String confirmAccount(@PathVariable("confirm_id") String confirmId) {
        if (confirmService.confirm(confirmId)) {
            return "success_confirm";
        } else {
            return "fail_confirm";
        }
    }
}

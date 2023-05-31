package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import rikkei.academy.model.User;
import rikkei.academy.service.IUserService;
import rikkei.academy.service.UserService;
import rikkei.academy.validate.UserValidate;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/form")

    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/form")
    public String submitForm(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }

        userService.saveUser(user);
        return "result";
    }
    @GetMapping("/create")
    public ModelAndView add() {
        return new ModelAndView("add", "user", new User());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") User c, BindingResult bindingResult) {
        new UserValidate().checkValidate(c,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "index";
        }else {
            userService.saveUser(c);
            return "redirect:/";
        }
    }
}

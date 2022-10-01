package manager.mywebappspringboot.controller;

import manager.mywebappspringboot.model.User;
import manager.mywebappspringboot.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImp service;

    @GetMapping({"","/"})
    public String showUSersList(Model model) {
        model.addAttribute("userBlank", new User());
        List<User> users = service.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user, RedirectAttributes ra) {
        if(user.getId() == null) {
            service.createUser(user);
        } else {
            service.updateUser(user);
        }
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable(value = "id", required = true) long id, Model model) {
        if (service.getUserById(id) == null) {
            return "redirect:/users";
        }
        model.addAttribute("user", service.getUserById(id));
        return "form_user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value = "id", required = true) long id, Model model) {
        if(service.getUserById(id) != null) {
            service.deleteUserById(id);
        }
        return "redirect:/users";
    }

}

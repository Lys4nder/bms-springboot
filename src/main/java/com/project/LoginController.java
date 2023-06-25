package com.project;

import com.project.user.User;
import com.project.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/login")
    public String showLoginPage() {
        return "index";
    }

    @PostMapping("/login")
    public String processLogin(String email, String password, Model model) {
        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("message", "Login successful!");
            return "redirect:/dashboard/" + user.getId();
        } else {
            model.addAttribute("message", "Invalid email or password");
            return "index";
        }
    }

}

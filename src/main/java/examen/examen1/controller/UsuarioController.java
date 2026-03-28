package examen.examen1.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    @GetMapping("/index")
    public String index(Model model) {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        String username = "";
        if (auth != null && auth.isAuthenticated() && !(auth.getPrincipal() instanceof String)) {
            username = ((UserDetails) auth.getPrincipal()).getUsername();
        }
        model.addAttribute("username", username);
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) auth.getPrincipal()).getUsername();
        model.addAttribute("username", username);
        return "home";
    }
}

package de.fred4jupiter.swagger.demo.contract.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home redirection to swagger controller documentation
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "redirect:swagger-ui.html";
    }
}
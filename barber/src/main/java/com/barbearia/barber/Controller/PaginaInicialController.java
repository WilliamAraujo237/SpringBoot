package com.barbearia.barber.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaInicialController {
    @GetMapping("/home")
    public String home(){
        return "index";
    }
}

package br.com.iagoomes.mudi.controller;

import br.com.iagoomes.mudi.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final PedidoRepository repository;

    public HomeController(PedidoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute("pedidos", repository.findAll());
        return "home";
    }
}

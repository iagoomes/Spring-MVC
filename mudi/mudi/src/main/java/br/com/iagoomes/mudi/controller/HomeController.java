package br.com.iagoomes.mudi.controller;

import br.com.iagoomes.mudi.model.StatusPedido;
import br.com.iagoomes.mudi.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

    private final PedidoRepository repository;

    public HomeController(PedidoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("pedidos", repository.findAll());
        return "home";
    }

    @GetMapping("{status}")
    public String porStatus(@PathVariable("status") String status, Model model) {
        model.addAttribute("pedidos", repository.findByStatus(StatusPedido.valueOf(status.toUpperCase())));
        model.addAttribute("status",status);
        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
}

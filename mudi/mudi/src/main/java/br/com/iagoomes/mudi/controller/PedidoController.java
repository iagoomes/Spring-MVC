package br.com.iagoomes.mudi.controller;

import br.com.iagoomes.mudi.dto.PedidoDto;
import br.com.iagoomes.mudi.model.Pedido;
import br.com.iagoomes.mudi.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("pedido")
public class PedidoController {

    private final PedidoRepository repository;

    public PedidoController(PedidoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("formulario")
    public String formulario(PedidoDto dto) {
        return "pedido/novo-pedido";
    }

    @PostMapping("novo")
    public String novo(@Valid PedidoDto requesicao, BindingResult result) {
        if (result.hasErrors()) {
            return "pedido/novo-pedido";
        }
        Pedido pedido = requesicao.toPedido();
        repository.save(pedido);

        return "redirect:/home";
    }

}

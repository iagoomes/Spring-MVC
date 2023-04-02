package br.com.iagoomes.mudi.controller;

import br.com.iagoomes.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("home")
    public String home(Model model) {
       Pedido pedido = new Pedido();
       pedido.setNomeProduto("Xiaomi Redmi Note 8");
       pedido.setUrlImagem("https://m.media-amazon.com/images/I/519dVen0lmL._AC_SX679_.jpg");
       pedido.setUrlProduto("https://www.amazon.com.br/Smartphone-Redmi-Note-11-128GB/dp/B09QSCYS1J/ref=sr_1_29?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=9P26N4F7E8PQ&keywords=xiaomi+redmi+note+8&qid=1680285773&sprefix=xiaomi+redmi+note+8%2Caps%2C254&sr=8-29&ufe=app_do%3Aamzn1.fos.25548f35-0de7-44b3-b28e-0f56f3f96147");
       pedido.setDescricao("celular com uma explosão de performance");

        List<Pedido> pedidos = Arrays.asList(pedido);
        model.addAttribute("pedidos", pedidos);

        return "home";
    }
}

package com.kloster.carrinho;

import com.kloster.itemcarrinho.ItemCarrinho;
import com.kloster.pedido.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping
    public Carrinho criarCarrinho(@RequestBody Carrinho carrinhoDeCompras) {
        return carrinhoService.criarCarrinho(carrinhoDeCompras);
    }

    @GetMapping("/{id}")
    public Carrinho getCarrinho(@PathVariable Long id) {
        return carrinhoService.getCarrinho(id);
    }

    @PostMapping("/{carrinhoId}/adicionarItem")
    public Carrinho adicionarItem(@PathVariable Long carrinhoId, @RequestBody ItemCarrinho item) {
        return carrinhoService.adicionarItem(carrinhoId, item);
    }

    @PostMapping("/{carrinhoId}/removerItem")
    public Carrinho removerItem(@PathVariable Long carrinhoId, @RequestBody ItemCarrinho item) {
        return carrinhoService.removerItem(carrinhoId, item);
    }

    @PostMapping("/{carrinhoId}/fecharPedido")
    public Pedido fecharPedido(@PathVariable Long carrinhoId) {
        return carrinhoService.fecharPedido(carrinhoId);
    }

}
package com.kloster.carrinho;

import com.kloster.itemcarrinho.ItemCarrinho;
import com.kloster.pedido.Pedido;
import com.kloster.pedido.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarrinhoService {


    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private PedidoService pedidoService;

    public Carrinho criarCarrinho(Carrinho carrinhoDeCompras) {
        return carrinhoRepository.save(carrinhoDeCompras);
    }

    public Carrinho getCarrinho(Long id) {
        return carrinhoRepository.findById(id).orElse(null);
    }


    public Carrinho adicionarItem(Long carrinhoId, ItemCarrinho item) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId).orElse(null);
        if (carrinho != null) {
            carrinho.adicionarItem(item.getProduto(), item.getQuantidade());
            return carrinhoRepository.save(carrinho);
        }
        return null;
    }

    public Carrinho removerItem(Long carrinhoId, ItemCarrinho item) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId).orElse(null);
        if (carrinho != null) {
            carrinho.removerItem(item.getProduto(), item.getQuantidade());
            return carrinhoRepository.save(carrinho);
        }
        return null;
    }

    public Pedido fecharPedido(Long carrinhoId) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId).orElse(null);
        if (carrinho != null) {
            Pedido pedido = new Pedido();
            pedido.setCliente(carrinho.getCliente());
            pedido.setItens(carrinho.getItens());
            pedido.setTotal(carrinho.getTotal());
            // Salve o pedido no banco de dados
            pedido = pedidoService.fazerPedido(pedido);
            // Limpe o carrinho após fechar o pedido
            carrinho.limparCarrinho();
            carrinhoRepository.save(carrinho);
            return pedido;
        }
        return null;
    }
}

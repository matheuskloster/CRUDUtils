package com.kloster.pedido;

import com.kloster.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido fazerPedido(Pedido pedido) {
        // Verificar se os produtos existem
        pedido.getItens().forEach(item -> {
            if (produtoRepository.findById(item.getProduto().getId()).isEmpty()) {
                throw new RuntimeException("Produto não encontrado");
            }
        });

        //Atualizar estoque após pedido
        pedido.getItens().forEach(item -> {
            var produto = produtoRepository.findById(item.getProduto().getId()).get();
            produto.setQuantidade(produto.getQuantidade() - item.getQuantidade());
            produtoRepository.save(produto);
        });

        // Calcular o valor total do pedido
        pedido.setTotal(pedido.getItens().stream()
                .map(item -> item.getProduto().getPreco() * item.getQuantidade())
                .reduce(0.0, Double::sum));

        // Salvar o pedido no banco de dados
        return pedidoRepository.save(pedido);
    }

    public Pedido getPedido(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    // Implemente os métodos para atualizar e excluir pedidos
}
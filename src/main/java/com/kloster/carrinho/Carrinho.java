package com.kloster.carrinho;

import com.kloster.cliente.Cliente;
import com.kloster.itemcarrinho.ItemCarrinho;
import com.kloster.produto.Produto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "carrinho")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id") // Define o nome da coluna na tabela "carrinho" que referencia o cliente
    private Cliente cliente;
    private double total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCarrinho> itens = new ArrayList<>();


    public void adicionarItem(Produto produto, int quantidade) {
        boolean encontrado = false;
        // Verifica se o produto já está no carrinho
        for (ItemCarrinho item : itens) {
            if (item.getProduto().equals(produto)) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                encontrado = true;
                break;
            }
        }
        // Se o produto não estiver no carrinho, adiciona um novo item
        if (!encontrado) {
            itens.add(new ItemCarrinho(produto, quantidade));
        }
        // Atualiza o total do carrinho
        calcularTotal();
    }

    public void removerItem(Produto produto, int quantidade) {
        // Implemente a lógica para remover itens do carrinho
    }

    private void calcularTotal() {
        total = 0.0;
        for (ItemCarrinho item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
    }

    public void limparCarrinho() {
        itens.clear();
        total = 0.0;
    }
}
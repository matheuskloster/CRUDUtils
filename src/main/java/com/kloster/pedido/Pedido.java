package com.kloster.pedido;

import com.kloster.cliente.Cliente;
import com.kloster.itemcarrinho.ItemCarrinho;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemCarrinho> itens = new ArrayList<>();
    private double total;
    private String status;
}

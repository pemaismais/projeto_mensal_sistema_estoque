/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_mensal.src.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author henri
 */
@Entity
@Table(name = "itens_entrada")
public class ItemEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "entrada_id")
    private Entrada entrada;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "quantidade")
    private float quantidade;

    public ItemEntrada() {
    }

    public ItemEntrada(Entrada entrada, Produto produto, float quantidade) {
        this.entrada = entrada;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public float getValorTotal() {
        float valorItem = this.produto.getPreco();
        float valorTotal = valorItem * this.quantidade;
        return valorTotal;
    }

    public String getProdutoNome() {
        return this.produto.getNome();
    }

    public int getProdutoId() {
        return this.produto.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

}

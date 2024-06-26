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
@Table(name = "itens_saida")
public class ItemSaida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "saida_id")
    private Saida saida;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "quantidade")
    private float quantidade;

    public ItemSaida() {
    }

    public ItemSaida(Saida saida, Produto produto, float quantidade) {
        this.saida = saida;
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

    public Saida getSaida() {
        return saida;
    }

    public void setSaida(Saida saida) {
        this.saida = saida;
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

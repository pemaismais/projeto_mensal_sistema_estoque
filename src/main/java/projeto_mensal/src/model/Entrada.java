/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_mensal.src.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author henri
 */

@Entity
@Table(name = "entradas")
public class Entrada implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    
    @OneToOne(mappedBy = "entrada", cascade = CascadeType.ALL)
    private ItemEntrada item;
    
    @Column(name = "data_entrada")
    private Date dataEntrada;
    
    @Column(name = "observacoes")
    private String observacoes;

    public Entrada() {
    }   
    public void removerItem() {
        

    }
    public float getValorTotal(){
       return this.item.getValorTotal();
    }
    public float getQuantidade(){
        return this.item.getQuantidade();
    }
    public String getNomeFornecedor(){
        return this.fornecedor.getNome();
    }
    public String getNomeProduto(){
        return this.item.getProdutoNome();
    }
        public int getIdFornecedor(){
        return this.fornecedor.getId();
    }
            public int getIdProduto(){
        return this.item.getProdutoId();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public ItemEntrada getItem() {
        return item;
    }

    public void setItem(ItemEntrada item) {
        this.item = item;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    

}
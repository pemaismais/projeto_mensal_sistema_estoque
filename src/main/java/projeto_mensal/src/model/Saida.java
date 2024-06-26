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
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author henri
 */
@Entity
@Table(name = "saidas")
public class Saida implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne(mappedBy = "saida", cascade = CascadeType.ALL)
    private ItemSaida item;
    
    @Column(name = "data_saida")
    private Date dataSaida;
    
    @Column(name = "observacoes")
    private String observacoes;

    public Saida() {
    }
    public float getValorTotal(){
       return this.item.getValorTotal();
    }
    public float getQuantidade(){
        return this.item.getQuantidade();
    }
    public String getNomeProduto(){
        return this.item.getProdutoNome();
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

    public ItemSaida getItem() {
        return item;
    }

    public void setItem(ItemSaida item) {
        this.item = item;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    
}

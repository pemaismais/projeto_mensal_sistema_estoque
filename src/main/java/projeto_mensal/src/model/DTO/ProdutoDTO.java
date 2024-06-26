/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_mensal.src.model.DTO;

/**
 *
 * @author henri
 */
public class ProdutoDTO {

    private int id;
    private String nome;
    private String preco;
    private String tipo;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nome, String preco, String tipo) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }

    public ProdutoDTO(int id, String nome, String preco,  String tipo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }

    public float precoParaFloat() {
        try {
            return Float.parseFloat(this.preco);
        } catch (Exception e) {
            throw new NumberFormatException("Valor do preço deve ser um número válido.");
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return preco;
    }

    public void setValor(String preco) {
        this.preco = preco;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}

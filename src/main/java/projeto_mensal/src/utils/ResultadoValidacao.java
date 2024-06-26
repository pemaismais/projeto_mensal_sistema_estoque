/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_mensal.src.utils;

/**
 *
 * @author henri
 */
public class ResultadoValidacao {
    private boolean valido;
    private String mensagem;

    public ResultadoValidacao() {
        this.valido = false;
        this.mensagem = "";
    }
    public ResultadoValidacao(boolean valid, String msg){
        this.valido = valid;
        this.mensagem = msg;
    }
    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
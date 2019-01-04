/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alocacao.dominio;

/**
 *
 * @author Kimbelly
 */
public class Alocacao {
    private int idAlocacao;
    private int idCliente;
    private int tipoCarro;
    private String dataRetirada;
    private String dataDevolucao;
    private int filialRetirada;
    private int filialDevolucao;

    public int getIdAlocacao() {
        return idAlocacao;
    }

    public void setIdAlocacao(int idAlocacao) {
        this.idAlocacao = idAlocacao;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getTipoCarro() {
        return tipoCarro;
    }

    public void setTipoCarro(int tipoCarro) {
        this.tipoCarro = tipoCarro;
    }

    public String getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(String dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getFilialRetirada() {
        return filialRetirada;
    }

    public void setFilialRetirada(int filialRetirada) {
        this.filialRetirada = filialRetirada;
    }

    public int getFilialDevolucao() {
        return filialDevolucao;
    }

    public void setFilialDevolucao(int filialDevolucao) {
        this.filialDevolucao = filialDevolucao;
    }
    
    

    
}

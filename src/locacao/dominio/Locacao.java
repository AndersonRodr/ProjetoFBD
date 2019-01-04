/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao.dominio;

/**
 *
 * @author Kimbelly
 */
public class Locacao {
    private int idlocacao;
    private int idCliente;
    private int tipoCarro;
    private String dataRetirada;
    private String dataDevolucao;
    private int cnhMotorista;
    private String placaVeiculo;

    public int getIdlocacao() {
        return idlocacao;
    }

    public void setIdlocacao(int idlocacao) {
        this.idlocacao = idlocacao;
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
     public int getCnhMotorista() {
        return cnhMotorista;
    }

    public void setCnhMotorista(int cnhMotorista) {
        this.cnhMotorista = cnhMotorista;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
}

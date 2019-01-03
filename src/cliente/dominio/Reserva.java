/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.dominio;

/**
 *
 * @author bruno.an
 */
public class Reserva {
    private int idReserva;
    private int idCliente;
    private int tipoCarro;
    private String dataRetirada;
    private String dataDevolucao;
    private int filialRetirada;
    private int filialDevolucao;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserva.dominio;

/**
 *
 * @author bruno.an
 */
public class Reserva {
    private String dataRetirada;
    private String dataDevolucao;
    private int idFilialOrigem;
    private int idFilialDevolucao;
    private int idTipoVeiculo;
    private int idCliente;
    private int idReserva;
    private String CpfCnpj;
    
    public int getIdReserva() {
        return this.idReserva;
    }
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
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

    public int getIdFilialOrigem() {
        return idFilialOrigem;
    }

    public void setIdFilialOrigem(int idFilialOrigem) {
        this.idFilialOrigem = idFilialOrigem;
    }

    public int getIdFilialDevolucao() {
        return idFilialDevolucao;
    }

    public void setIdFilialDevolucao(int idFilialDevolucao) {
        this.idFilialDevolucao = idFilialDevolucao;
    }

    public int getIdTipoVeiculo() {
        return idTipoVeiculo;
    }

    public void setIdTipoVeiculo(int idTipoVeiculo) {
        this.idTipoVeiculo = idTipoVeiculo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
     public String getCpfCnpj() {
        return this.CpfCnpj;
    }

    public void setCpfCnpj(String CpfCnpj) {
        this.CpfCnpj = CpfCnpj;
    }   
    
}

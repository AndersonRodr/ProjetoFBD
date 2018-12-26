/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculo.dominio;

import java.util.Date;

/**
 *
 * @author bruno.an
 */
public class Veiculo {
    private String placa;
    private String numeroChassi;
    private String numeroMotor;
    private String cor;
    private int quilometragem;
    private String dataMediaKM;
    private String ultimaRevisao;
    private int tipoVeiculo;
    private int filial;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNumeroChassi() {
        return numeroChassi;
    }

    public void setNumeroChassi(String numeroChassi) {
        this.numeroChassi = numeroChassi;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getDataMediaKM() {
        return dataMediaKM;
    }

    public void setDataMediaKM(String dataMediaKM) {
        this.dataMediaKM = dataMediaKM;
    }

    public String getUltimaRevisao() {
        return ultimaRevisao;
    }

    public void setUltimaRevisao(String ultimaRevisao) {
        this.ultimaRevisao = ultimaRevisao;
    }

    public int getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(int tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public int getFilial() {
        return filial;
    }

    public void setFilial(int filial) {
        this.filial = filial;
    }
    
    
    
    
    
}

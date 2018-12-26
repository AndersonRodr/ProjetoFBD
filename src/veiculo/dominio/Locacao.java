/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculo.dominio;

/**
 *
 * @author bruno.an
 */
public class Locacao {
    private int cnhMotorista;
    private String placaVeiculo;
    private String DataRetirada;
    private String dataDevolucao;

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

    public String getDataRetirada() {
        return DataRetirada;
    }

    public void setDataRetirada(String DataRetirada) {
        this.DataRetirada = DataRetirada;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    
    
}

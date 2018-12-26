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
public class TipoVeiculo {
   private int idTipoVeiculo;
   private String horasLimpeza;
   private int quilometragem;
   private String Tamanho;
   private int qtdAr;
   private String radio;
   private String mp3;
   private String direcaoHidraulica;
   private String cambioAutomatico;
   private String nome;
   private int capacidadeCarga;
            

    public int getIdTipoVeiculo() {
        return idTipoVeiculo;
    }

    public void setIdTipoVeiculo(int idTipoVeiculo) {
        this.idTipoVeiculo = idTipoVeiculo;
    }

    public String getHorasLimpeza() {
        return horasLimpeza;
    }

    public void setHorasLimpeza(String horasLimpeza) {
        this.horasLimpeza = horasLimpeza;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getTamanho() {
        return Tamanho;
    }

    public void setTamanho(String Tamanho) {
        this.Tamanho = Tamanho;
    }

    public int getQtdAr() {
        return qtdAr;
    }

    public void setQtdAr(int qtdAr) {
        this.qtdAr = qtdAr;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public String getDirecaoHidraulica() {
        return direcaoHidraulica;
    }

    public void setDirecaoHidraulica(String direcaoHidraulica) {
        this.direcaoHidraulica = direcaoHidraulica;
    }

    public String getCambioAutomatico() {
        return cambioAutomatico;
    }

    public void setCambioAutomatico(String cambioAutomatico) {
        this.cambioAutomatico = cambioAutomatico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(int capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }
  
    
}

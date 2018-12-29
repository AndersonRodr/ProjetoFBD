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
public class Motorista {
    private int cnh;
    private int id_cliente;
    private String dataVencimento;
    private int rg;
    private String nome;

    public int getCnh() {
        return cnh;
    }

    public void setCnh(int cnh) {
        this.cnh = cnh;
    }

    public int getIdCliente() {
        return id_cliente;
    }

    public void setIdCliente(int cliente) {
        this.id_cliente = cliente;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataNascimento) {
        this.dataVencimento = dataNascimento;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}

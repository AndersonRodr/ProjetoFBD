package veiculo.service;

import veiculo.dao.VeiculoDao;
import veiculo.dominio.Veiculo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno.an
 */
public class VeiculoService {
    
    
    public boolean cadastrarVeiculo(Veiculo veiculo){
        VeiculoDao dao = new VeiculoDao();
        return dao.inserirVeiculo(veiculo);
        
    }
    
    public Veiculo buscarVeiculo(String placa){
        VeiculoDao dao = new VeiculoDao();
        return dao.buscarVeiculo(placa);
    }
    
    public boolean isVeiculo(String Placa){
        VeiculoDao dao = new VeiculoDao();
        return dao.isVeiculoCadastrado(Placa);
    }
    
    public void deletarVeiculo(String placa){
        VeiculoDao dao = new VeiculoDao();
        dao.deletarVeiculo(placa);
    }
    
}

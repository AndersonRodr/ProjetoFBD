/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao.service;

import cliente.dao.ClientePessoaDAO;
import cliente.dominio.Reserva;
import locacao.dominio.Locacao;

/**
 *
 * @author Kimbelly
 */
public class LocacaoService {
    
    public void validarDatas(String retirada, String devolucao){
        
    }
     public void doLocacao(Locacao locacao){
        ClientePessoaDAO dao = new ClientePessoaDAO();
        dao.doLocacao(locacao);
        
    }
    
}


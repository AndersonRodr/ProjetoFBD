/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao.service;

import cliente.dao.ClientePessoaDAO;
import cliente.dominio.Reserva;
import cliente.service.Servico;
import javax.swing.JOptionPane;
import locacao.dominio.Locacao;
import reserva.service.ReservaService;

/**
 *
 * @author Kimbelly
 */
public class LocacaoService {
    Servico service = new Servico();
    
    public boolean isValidoDatas(String dataRetirada, String dataDevolucao){
        ReservaService rService = new ReservaService(); //Para reaproveitar o codigo de validacao 
        if((service.isEmpty(dataRetirada)|service.isEmpty(dataDevolucao))){
            return false;
       // }if(!rService.validarDatas(dataRetirada, dataDevolucao)){
         //   return false;
        }
        return true;
    }
    public boolean isValidoCNH(String cnh){
         try {
            int cnhMotorista = Integer.parseInt(cnh);
         } catch (NumberFormatException e) {
             return false;
         }
         
         if((service.isEmpty(cnh))){
            return false;
         }
         return true;
    }
    public boolean isValidoPlaca(String placa){
        //TEM OUTRAS VALIDAÇÕES AINDA
        if((service.isEmpty(placa))){
            return false;
        }
        return true;
    }
    public boolean isValidoMotorista(){
        return true;
    }
    public boolean isValidoIdClienteCPFouCNPJ(String cpfOuCNPJ){
        return true;
    }
    public boolean validarTodosOsDados(String dataRetirada, String dataDev,String cnh, String placa){
        if(isValidoDatas(dataRetirada,dataDev)){
            
        }if(isValidoCNH(cnh)){
            
        }if(isValidoPlaca(placa)){
            
        }if(isValidoMotorista()){
            
        }
        return true;
        
    }
    public void doLocacao(Locacao locacao){
        ClientePessoaDAO dao = new ClientePessoaDAO();
        dao.doLocacao(locacao);
        
    }
    
}


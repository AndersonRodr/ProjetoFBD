/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserva.service;

import cliente.dao.ClientePessoaDAO;
import cliente.dominio.Reserva;
import java.util.Calendar;

/**
 *
 * @author bruno.an
 */
public class ReservaService {

    public boolean validarDatas(String retirada, String devolucao){
        try{
            String anoRetirada = retirada.substring(0,4);
        int anoDigitadoRetirada = Integer.parseInt(anoRetirada);
        String diaRetirada = retirada.substring(8, 10);
        int diaDigitadoRetirada = Integer.parseInt(diaRetirada);
        String mesRetirada = retirada.substring(5, 7);
        int mesDigitadoRetirada = Integer.parseInt(mesRetirada);
        
        String anoDevolucao = devolucao.substring(0,4);
        int anoDigitadoDevolucao = Integer.parseInt(anoDevolucao);
        String diaDevolucao = devolucao.substring(8, 10);
        int diaDigitadoDevolucao = Integer.parseInt(diaDevolucao);
        String mesDevolucao = devolucao.substring(5, 7);
        int mesDigitadoDevolucao = Integer.parseInt(mesDevolucao);
        
        Calendar cal = Calendar.getInstance();
        int diaAtual = cal.get(Calendar.DATE);
        int mesAtual = cal.get(Calendar.MONTH)+1;
        int anoAtual = cal.get(Calendar.YEAR);
        
        //Validacoes para ver se o data é valida
        if(anoDigitadoRetirada < anoAtual){
            return false;

        }else{
            if(mesDigitadoRetirada < mesAtual){
                return false;
            }else{
                if(diaDigitadoRetirada < diaAtual){
                    return false;
                }
            }
        }
        //Validacao data devolucao menor que hoje
        if(anoDigitadoDevolucao < anoAtual){
            return false;
        }else{
            if(mesDigitadoDevolucao < mesAtual){
                return false;
            }else{
                if(diaDigitadoDevolucao < diaAtual){
                    return false;
                }
            }
        }
            
         //Validacoes de devolucao menor que retirada
        if(anoDigitadoDevolucao < anoDigitadoRetirada){
            return false;
        }else{
            if(mesDigitadoDevolucao < mesDigitadoRetirada){
                return false;
            }else{
                if(diaDigitadoDevolucao < diaDigitadoRetirada){
                    return false;
                }
            }
        }
        return true;
            
        }catch(Exception ex){
            return false;
        }
        
    }
    
    public void doReserva(Reserva reserva){
        ClientePessoaDAO dao = new ClientePessoaDAO();
        dao.doReserva(reserva);
        
    }
    
}

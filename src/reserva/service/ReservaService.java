/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserva.service;

import cliente.dao.ClientePessoaDAO;
import java.util.Calendar;
import reserva.dominio.Reserva;

/**
 *
 * @author bruno.an
 */
public class ReservaService {

    public boolean validarDatas(String dataRetirada, String dataDev){
        try{
            String anoRetirada = dataRetirada.substring(0, 4);
            int anoDigitadoRetirada = Integer.parseInt(anoRetirada);

            String diaRetirada = dataRetirada.substring(8, 10);
            int diaDigitadoRetirada = Integer.parseInt(diaRetirada);

            String mesRetirada = dataRetirada.substring(5, 7);
            int mesDigitadoRetirada = Integer.parseInt(mesRetirada);
            System.out.println(mesRetirada);
            Calendar cal = Calendar.getInstance();
            int diaAtual = cal.get(Calendar.DATE);
            int mesAtual = cal.get(Calendar.MONTH)+1;
            int anoAtual = cal.get(Calendar.YEAR);

            String anoDevolucao = dataDev.substring(0, 4);
            int anoDigitadoDevolucao = Integer.parseInt(anoDevolucao);

            String diaDevolucao = dataDev.substring(8, 10);
            int diaDigitadoDev = Integer.parseInt(diaDevolucao);

            String mesDevolucao = dataDev.substring(5, 7);
            int mesDigitadoDevolucao = Integer.parseInt(mesDevolucao);

            //Validacoes para ver se o data é valida
            if(anoDigitadoDevolucao < anoDigitadoRetirada || mesDigitadoRetirada>12 || mesDigitadoDevolucao>12){
               return false; 
            }else{
                if(mesDigitadoRetirada <mesAtual){
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
                    if(diaDigitadoDev < diaAtual){
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
                    if(diaDigitadoDev < diaDigitadoRetirada){
                        return false;
                    }
                }
            }    
        }
        catch(Exception ex){
            return false;
        }
        return true;
    }
    
    public void doReserva(Reserva reserva){
        ClientePessoaDAO dao = new ClientePessoaDAO();
        dao.doReserva(reserva);
        
    }
    
}

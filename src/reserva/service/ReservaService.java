/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserva.service;

import cliente.dao.ClientePessoaDAO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import locacao.dominio.Locacao;
import reserva.dao.ReservaDAO;
import reserva.dominio.Reserva;

/**
 *
 * @author bruno.an
 */
public class ReservaService {
    
    private ReservaDAO resDao = new ReservaDAO();
    
    public void doReserva(Reserva reserva){
        resDao.doReserva(reserva);      
    }
    
    public boolean verificarDatas(String dataReservaa, String dataDevolucaoo) throws ParseException{
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        Calendar cal = Calendar.getInstance();
        int diaAtual = cal.get(Calendar.DATE);
        int mesAtual = cal.get(Calendar.MONTH)+1;
        int anoAtual = cal.get(Calendar.YEAR);
        String dataAtuaal = String.valueOf(diaAtual) + "/" + String.valueOf(mesAtual) + "/" + String.valueOf(anoAtual);
        
        Calendar dataReserva = new GregorianCalendar();
        Calendar dataDevolucao = new GregorianCalendar();
        Calendar dataAtual = new GregorianCalendar();

        dataReserva.setTime(format.parse(dataReservaa));
        dataDevolucao.setTime(format.parse(dataDevolucaoo));
        dataAtual.setTime(format.parse(dataAtuaal));

        if (dataAtual.getTimeInMillis() > dataReserva.getTimeInMillis()){
//            System.out.println("Data de reserva inválida");
            return false;
        }        
        else if(dataReserva.getTimeInMillis() > dataDevolucao.getTimeInMillis()){
//            System.out.println("A data de reserva deve ser menor do que a de entrega");
            return false;
        }
        else if (dataDevolucao.getTimeInMillis() < dataAtual.getTimeInMillis()){
            return false;
        }
        else{
//            System.out.println("Data correta");
            return true;
        }            
    }
    
    public ArrayList<Reserva> getListaReservas(){
        ArrayList<Reserva> listaReservas = resDao.getListaReserva();
        return listaReservas;
    }
    
    public ArrayList<Reserva> getPFisica(ArrayList<Reserva> r) throws SQLException{
        ArrayList<Reserva> listaReservas = resDao.getListaPFisica(r);
        return listaReservas;
    }
    
    public ArrayList<Reserva> getPJuridica(ArrayList<Reserva> r) throws SQLException{
        ArrayList<Reserva> listaReservas = resDao.getListaPJuridica(r);
        return listaReservas;
    }
    
    public boolean removerReserva(int idReserva) throws SQLException{
        if (!resDao.removerReserva(idReserva)){
            return false;
        }
       return true; 
    }
      
}

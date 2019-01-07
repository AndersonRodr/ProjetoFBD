/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao.service;

import cliente.dao.ClientePessoaDAO;
import cliente.dominio.Motorista;
import cliente.dominio.Reserva;
import cliente.service.Servico;
import cliente.service.ServicoClienteCNPJ;
import cliente.service.ServicoClienteCPF;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import locacao.dao.LocacaoDAO;
import locacao.dominio.Locacao;
import reserva.service.ReservaService;
import veiculo.dao.VeiculoDao;
import veiculo.dominio.Veiculo;

/**
 *
 * @author Kimbelly
 */
public class LocacaoService {
    Servico service = new Servico();
    LocacaoDAO daoLocacao = new LocacaoDAO();
    
    public boolean isIntervaloDatasCerto(String dataRetirada, String dataDev) {
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
  
    public boolean isValidoDatas(String dataRetirada, String dataDevolucao){
        
        if((service.isEmpty(dataRetirada)||service.isEmpty(dataDevolucao))){
            return false;
       
        }if(!isIntervaloDatasCerto(dataRetirada, dataDevolucao)){
           return false;
        }
        return true;
    }
    public boolean isValidoCNH(String cnh){
        int cnhMotorista =0;
         try {
            cnhMotorista = Integer.parseInt(cnh);
         } catch (NumberFormatException e) {
             return false;
         }
         
         if((service.isEmpty(cnh)||!(cnh.length()==11))){
            return false;
         }else{
             Motorista motoristaEnc = service.buscarMotoristaPelaCNH(cnhMotorista);
             if (motoristaEnc==null){
                 return false;
             }
         }
         return true;
    }
    public Motorista buscarMotorista(String cnh){
        int cnhMotorista = Integer.parseInt(cnh);
        Motorista motorista = service.buscarMotoristaPelaCNH(cnhMotorista);
        return motorista;
    }
    public Motorista buscarMotorista(String cnh, String idCliente){
        Motorista motorista = null;
        return motorista;
    }
    public boolean isValidoPlaca(String placa){
        //TEM OUTRAS VALIDAÇÕES AINDA
        //Aq pode ta errado hm
        if((service.isEmpty(placa)||!(placa.trim().length()==7))){
            return false;
        }
        VeiculoDao dao = new VeiculoDao();
        Veiculo veiculo = dao.buscarVeiculo(placa);
        if(veiculo==null){
            return false;
        }
        return true;
    }
    public boolean isValidoMotorista(String cnh){
        if (!isValidoCNH(cnh)){
            return false;
        }
        return true;
    }
    public boolean isCPFvalidadorDigCerto(String cpf){
        ServicoClienteCPF serviceClienteCPF = new ServicoClienteCPF(cpf);
        if(cpf.length()<11 || cpf.length()>11 || !serviceClienteCPF.isCPF()){
            return false;
        }
        
        return true;
    }
    public boolean isCNPJvalidadorDigCerto(String cnpj){
        ServicoClienteCNPJ serviceClienteCNPJ = new ServicoClienteCNPJ(cnpj,"nadaAqui");
        serviceClienteCNPJ.setCNPJ(cnpj);
        if(cnpj.length()<14 || cnpj.length()>14 || !serviceClienteCNPJ.isCNPJ()){
            return false;
        }
        return true;
    }
    
    public boolean isValidoIdClienteCPFouCNPJ(String cpfOuCNPJ,String tipoFisOuJur){
        if(!service.isEmpty(cpfOuCNPJ)){
            return false;
        }
        if(tipoFisOuJur.equals("1")){
            if(!isCPFvalidadorDigCerto(cpfOuCNPJ) || !service.buscarCPF(cpfOuCNPJ)){
                return false;
            }
        }else{
            if(!isCNPJvalidadorDigCerto(cpfOuCNPJ) || !service.buscarCNPJ(cpfOuCNPJ)){
                return false;
            }
        }
        return true;
    }
    public boolean isLocacaoDisponivel(String dataRetirada, String dataDev, String placaVeic) throws SQLException{
        if(daoLocacao.veiculoJaAlocadoMesmoDia(dataRetirada, dataDev, placaVeic)){
            return false;
        }
        return true;
    }
    public boolean validarTodosOsDados(String dataRetirada, String dataDev,String cnh, String placa) throws SQLException{
        if(!isValidoDatas(dataRetirada,dataDev) || !isValidoCNH(cnh) || !isValidoPlaca(placa) || !isValidoMotorista(cnh)){
            return false;
        }if (!isLocacaoDisponivel(dataRetirada, dataDev, placa)){
            return false;
        }
        return true;
        
    }
    public void doLocacao(Locacao locacao){
        daoLocacao.doLocacao(locacao);
    }
    public ArrayList<Locacao> getListaLocacoes(){
        ArrayList<Locacao> listaLocacoes = daoLocacao.getListaLocacoes();
        return listaLocacoes;
    }
    //fazer dif buscas conforme os dados buscados
    public Locacao buscarLocacao(){
        Locacao locacaoBuscada = null;
        return locacaoBuscada;
    }
    
    public boolean removerLocacao(String dataRetirada, String dataDev, String placaVeic) throws SQLException{
        if (!daoLocacao.removerLocacao(dataRetirada, dataDev, placaVeic)){
            return false;
        }
       return true; 
    }
    public boolean removerLocacaoPeloId(int idLocacao){
         if (!daoLocacao.removerLocacaoPeloId(idLocacao)){
            return false;
        }
        return true;
    }
    public boolean removerTodasLocacoes(){
        if (!daoLocacao.removerTodasLocacoes()){
            return false;
        }
        return true;
    }
    
}


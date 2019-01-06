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
  
    public boolean isValidoDatas(String dataRetirada, String dataDevolucao){
        ReservaService rService = new ReservaService(); //Para reaproveitar o codigo de validacao 
        if((service.isEmpty(dataRetirada)||service.isEmpty(dataDevolucao))){
            return false;
       
        }if(!rService.validarDatas(dataRetirada, dataDevolucao)){
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
        if(!serviceClienteCPF.isCPF()){
            return false;
        }
        
        return true;
    }
    public boolean isCNPJvalidadorDigCerto(String cnpj){
        ServicoClienteCNPJ serviceClienteCNPJ = new ServicoClienteCNPJ(cnpj,"nadaAqui");
        serviceClienteCNPJ.setCNPJ(cnpj);
        if(!serviceClienteCNPJ.isCNPJ()){
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
    public boolean isLocacaoDisponivel(String dataRetirada, String dataDev, String placaVeic){
        if(daoLocacao.veiculoJaAlocadoMesmoDia(dataRetirada, dataDev, placaVeic)){
            return false;
        }
        return true;
    }
    public boolean validarTodosOsDados(String dataRetirada, String dataDev,String cnh, String placa){
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
    
    public boolean removerLocacao(String dataRetirada, String dataDev, String placaVeic){
        if (!daoLocacao.removerLocacao(dataRetirada, dataDev, placaVeic)){
            return false;
        }
       return true; 
    }
    
}


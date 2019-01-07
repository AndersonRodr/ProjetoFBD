package cliente.service;

import cliente.dao.ClientePessoaDAO;
import cliente.dominio.Cliente;
import cliente.dominio.Motorista;
import cliente.dominio.PessoaFisica;
import cliente.dominio.PessoaJuridica;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Servico {
    ClientePessoaDAO dao = new ClientePessoaDAO();
    
    public boolean isEmpty(String campo){
       if (campo.length() == 0){
           return true;
       }
       else{
           return false;
       }
    }
    
    public boolean validarIdade(String nascimento){
        String ano = nascimento.substring(6, 10);
        int anoDigitado = Integer.parseInt(ano);

        String dia = nascimento.substring(0, 2);
        int diaDigitado = Integer.parseInt(dia);

        String mes = nascimento.substring(3, 5);
        int mesDigitado = Integer.parseInt(mes);

        Calendar cal = Calendar.getInstance();
        int diaAtual = cal.get(Calendar.DATE);
        int mesAtual = cal.get(Calendar.MONTH)+1;
        int anoAtual = cal.get(Calendar.YEAR);

        if (anoAtual - anoDigitado > 18) {
            return true;
        }
        else if (anoAtual - anoDigitado == 18 && mesDigitado < mesAtual){
            return true;
        }
        else if(anoAtual - anoDigitado == 18 && mesDigitado == mesAtual && diaDigitado <= diaAtual){
            return true;
        }

        else {
            return false;
        }
    }
    
    public String formatarCpfSaida(String cpf){
        String cpf1 = cpf.substring(0,3);
        String cpf2 = cpf.substring(3,6);
        String cpf3 = cpf.substring(6,9);
        String cpf4 = cpf.substring(9,11);
        return cpf1 + "." + cpf2 + "." + cpf3 + "-" + cpf4;
    }
    
    public String formatarCpfEntrada(String cpf){
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        return cpf;
    }

    public String formatarCnpjEntrada(String cnpj){
        cnpj = cnpj.replace(".", "");
        cnpj = cnpj.replace("/", "");
        cnpj = cnpj.replace("-", "");
        return cnpj;        
    }
    
    public String formatarDataSaida(String nasc){
        String ano = nasc.substring(0, 4);
        String dia = nasc.substring(8, 10);
        String mes = nasc.substring(5, 7);
        String nascimento = dia+"/"+mes+"/"+ano;
        return nascimento;
    }
    
    public String formatarDataEntrada(String nasc){
        String ano = nasc.substring(6, 10);
        String dia = nasc.substring(0, 2);
        String mes = nasc.substring(3, 5);
        return ano+"-"+mes+"-"+dia;
    }
    
    public boolean cadClientePFisica(Cliente cliente, PessoaFisica pessoa) throws SQLException{
        boolean cadastroSucesso = dao.inserirCliente(cliente);
        if (cadastroSucesso){
            if (inserirPFisica(pessoa));{
                return true;
            }
        }
        else{
            return false;
        }
    }
    
    public boolean cadClientePJuridica(Cliente cliente, PessoaJuridica pessoa) throws SQLException{
        boolean cadastroSucesso = dao.inserirCliente(cliente);
        if (cadastroSucesso){
            if (inserirPJuridica(pessoa));{
                return true;
            }
        }
        else{
            return false;
        }
    }      
    
    public boolean buscarCPF(String cpf){
        if (dao.verificarCpfBD(cpf)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean buscarCNPJ(String cnpj){
        if (dao.verificarCnpjBD(cnpj)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean inserirPFisica(PessoaFisica pessoa) throws SQLException{
        int idCliente = dao.buscarIdCliente();
        dao.inserirPFisica(idCliente, pessoa);
        return true;
    }
    
    public boolean inserirPJuridica(PessoaJuridica pessoa) throws SQLException{
        int idCliente = dao.buscarIdCliente();
        dao.inserirPJuridica(idCliente, pessoa);
        return true;
    }
    
    public boolean alterarClientePFisica(Cliente cliente, PessoaFisica pessoa)  throws SQLException{
        boolean editarSucesso = dao.editarCliente(cliente);
        boolean editou = false;
        if (editarSucesso){
            if (dao.editarPFisica(cliente.getId(), pessoa)){
                editou = true;
            }
        }
        else{
            editou = false;
        }
        return editou;
    }

    public boolean alterarClientePJuridica(Cliente cliente, PessoaJuridica pessoa)  throws SQLException{
        boolean editarSucesso = dao.editarCliente(cliente);
        boolean editou = false;
        if (editarSucesso){
            if (dao.editarPJuridica(cliente.getId(), pessoa)){
                editou = true;
            }
        }
        else{
            editou = false;
        }
        return editou;
    }    
    
    
    
    public Cliente buscarPessoaFisica(String cpf){
        PessoaFisica pessoa = dao.buscarPessoaFisica(cpf);
        Cliente cliente = new Cliente();
        if(pessoa == null){
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            return null;
        }
        else{
            cliente = dao.buscarCliente(pessoa.getId());
            cliente.setPFisica(pessoa);
        }
        return cliente;
    }
    
    public Cliente buscarPessoaJuridica(String cnpj){
        PessoaJuridica pessoa = dao.buscarPessoaJuridica(cnpj);
        Cliente cliente = new Cliente();
        if(pessoa == null){
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            return null;
        }
        else{
            cliente = dao.buscarCliente(pessoa.getIdCliente());
            cliente.setPJuridica(pessoa);
        }
        return cliente;        
    }
   
    public boolean deletarClientePFisica(Cliente cliente){
        boolean deletou = false;
        if (dao.deletarPessoaFisica(cliente.getId())){
            if (dao.deletarMotorista(cliente.getId())){
                deletou = dao.deletarCliente(cliente.getId()); 
            }
        }        
        return deletou;
    }
    
    public boolean deletarClientePJuridica(Cliente cliente){
        boolean deletou = false;
        if (dao.deletarPessoaJuridica(cliente.getId())){
            if (dao.deletarMotorista(cliente.getId())){
                deletou = dao.deletarCliente(cliente.getId()); 
            }
        }        
        return deletou;
    }    
    
    public boolean inserirMotorista(Motorista motorista){
        if (!verificarMotorista(motorista)){
            if (dao.inserirMotorista(motorista)){
                return true;
            }
            else{                
                return false;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Motorista já cadastrado");
            return false;
        }
    }
    
    public boolean verificarMotorista(Motorista motorista){
        if(dao.verificarCnh(motorista.getCnh(), motorista.getIdCliente())){
            return true;
        }
        else{
            return false;
        }
    }
    public Motorista buscarMotoristaPelaCNH(int cnh){
        Motorista motorista = dao.buscarMotoristaPelaCNH(cnh);
        if(motorista == null){
            JOptionPane.showMessageDialog(null, "Cliente/Motorista não encontrado");
            return null;
       //INCOMPLETO }else if(motorista.getDataVencimento()>=){
            
        }
        else{
            motorista = dao.buscarMotoristaPelaCNH(cnh);
        }
        return motorista;
    }
    
    public ArrayList<Motorista> getListaMotoristas(int idCliente){
        ArrayList<Motorista> listaMotorista = dao.getListaMotorista(idCliente);
        return listaMotorista;
    }
    
    public boolean removerMotorista(Motorista moto){
        boolean removeu = dao.deletarMotoristaCnh(moto.getCnh());
        return removeu;
    }
}

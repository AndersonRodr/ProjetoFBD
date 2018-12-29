package cliente.service;

import cliente.dao.ClientePessoaDAO;
import cliente.dominio.Cliente;
import cliente.dominio.Motorista;
import cliente.dominio.PessoaFisica;
import cliente.dominio.PessoaJuridica;
import java.sql.SQLException;
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
    
    public boolean deletarClientePFisica(Cliente cliente){
        boolean deletou = false;
        if (dao.deletarPessoaFisica(cliente.getId())){
            deletou = dao.deletarCliente(cliente.getId());
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
}

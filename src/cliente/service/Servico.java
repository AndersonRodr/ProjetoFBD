package cliente.service;

import cliente.dao.ClientePessoaDAO;
import cliente.dominio.Cliente;
import java.util.Calendar;

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
    
    public boolean cadCliente(Cliente cliente){
        boolean cadastroSucesso = dao.inserirCliente(cliente);
        if (cadastroSucesso){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean buscarCPF(String cpf){
        cpf = cpf.replace(".","");
        cpf = cpf.replace("-","");
        if (dao.verificarCpfBD(cpf)){
            return true;
        }
        else{
            return false;
        }
    }
}

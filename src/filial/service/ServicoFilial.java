/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filial.service;

import filial.dao.FilialDAO;
import filial.dominio.Filial;
import java.util.ArrayList;

/**
 *
 * @author Anderson
 */
public class ServicoFilial {
    private FilialDAO dao = new FilialDAO();
    
    public boolean isEmpty(String campo){
       if (campo.length() == 0){
           return true;
       }
       else{
           return false;
       }
    }
    
    public boolean cadastrarFilial(Filial filial){
        boolean cadastroSucesso = dao.cadastrarFilial(filial);
        return cadastroSucesso;
    }
    
    public boolean verificarFilial(String localizacao){
        boolean buscaFilial = dao.verificarFilialDB(localizacao);
        return buscaFilial;
    }
    
    public ArrayList<Filial> buscarListaFiliais(){
        ArrayList<Filial> listaFiliais = dao.getListaFiliais();
        return listaFiliais;
    }
    
    public String[] getNomesFiliais(){
        String[] nomesFiliais = new String[100];
        ArrayList<Filial> filiais = buscarListaFiliais();
        int count = 0;
        for(Filial filial: filiais){
            nomesFiliais[count] = filial.getLocalizacao();
            count++;  
        }
        return nomesFiliais;
    }
    
    public Filial buscarFilial(String localizacao){
        Filial filial = dao.buscarFilial(localizacao);
        return filial;
    }
    
    public Filial buscarFilial1(int localizacao){
        Filial filial = dao.buscarFilial(localizacao);
        return filial;
    }

    public void buscarFilial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

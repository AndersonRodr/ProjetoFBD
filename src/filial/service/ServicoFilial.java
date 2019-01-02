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
    
    public Filial buscarFilial(String localizacao){
        Filial filial = dao.buscarFilial(localizacao);
        return filial;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filial.dao;

import cliente.dao.DataBaseConnection;
import cliente.dominio.Cliente;
import cliente.dominio.Motorista;
import filial.dominio.Filial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Anderson
 */
public class FilialDAO {
    
    
    public boolean cadastrarFilial(Filial filial){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO filial (localizacao) VALUES(?)");
            statement.setString(1, filial.getLocalizacao());
            statement.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar: " + ex);
            return false;
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
    }
    
        public boolean verificarFilialDB(String localizacao){
        boolean result = false; 
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM filial WHERE localizacao ='" + localizacao + "'");
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                result = true;
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar localização: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return result;
    }
        
        
    public ArrayList<Filial> getListaFiliais(){
        ArrayList<Filial> listaFiliais = new ArrayList<Filial>();
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement("Select * from filial");
            rs = statement.executeQuery(); 
            while (rs.next()){
                Filial filial = new Filial();
                filial.setLocalizacao(rs.getString("localizacao"));
                filial.setId(rs.getInt("id_filial"));
                listaFiliais.add(filial);
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar filiais: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        return listaFiliais;
    }
    
    public Filial buscarFilial(String localizacao){
        Filial filial = new Filial();
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement("Select * from filial where localizacao = '" + localizacao + "'");
            rs = statement.executeQuery(); 
            if (rs.next()){
                filial.setId(rs.getInt("id_filial"));
                filial.setLocalizacao(rs.getString("localizacao"));
            }
            else{
                return null;
            }

            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar filial: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        return filial;
    }

    public Filial buscarFilial(int localizacao) {
        Filial filial = new Filial();
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement("Select * from filial where id_filial = '" + localizacao + "'");
            rs = statement.executeQuery(); 
            if (rs.next()){
                filial.setId(rs.getInt("id_filial"));
                filial.setLocalizacao(rs.getString("localizacao"));
            }
            else{
                return null;
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar filial: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        return filial;
    }

    public boolean removerFilial(String localizacao) throws SQLException{
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE from filial where localizacao = ?");
            statement.setString(1, localizacao);
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar Filial: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return false;
    }    
}

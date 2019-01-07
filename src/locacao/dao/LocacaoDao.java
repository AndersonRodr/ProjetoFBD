/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao.dao;

import cliente.dao.DataBaseConnection;
import cliente.dominio.Motorista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import locacao.dominio.Locacao;

/**
 *
 * @author Kimbelly
 */
public class LocacaoDAO {
    // N seria verificar se ja ta alocado/reservado?
    //isso aq de baixo é p ficar aq ou no veiculoDAO?
    public boolean veiculoJaAlocadoMesmoDia(String dataRetirada, String dataDev,String placaVeiculo) throws SQLException{
        Locacao locacaoIgual = buscarLocacao(dataRetirada, dataDev, placaVeiculo);
        if (locacaoIgual==null){
            return false;
        }else{
            return true;
        }
    }
    public void doLocacao(Locacao locacao) {
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO locacao (data_retirada, data_devolucao, cnh_motorista, placa_veiculo, id_cliente)"
                    + "VALUES(?,?,?,?,?)");
            statement.setString(1, locacao.getDataRetirada());
            statement.setString(2, locacao.getDataDevolucao());
            statement.setInt(3, locacao.getCnhMotorista());
            statement.setString(4, locacao.getPlacaVeiculo());
            statement.setInt(5, locacao.getIdCliente());
            statement.executeUpdate();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível locar o veículo " + ex);
            
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }  
    }
     public boolean removerLocacaoPeloId(int idLocacao){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE from locacao where Id_Locacao = ?");
            statement.setInt(1, idLocacao);
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar locação: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return false;
    }
    public boolean removerLocacao(String dataRetirada, String dataDev, String placaVeic) throws SQLException{
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        Locacao buscaLocacaoDada= buscarLocacao(dataRetirada, dataDev, placaVeic);
        if(buscaLocacaoDada ==null){
            return false;
        }
        int idLocacao = buscaLocacaoDada.getIdLocacao();
        try {
            statement = connection.prepareStatement("DELETE from locacao where id_Locacao = ?");
            statement.setInt(1, idLocacao);
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar locacao: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return false;
        
    //METODO ABAIXO INCOM   --------- ajeitar aq ainda
    }
    public boolean removerTodasLocacoes(){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            //olhar aq embaixo
            statement = connection.prepareStatement("DELETE FROM locacao ");
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar locações: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return false;
    }
    
    
    public Locacao buscarLocacao(String dataRetirada, String dataDev, String placaVeic) throws SQLException{
        Locacao locacaoAchada = new Locacao();
        //locacaoAchada = null;
        //Ajeitar essa linha de baixo para pesquisar do jeito q ta no banco (a data)
        String dataRetPesqBanco = dataRetirada;
        String dataDevPesqBanco = dataDev;
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM locacao WHERE placa_veiculo = '" + placaVeic + "'" +
            "AND data_retirada='" + dataRetPesqBanco + "'" + "AND data_devolucao='" + dataDevPesqBanco + "'");
            rs = statement.executeQuery(); 
            if (rs.next()){
                locacaoAchada.setIdLocacao(rs.getInt("id_Locacao"));
                locacaoAchada.setPlacaVeiculo(rs.getString(placaVeic));
                locacaoAchada.setCnhMotorista(rs.getInt("cnh_motorista"));
                locacaoAchada.setIdCliente(rs.getInt("id_Cliente"));
                locacaoAchada.setDataRetirada(rs.getString("data_retirada"));
                locacaoAchada.setDataDevolucao(rs.getString("data_devolucao"));
            }
            else{
                return null;
            }

            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar locação: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        
        return locacaoAchada;
    }
    public ArrayList<Locacao> getListaLocacoesBuscaPlaca(String placaVeic){
        ArrayList<Locacao> listaLocacoes = new ArrayList<Locacao>();
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM locacao where placa_veiculo = '" + placaVeic + "'");
            rs = statement.executeQuery(); 
            while (rs.next()){
                Locacao locacao = new Locacao();
                locacao.setIdLocacao(rs.getInt("id_Locacao"));
                locacao.setPlacaVeiculo(rs.getString("placa_veiculo"));
                locacao.setCnhMotorista(rs.getInt("cnh_motorista"));
                locacao.setDataRetirada(rs.getString("data_retirada"));
                locacao.setDataDevolucao(rs.getString("data_devolucao"));
                locacao.setIdCliente(rs.getInt("id_cliente"));
                
                listaLocacoes.add(locacao);
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar locações referentes a essa placa: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        return listaLocacoes;
    }
    public ArrayList<Locacao> getListaLocacoesBuscaCNHmotorista(int cnhMotorista){
        ArrayList<Locacao> listaLocacoes = new ArrayList<Locacao>();
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM locacao where cnh_motorista = '" + cnhMotorista + "'");
            rs = statement.executeQuery(); 
            while (rs.next()){
                Locacao locacao = new Locacao();
                locacao.setIdLocacao(rs.getInt("id_Locacao"));
                locacao.setPlacaVeiculo(rs.getString("placa_veiculo"));
                locacao.setCnhMotorista(rs.getInt("cnh_motorista"));
                locacao.setDataRetirada(rs.getString("data_retirada"));
                locacao.setDataDevolucao(rs.getString("data_devolucao"));
                locacao.setIdCliente(rs.getInt("id_cliente"));
                
                listaLocacoes.add(locacao);
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar locações referentes a essa cnh: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        return listaLocacoes;
    }
    public ArrayList<Locacao> getListaLocacoesBuscaPeloIdCliente(int idCliente){
        ArrayList<Locacao> listaLocacoes = new ArrayList<Locacao>();
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM locacao WHERE id_cliente = '" + idCliente + "'");
            rs = statement.executeQuery(); 
            while (rs.next()){
                Locacao locacao = new Locacao();
                locacao.setIdLocacao(rs.getInt("id_Locacao"));
                locacao.setPlacaVeiculo(rs.getString("placa_veiculo"));
                locacao.setCnhMotorista(rs.getInt("cnh_motorista"));
                locacao.setDataRetirada(rs.getString("data_retirada"));
                locacao.setDataDevolucao(rs.getString("data_devolucao"));
                locacao.setIdCliente(rs.getInt("id_cliente"));
                
                listaLocacoes.add(locacao);
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar locações referentes a essa cnh: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        return listaLocacoes;
    }
    
     public ArrayList<Locacao> getListaLocacoes(){
        ArrayList<Locacao> listaLocacoes = new ArrayList<Locacao>();
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM locacao");
            rs = statement.executeQuery(); 
            while (rs.next()){
                Locacao locacao = new Locacao();
                locacao.setIdLocacao(rs.getInt("id_Locacao"));
                locacao.setPlacaVeiculo(rs.getString("placa_veiculo"));
                locacao.setCnhMotorista(rs.getInt("cnh_motorista"));
                locacao.setDataRetirada(rs.getString("data_retirada"));
                locacao.setDataDevolucao(rs.getString("data_devolucao"));
                locacao.setIdCliente(rs.getInt("id_cliente"));
                
                listaLocacoes.add(locacao);
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar locações: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        return listaLocacoes;
    }
    
}

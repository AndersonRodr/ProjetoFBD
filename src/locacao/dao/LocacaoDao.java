/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao.dao;

import cliente.dao.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import locacao.dominio.Locacao;

/**
 *
 * @author Kimbelly
 */
public class LocacaoDAO {
    // N seria verificar se ja ta alocado/reservado?
    //isso aq de baixo é p ficar aq ou no veiculoDAO?
    public boolean veiculoJaAlocadoMesmoDia(String dataRetirada, String dataDev,String placaVeiculo){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
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
            JOptionPane.showMessageDialog(null, "Não foi possível alocar o veículo " + ex);
            
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }  
    }
    public boolean removerLocacao(String dataRetirada, String dataDev, String placaVeic){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        Locacao buscaLocacaoDada= buscarLocacao(dataRetirada, dataDev, placaVeic);
        if(buscaLocacaoDada ==null){
            return false;
        }
        int idLocacao = buscaLocacaoDada.getIdLocacao();
        try {
            statement = connection.prepareStatement("Delete from locacao where id_Locacao = ?");
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
        
    //METODO ABAIXO INCOM
    }public Locacao buscarLocacao(String dataRetirada, String dataDev, String placaVeic){
        Locacao locacaoAchada = null;
        //inc
        return locacaoAchada;
    }
    
}

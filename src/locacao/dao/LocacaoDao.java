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
public class LocacaoDao {
    // N seria verificar se ja ta alocado/reservado?
    //isso aq de baixo é p ficar aq ou no veiculoDAO?
    public boolean veiculoJaAlocado(String placaVeiculo){
        return false;
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
    public void removerLocacao(){
        
    }
    
}

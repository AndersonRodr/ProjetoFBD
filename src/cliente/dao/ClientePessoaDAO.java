package cliente.dao;

import cliente.dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClientePessoaDAO {
    
    public boolean inserirCliente(Cliente cliente){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO cliente (nome, endereco)VALUES(?,?)");
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getEndereco());
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
    
    public boolean verificarCpfBD(String cpf){
        boolean result = false; 
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM pessoa_fisica WHERE cpf ='" + cpf + "'");
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                result = true;
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao validar CPF: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return result;
    }
    
    
    public boolean verificarCnpjBD(String cnpj){
        boolean result = false; 
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM pessoa_juridica WHERE cnpj ='" + cnpj + "'");
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                result = true;
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao validar CNPJ: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return result;
    }
}

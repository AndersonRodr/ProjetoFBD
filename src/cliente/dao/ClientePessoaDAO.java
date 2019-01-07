package cliente.dao;

import cliente.dominio.Cliente;
import cliente.dominio.Motorista;
import cliente.dominio.PessoaFisica;
import cliente.dominio.PessoaJuridica;
import cliente.dominio.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import locacao.dominio.Locacao;

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
    
    public int buscarIdCliente() throws SQLException{
        boolean result = false; 
        int idCliente = 0;
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            statement = connection.prepareStatement("SELECT max(id_Cliente) id_Cliente FROM cliente");
            rs = statement.executeQuery(); 
            rs.next();
            idCliente = rs.getInt("id_Cliente");
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Id: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return idCliente;
    }
    
    public boolean inserirPFisica(int idCliente, PessoaFisica pessoa){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO pessoa_fisica (Id_Cliente, sexo, data_nascimento, cpf)VALUES(?,?,?,?)");
            statement.setInt(1, idCliente);
            statement.setString(2, pessoa.getSexo());
            statement.setString(3, pessoa.getDataNascimento());
            statement.setString(4, pessoa.getCpf());
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
    
    public boolean inserirPJuridica(int idCliente, PessoaJuridica pessoa){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO pessoa_juridica (Id_cliente, CNPJ, Inscricao_estadual)VALUES(?,?,?)");
            statement.setInt(1, idCliente);
            statement.setString(2, pessoa.getCnpj());
            statement.setString(3, pessoa.getInscEstadual());
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
    
    public PessoaFisica buscarPessoaFisica(String cpf){
        PessoaFisica pessoa = new PessoaFisica();
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement("Select * from pessoa_fisica where cpf = '" + cpf + "'");
            rs = statement.executeQuery(); 
            if (rs.next()){
                pessoa.setId(rs.getInt("Id_Cliente"));
                pessoa.setDataNascimento(rs.getString("data_nascimento"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoa.setCpf(rs.getString("cpf"));
            }
            else{
                return null;
            }

            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar pessoa: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        return pessoa;
    }

    public PessoaJuridica buscarPessoaJuridica(String cnpj){
        PessoaJuridica pessoa = new PessoaJuridica();
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement("Select * from pessoa_juridica where cnpj = '" + cnpj + "'");
            rs = statement.executeQuery(); 
            if (rs.next()){
                pessoa.setIdCliente(rs.getInt("Id_Cliente"));
                pessoa.setCnpj(rs.getString("cnpj"));
                pessoa.setInscEstadual(rs.getString("Inscricao_estadual"));
            }
            else{
                return null;
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar pessoa: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        return pessoa;
    }    
    
    
    public Cliente buscarCliente(int id){
        Cliente cliente = new Cliente();
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            statement = connection.prepareStatement("Select * from cliente where id_Cliente = '" + id + "'");
            rs = statement.executeQuery(); 
                rs.next();
                cliente.setId(rs.getInt("id_Cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        return cliente;
    }
    
    public boolean deletarPessoaFisica(int id){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("Delete from pessoa_fisica where Id_Cliente = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar pessoa: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return false;
    }

    public boolean deletarPessoaJuridica(int id){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("Delete from pessoa_juridica where Id_cliente = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar pessoa: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return false;
    }
    
    public boolean deletarCliente(int id){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("Delete from cliente where id_Cliente = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar cliente: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return false;
    }
    
    public boolean verificarCnh(int cnh, int idCliente){
        boolean result = false; 
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM motorista WHERE cnh ='" + cnh + "'" + 
                    "AND id_cliente='" + idCliente + "'");
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                result = true;
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar CNH: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return result;
    }
    
    public boolean inserirMotorista(Motorista motorista){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO motorista (cnh, id_cliente, data_vencimento, rg, nome)"
                    + "VALUES(?,?,?,?,?)");
            statement.setInt(1, motorista.getCnh());
            statement.setInt(2, motorista.getIdCliente());
            statement.setString(3, motorista.getDataVencimento());
            statement.setInt(4, motorista.getRg());
            statement.setString(5, motorista.getNome());
            statement.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar motorista: " + ex);
            return false;
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
    }
    public Motorista buscarMotoristaPelaCNH(int cnh){
        Motorista motorista = new Motorista();
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            statement = connection.prepareStatement("Select * from motorista where cnh = '" + cnh + "'");
            rs = statement.executeQuery(); 
                rs.next();
                motorista.setIdCliente(rs.getInt("id_Cliente"));
                motorista.setNome(rs.getString("nome"));
                motorista.setCnh(rs.getInt("cnh"));
                //DATA DE VENCIMENTO da carteira neh? nera melhor colocar data_vencimento_carteira n?
                motorista.setDataVencimento(rs.getString("data_vencimento"));
                motorista.setRg(rs.getInt("rg"));
                
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar motorista: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        return motorista;
    }
    
    public ArrayList<Motorista> getListaMotorista(int idCliente){
        ArrayList<Motorista> listaMotoristas = new ArrayList<Motorista>();
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement("Select * from motorista where id_cliente = '" + idCliente + "'");
            rs = statement.executeQuery(); 
            while (rs.next()){
                Motorista motorista = new Motorista();
                motorista.setCnh(rs.getInt("cnh"));
                motorista.setIdCliente(rs.getInt("id_cliente"));
                motorista.setDataVencimento(rs.getString("data_vencimento"));
                motorista.setRg(rs.getInt("rg"));
                motorista.setNome(rs.getString("nome"));
                listaMotoristas.add(motorista);
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar motoristas: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        return listaMotoristas;
    }
    public boolean deletarMotorista(int id){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("Delete from motorista where id_cliente = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar cliente: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return false;
    }
    public boolean deletarMotoristaCnh(int cnh){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE from motorista WHERE CNH = ?");
            statement.setInt(1, cnh);
            statement.executeUpdate();
            return true;          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar Motorista: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return false;
    }
    
    public boolean editarCliente(Cliente cliente){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE cliente set nome = ? ,endereco = ? where id_Cliente = ?");
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getEndereco());
            statement.setInt(3, cliente.getId());
            statement.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar cliente: " + ex);
            return false;
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
    }
        
    public boolean editarPFisica(int idCliente, PessoaFisica pessoa){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE pessoa_fisica set data_nascimento = ?, cpf = ?, sexo = ? where Id_Cliente = ?");
            statement.setString(1, pessoa.getDataNascimento());
            statement.setString(2, pessoa.getCpf());
            statement.setString(3, pessoa.getSexo());
            statement.setInt(4, idCliente);
            statement.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar pessoa física: " + ex);
            return false;
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
    } 

    public boolean editarPJuridica(int idCliente, PessoaJuridica pessoa){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE pessoa_juridica set Inscricao_estadual = ?, cnpj = ? where Id_Cliente = ?");
            statement.setString(1, pessoa.getInscEstadual());
            statement.setString(2, pessoa.getCnpj());
            statement.setInt(3, idCliente);
            statement.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar pessoa juridica: " + ex);
            return false;
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
    }
    
  
    public void doReserva(Reserva reserva) {
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO reserva (data_retirada, data_devolucao, id_filial_origem, id_filial_devolucao, id_tipo_veiculo, id_cliente)"
                    + "VALUES(?,?,?,?,?,?)");
            statement.setString(1, reserva.getDataRetirada());
            statement.setString(2, reserva.getDataDevolucao());
            statement.setInt(3, reserva.getFilialRetirada());
            statement.setInt(4, reserva.getFilialDevolucao());
            statement.setInt(5, reserva.getTipoCarro());
            statement.setInt(6, reserva.getIdCliente());
            statement.executeUpdate();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar motorista: " + ex);
            
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        
        
    }
    
}

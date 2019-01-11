/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserva.dao;

import cliente.dao.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import locacao.dominio.Locacao;
import reserva.dominio.Reserva;

/**
 *
 * @author Anderson
 */
public class ReservaDAO {
        public void doReserva(Reserva reserva) {
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO reserva (data_retirada, data_devolucao, id_filial_origem, id_filial_devolucao, id_tipo_veiculo, id_cliente)"
                    + "VALUES(?,?,?,?,?,?)");
            statement.setString(1, reserva.getDataRetirada());
            statement.setString(2, reserva.getDataDevolucao());
            statement.setInt(3, reserva.getIdFilialOrigem());
            statement.setInt(4, reserva.getIdFilialDevolucao());
            statement.setInt(5, reserva.getIdTipoVeiculo());
            statement.setInt(6, reserva.getIdCliente());
            statement.executeUpdate();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar motorista: " + ex);
            
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }       
    }
        
    public ArrayList<Reserva> getListaReserva(){
        ArrayList<Reserva> listaReserva = new ArrayList<Reserva>();
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM reserva");
            rs = statement.executeQuery(); 
            while (rs.next()){
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("idReserva"));
                reserva.setDataRetirada(rs.getString("data_retirada"));
                reserva.setDataDevolucao(rs.getString("data_devolucao"));
                reserva.setIdFilialOrigem(rs.getInt("id_filial_origem"));
                reserva.setIdFilialDevolucao(rs.getInt("id_filial_devolucao"));
                reserva.setIdCliente(rs.getInt("id_cliente"));
//                String cpfCnpj = buscarCliente(reserva);
//                reserva.setCpfCnpj(cpfCnpj);
                listaReserva.add(reserva);
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar reservas: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        return listaReserva;
    }
    public ArrayList<Reserva> getListaPFisica(ArrayList<Reserva> reserva) throws SQLException{
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<Reserva> lista = new ArrayList<Reserva>();
        try {
            for (Reserva r : reserva){
                statement = connection.prepareStatement("select cpf from pessoa_fisica where pessoa_fisica.id_cliente = '" 
                                                                                                        + r.getIdCliente() + "'");
                rs = statement.executeQuery();
                while(rs.next()){
                    r.setCpfCnpj(rs.getString("cpf"));
                    lista.add(r);
                } 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar clientes: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return lista;
    }
    
    
    public ArrayList<Reserva> getListaPJuridica(ArrayList<Reserva> reserva) throws SQLException{
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<Reserva> lista = new ArrayList<Reserva>();
        try {
            for (Reserva r : reserva){
                statement = connection.prepareStatement("select cnpj from pessoa_juridica where pessoa_juridica.Id_cliente = '" 
                                                                                                        + r.getIdCliente() + "'");
                rs = statement.executeQuery();
                while(rs.next()){
                    r.setCpfCnpj(rs.getString("cnpj"));
                    lista.add(r);
                } 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar clientes: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return lista;
    }    
    public boolean removerReserva(int idReserva) throws SQLException{
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE from reserva where reserva.idReserva = ?");
            statement.setInt(1, idReserva);
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar Reserva: " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        return false;
    }     
}

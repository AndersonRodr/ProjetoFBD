/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculo.dao;

import cliente.dao.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import veiculo.dominio.Revisao;
import veiculo.dominio.Veiculo;

/**
 *
 * @author bruno.an
 */
public class VeiculoDao {
    
    public boolean inserirVeiculo(Veiculo veiculo){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("INSERT INTO veiculo (PLACA, NUMERO_CHASSI, NUMERO_MOTOR, COR, QUILOMETRAGEM, DT_MEDIA_KM, ULTIMA_REVISAO, TIPO_VEICULO, FILIAL)"
                                                   +"VALUES(?,?,?,?,?,?,?,?,?)");
            statement.setString(1, veiculo.getPlaca());
            statement.setString(2, veiculo.getNumeroChassi());
            statement.setString(3, veiculo.getNumeroMotor());
            statement.setString(4, veiculo.getCor());
            statement.setInt(5, veiculo.getQuilometragem());
            statement.setString(6, veiculo.getDataMediaKM());
            statement.setString(7,veiculo.getUltimaRevisao());
            statement.setInt(8, veiculo.getTipoVeiculo());
            statement.setInt(9, veiculo.getFilial());
            statement.executeUpdate();
            return true;

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar: " + ex);
            return false;
            
        }finally{
            DataBaseConnection.fecharConexao(connection, statement);
        
    }
    }
    
    public Veiculo buscarVeiculo(String placa){
        Veiculo veiculo = new Veiculo();
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            statement = connection.prepareStatement("Select * from veiculo where placa = (?)");
            statement.setString(1, placa);
            rs = statement.executeQuery();
            if(rs.next()){
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setNumeroChassi(rs.getString("numero_chassi"));
                veiculo.setNumeroMotor(rs.getString("numero_motor"));
                veiculo.setQuilometragem(rs.getInt("quilometragem"));
                veiculo.setUltimaRevisao(rs.getString("ultima_revisao"));
                veiculo.setDataMediaKM(rs.getString("dt_media_km"));
                veiculo.setTipoVeiculo(rs.getInt("tipo_veiculo"));
                veiculo.setFilial(rs.getInt("filial"));
            }else{
                return null;
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar veículo: " + ex);
        }finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        return veiculo;
        
    
}
    
    public ArrayList<Revisao> getRevisao(int tipoVeiculo){
        ArrayList<Revisao> revisoes = new ArrayList<>();
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            if(rs.next()){
                Revisao revisao = new Revisao();
                statement = connection.prepareStatement("Select * from revisao where tipo_veiculo = '" + tipoVeiculo + "'");
                rs = statement.executeQuery();
                rs.next();
                revisao.setIdVeiculo(rs.getInt("tipo_veiculo"));
                revisao.setQuilometragem(rs.getInt("quilometragem"));
                revisoes.add(revisao);
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar veículo: " + ex);
            
        } finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        
        return revisoes;
    }
    
    public boolean isVeiculoCadastrado(String placa){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            statement = connection.prepareStatement("Select * from veiculo where placa = (?)");
            statement.setString(1, placa);
            rs = statement.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar veículo: " + ex);
        }finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        
        return true;
        
    }
    
    public boolean deletarVeiculo(String placa){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("DELETE FROM veiculo WHERE placa = ?");
            statement.setString(1, placa);
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

    public String getTipo(String tipo) {
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String tipoSaida = "";
        try{
            statement = connection.prepareStatement("Select * from tipo_veiculo where id_tipo_veiculo = (?)");
            statement.setString(1, tipo);
            rs = statement.executeQuery();
            if(rs.next()){
                tipoSaida = rs.getString("nome"); 
//                veiculo.setPlaca(rs.getString("placa"));
//                veiculo.setNumeroChassi(rs.getString("numero_chassi"));
//                veiculo.setNumeroMotor(rs.getString("numero_motor"));
//                veiculo.setQuilometragem(rs.getInt("quilometragem"));
//                veiculo.setUltimaRevisao(rs.getString("ultima_revisao"));
//                veiculo.setDataMediaKM(rs.getString("dt_media_km"));
//                veiculo.setTipoVeiculo(rs.getInt("tipo_veiculo"));
//                veiculo.setFilial(rs.getInt("filial"));
            }else{
                return null;
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar veículo: " + ex);
        }finally{
            DataBaseConnection.fecharConexao(connection, statement, rs);
        }
        
        return tipoSaida;
    }

    public void updateRevisao(String placa,String data) {
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE veiculo set ultima_revisao = ? where placa = ?");
            statement.setString(1, data);
            statement.setString(2, placa);
            statement.executeUpdate();
   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
    }
    
    public void revisao(Revisao revisao){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("INSERT INTO revisao (id_tipo_veiculo, quilometragem)"
                                                   +"VALUES(?,?)");
            statement.setString(1,String.valueOf(revisao.getIdVeiculo()));
            statement.setString(2, String.valueOf(revisao.getQuilometragem()));
           

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar: " + ex);
            
        }finally{
            DataBaseConnection.fecharConexao(connection, statement);
        
        }
    
    }
    
    public void updateKm(String placa, String km){
        Connection connection = DataBaseConnection.getConexao();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE veiculo set quilometragem = ? where placa = ?");
            statement.setString(1, km);
            statement.setString(2, placa);
            statement.executeUpdate();
   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar " + ex);
        }
        finally{
            DataBaseConnection.fecharConexao(connection, statement);
        }
        
    }
}

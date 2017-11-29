/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import org.junit.Test;

/**
 *
 * @author mathe
 */

public class ConectaBanco {
    
    public Statement stm; // responsavél por preparar e realizar pesquisas no banco de dados
    public ResultSet rs; // responsavél por armazenar o resultado de uma pesquisa passada para o statement
    private String driver = "org.postgresql.Driver"; // responsavél por identificar o serviço de banco de dados
    private String caminho = "jdbc:postgresql://localhost:5432/cidadeestado"; // responsavél por setar o local do banco de dados
    private String usuario = "postgres"; // login
    private String senha = "19971230"; // senha
    public Connection conn; // responsavél por realizar a conexão com o banco de dados
    
    @test
    public void conexao(){ // método responsavél por realizar a conexão com o BD
        try {
            System.setProperty("jdbc.Drivers", driver); // seta a propriedade do driver de conexão
            conn = DriverManager.getConnection(caminho, usuario, senha); // realiza a conexão com o BD
            //JOptionPane.showMessageDialog(null, "BD Conectado"); // aviso se o BD foi conectado
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de conexão!\n ERRO:" + ex.getMessage());
        }
    }
    @test
    public void executaSQL(String sql){//
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(null, "Erro de ExecutaSQL!\n ERRO:" + ex.getMessage());
        }
    }
    @test
    public void desconecta() {
        try {
            conn.close();
            //JOptionPane.showMessageDialog(null, "BD Desconectado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão!\n ERRO:" + ex.getMessage());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloCidade;

/**
 *
 * @author mathe
 */
public class ControleCidade {
    ConectaBanco connCidade = new ConectaBanco();
    
    public void InserirCidade(ModeloCidade mod){
        connCidade.conexao();
        try {
            PreparedStatement pst = connCidade.conn.prepareStatement("insert into cidade(nome_cidade, id_estado)values(?,?)");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getCod_estado());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados armazenados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na inserção dos dados" + ex);
        }
        connCidade.desconecta();
    }
    public void ExcluiCidade(ModeloCidade mod){
        connCidade.conexao();
        try {
            PreparedStatement pst = connCidade.conn.prepareStatement("delete from cidade where id_cidade=?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro no exclusão os dados" + ex);
        }
        connCidade.desconecta();
    }
    public void AlteraCidade(ModeloCidade mod){
        connCidade.conexao();
        try {
            PreparedStatement pst = connCidade.conn.prepareStatement("update cidade set nome_cidade = ?, id_estado = ? where id_cidade = ?");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getCod_estado());
            pst.setInt(3, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Alterados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos dados" + ex);
        }
    }
}

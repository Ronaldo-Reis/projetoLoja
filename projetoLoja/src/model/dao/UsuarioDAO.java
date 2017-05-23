package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;

public class UsuarioDAO {

    Connection con;
    
    public UsuarioDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean checkLogin(String login, String senha) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }
    public void create(Usuario u) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO usuario (login,senha)VALUES(?,?)");
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());          

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuário Cadastrado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}

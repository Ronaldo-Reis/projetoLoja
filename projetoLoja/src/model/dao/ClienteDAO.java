package model.dao;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;


public class ClienteDAO {
     Connection con;
    
    public ClienteDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public void create(Cliente c) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO cliente (nome,cpf,telefone,celular,email,data,sexo)VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getTelefone());
            stmt.setString(4, c.getCelular());
            stmt.setString(5, c.getEmail());
            stmt.setString(6, c.getData());
            stmt.setString(7, c.getSexo());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Cliente> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM cliente");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCelular(rs.getString("celular"));    
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientes;

    }
    public List<Cliente> readForNome(String nome) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCelular(rs.getString("celular"));    
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientes;

    }

    public void update(Cliente c) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE cliente SET nome = ? ,celular = ?,cpf = ? WHERE id = ?");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCelular());
            stmt.setString(3, c.getCpf());
            stmt.setInt(4, c.getId());
               
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Cliente c) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE id = ?");
            stmt.setInt(1, c.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}

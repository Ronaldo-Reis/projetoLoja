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
import model.bean.Produto;
import model.bean.Venda;


public class VendaDAO {
     Connection con;
    
    public VendaDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public void create(Venda v) {

        PreparedStatement stmt = null;

        try {
            
            stmt = con.prepareStatement("INSERT INTO venda (cliente_id,produto_id,qtd)VALUES(?,?,?)");
            stmt.setInt(1,v.getC().getId());
            stmt.setInt(2,v.getP().getId());
            stmt.setInt(3,v.getQtd());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto Adicionado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Venda> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Venda> vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT distinct nome, cliente_id  FROM cliente_compradores");
//            SELECT 
//                `cliente`.`nome` AS `nome`,
//                `venda`.`cliente_id` AS `cliente_id`
//            FROM
//                (`cliente`JOIN `venda`)
//            WHERE
//                (`cliente`.`id` = `venda`.`cliente_id`);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Venda venda = new Venda();
                Cliente cliente = new Cliente();

                //venda.setId(rs.getInt("venda_id"));
                cliente.setId(rs.getInt("cliente_id"));
                cliente.setNome(rs.getString("nome"));    
              
                venda.setC(cliente);
                
                vendas.add(venda);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return vendas;

    }
//    public List<Venda> readForInt(String id) {
//
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        List<Venda> vendas = new ArrayList<>();
//
//        try {
//            stmt = con.prepareStatement("SELECT produto_id FROM venda where cliente_id=?");
//            stmt.setString(1,id);
//            
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//
////            cliente.setId(rs.getInt("cliente_id"));
////            cliente.setNome(rs.getString("nome"));    
////              
////            venda.setC(cliente);
////                
////            vendas.add(venda);
//                
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            ConnectionFactory.closeConnection(con, stmt, rs);
//        }
//
//        return vendas;

//    }
public List<Produto> readForId(Cliente c) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select produto.id,produto.descricao,venda.qtd from venda,produto where cliente_id = ? and produto_id=produto.id");
            stmt.setInt(1,c.getId());
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Venda v = new Venda();
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                v.setQtd(rs.getInt("qtd"));
                
                //venda.setC(cliente);
                produtos.add(produto);
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
             
        return produtos;

    }
    
//    public void update(Cliente c) {
//
//        PreparedStatement stmt = null;
//
//        try {
//            stmt = con.prepareStatement("UPDATE cliente SET nome = ? ,celular = ?,cpf = ? WHERE id = ?");
//            stmt.setString(1, c.getNome());
//            stmt.setString(2, c.getCelular());
//            stmt.setString(3, c.getCpf());
//            stmt.setInt(4, c.getId());
//               
//            stmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
//        } finally {
//            ConnectionFactory.closeConnection(con, stmt);
//        }
//
//    }
//    public void delete(Cliente c) {
//
//        PreparedStatement stmt = null;
//
//        try {
//            stmt = con.prepareStatement("DELETE FROM cliente WHERE id = ?");
//            stmt.setInt(1, c.getId());
//
//            stmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
//        } finally {
//            ConnectionFactory.closeConnection(con, stmt);
//        }
//
//    }
}

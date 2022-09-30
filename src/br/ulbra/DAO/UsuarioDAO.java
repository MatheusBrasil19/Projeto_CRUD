package br.ulbra.DAO;

import br.ulbra.entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    Connection con;
    
    public UsuarioDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean checkLogin(String email, String senha) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            stmt = con.prepareStatement("SELECT * FROM tbConta WHERE email = ? and  senha = ? ");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(
                    UsuarioDAO.class.getName()).log(
                    Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
        
    }
    
    public void create(Usuario u) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbConta (nome,fone,senha,email,cep,rua,bairro,cidade,estado,numero) VALUES (?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, u.getNome());            
            stmt.setString(2, u.getFone());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getCep());
            stmt.setString(6, u.getRua());
            stmt.setString(7, u.getBairro());
            stmt.setString(8, u.getCidade());
            stmt.setString(9, u.getEstado());
            stmt.setInt(10, u.getNumero());            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Usuario u) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbConta WHERE idNome = ?");
            stmt.setInt(1, u.getIdNome());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Série excluída com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir:" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void update(Usuario u) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbConta SET nome = ? , fone= ?,"
                    + " senha = ? , email = ? , cep = ?, rua = ?, bairro = ?, "
                    + "cidade = ?, estado = ?, numero = ?  WHERE idNome = ?");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getFone());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getCep());
            stmt.setString(6, u.getRua());
            stmt.setString(7, u.getBairro());
            stmt.setString(8, u.getCidade());
            stmt.setString(9, u.getEstado());
            stmt.setInt(10, u.getNumero());
            stmt.setInt(11, u.getIdNome());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Usuario> read() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> contas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbConta");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdNome(rs.getInt("idNome"));
                usuario.setNome(rs.getString("nome"));
                usuario.setFone(rs.getString("fone"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCep(rs.getString("cep"));
                usuario.setRua(rs.getString("rua"));
                usuario.setBairro(rs.getString("bairro"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setNumero(rs.getInt("numero"));
                contas.add(usuario);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null,
                    ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Usuario>) contas;
    }
    
    public List<Usuario> readForDesc(String nome, String tipo) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String args = tipo;
        String script = null;
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            args = tipo+" LIKE '%"+nome+"%'";
            script = "SELECT * FROM tbConta WHERE "+args;
            stmt = con.prepareStatement(script);
            ;
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdNome(rs.getInt("idNome"));
                usuario.setNome(rs.getString("nome"));
                usuario.setFone(rs.getString("fone"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCep(rs.getString("cep"));
                usuario.setRua(rs.getString("rua"));
                usuario.setBairro(rs.getString("bairro"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setNumero(rs.getInt("numero"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return usuarios;
    }
    
}

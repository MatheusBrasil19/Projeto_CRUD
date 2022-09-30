package br.ulbra.DAO;

import br.ulbra.entity.Serie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author s.lucas
 */
public class serieDAO {
    Connection con;
    
    public serieDAO() throws SQLException {
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
    
    public void create(Serie s) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbSerie (serie,nota,categoria,temporadas,anoLancamento) VALUES (?,?,?,?,?)");
            stmt.setString(1, s.getSerie());            
            stmt.setDouble(2, s.getNota());            
            stmt.setString(3, s.getCategoria());            
            stmt.setString(4, s.getTemporadas());            
            stmt.setInt(5, s.getAnoLancamento());            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Serie s) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbSerie WHERE idSerie = ?");
            stmt.setInt(1, s.getIdSerie());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Série excluída com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir:" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void update(Serie s) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbSerie SET serie = ? , nota = ?, categoria = ? , temporadas = ? , anoLancamento = ? WHERE idSerie = ?");
            stmt.setString(1, s.getSerie());
            stmt.setDouble(2, s.getNota());
            stmt.setString(3, s.getCategoria());
            stmt.setString(4, s.getTemporadas());
            stmt.setInt(5, s.getAnoLancamento());
            stmt.setInt(6, s.getIdSerie());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Serie> read() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Serie> s = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbSerie");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Serie serie = new Serie();
                serie.setIdSerie(rs.getInt("idSerie"));
                serie.setSerie(rs.getString("serie"));
                serie.setNota(rs.getDouble("nota"));
                serie.setCategoria(rs.getString("categoria"));
                serie.setTemporadas(rs.getString("temporadas"));
                serie.setAnoLancamento(rs.getInt("anoLancamento"));
                s.add(serie);           
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null,
                    ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Serie>) s;
    }
    
    public List<Serie> readForDesc(String nome, String tipo) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String args = tipo;
        String script = null;
        ArrayList<Serie> series = new ArrayList<>();
        try {
            args = tipo+" LIKE '%"+nome+"%'";
            script = "SELECT * FROM tbSerie WHERE "+args;
            stmt = con.prepareStatement(script);            ;
            rs = stmt.executeQuery();
            while (rs.next()) {
                Serie serie = new Serie();
                serie.setIdSerie(rs.getInt("idSerie"));
                serie.setSerie(rs.getString("serie"));
                serie.setNota(rs.getDouble("nota"));
                serie.setCategoria(rs.getString("categoria"));
                serie.setTemporadas(rs.getString("temporadas"));
                serie.setAnoLancamento(rs.getInt("anoLancamento"));
                series.add(serie); 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return series;
    }
    
}


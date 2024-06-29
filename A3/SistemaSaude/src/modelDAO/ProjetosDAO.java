/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDAO;

import conexaoBD.Conexao;
import conexaoBD.DbException;
import conexaoBD.Projetos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mariana Raio
 */
public class ProjetosDAO {

    private Connection conn;

    public ProjetosDAO() {
        this.conn = Conexao.getConnection();
    }

    public ProjetosDAO(Connection conn) {
        this.conn = conn;
    }

    private Projetos instantiateProjetos(ResultSet rs) throws SQLException {
        Projetos obj = new Projetos();
        obj.setId(rs.getInt("id"));
        obj.setNome(rs.getString("nome"));
        obj.setTipo(rs.getString("tipo"));

        return obj;
    }

    public void inserir(int id_subprojetos, int id_projetos, double avaliacao, String descricao_proj) {
        PreparedStatement st;
        ResultSet rs;

        try {
            st = conn.prepareStatement("INSERT INTO salvarprojetos (id_projetos, id_subprojetos, avaliacao, descricao_proj) VALUES (?,?,?,?)");
            st.setInt(1, id_projetos);
            st.setInt(2, id_subprojetos);
            st.setDouble(3, avaliacao);
            st.setString(4, descricao_proj);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void atualizar(Projetos obj) {
        PreparedStatement st;

        try {
            st = conn.prepareStatement("UPDATE projetos SET nome = ?, tipo = ? WHERE id = ?");
            st.setString(1, obj.getNome());
            st.setString(2, obj.getTipo());
            st.setInt(3, obj.getId());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    public void atualizarInfo(int id_projeto, int id_subprojeto, int id_projeto_new, int id_subprojeto_new, double avaliacao, String descricao_proj) {
        PreparedStatement st;

        try {
            st = conn.prepareStatement("UPDATE salvarprojetos "
                    + "SET id_projetos = ?, id_subprojetos = ?, avaliacao = ?, descricao_proj = ?"
                    + "WHERE id_projetos = ?"
                    + "AND id_subprojetos = ? ");
            st.setInt(1, id_projeto_new);
            st.setInt(2, id_subprojeto_new);
            st.setDouble(3, avaliacao);
            st.setString(4, descricao_proj);
            st.setInt(5, id_projeto);
            st.setInt(6, id_subprojeto);

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    public void excluir(Integer id) {
        PreparedStatement st;

        try {
            st = conn.prepareStatement("DELETE FROM projetos WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void excluirDadosTabela(Integer id_projetos, Integer id_subprojetos) {
        PreparedStatement st;

        try {
            st = conn.prepareStatement("DELETE FROM salvarprojetos WHERE id_projetos = ? AND id_subprojetos = ?");
            st.setInt(1, id_projetos);
            st.setInt(2, id_subprojetos);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public Projetos consultarPorId(Integer id) {
        PreparedStatement st;
        ResultSet rs;

        try {
            st = conn.prepareStatement("SELECT * FROM projetos WHERE id = ?");
            st.setInt(1, id);

            rs = st.executeQuery();
            if (rs.next()) {
                Projetos obj = instantiateProjetos(rs);
                return obj;
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return null;
    }

    public Projetos consultarPorNome(String nome) {
        PreparedStatement st;
        ResultSet rs;

        try {
            st = conn.prepareStatement("SELECT * FROM projetos WHERE nome = ?");
            st.setString(1, nome);

            rs = st.executeQuery();
            if (rs.next()) {
                Projetos obj = instantiateProjetos(rs);
                return obj;
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return null;
    }

    public List<Object[]> buscarPorNome(String nome, int id) {
        PreparedStatement st;
        ResultSet rs;

        try {
            st = conn.prepareStatement("SELECT p.id, p.nome, s.descricao, sp.avaliacao"
                    + " FROM salvarprojetos sp"
                    + " JOIN projetos p ON sp.id_projetos = p.id"
                    + " JOIN subprojetos s ON sp.id_subprojetos = s.id"
                    + " WHERE p.nome = ?"
                    + " OR p.id = ?");

            st.setString(1, nome);
            st.setInt(2, id);
            rs = st.executeQuery();

            List<Object[]> list = new ArrayList<>();

            while (rs.next()) {
                Object[] obj = new Object[4];
                obj[0] = rs.getInt("p.id");
                obj[1] = rs.getString("p.nome");
                obj[2] = rs.getString("s.descricao");
                obj[3] = rs.getDouble("sp.avaliacao");
                list.add(obj);
            }

            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    public List<Projetos> consultarTodos() {
        PreparedStatement st;
        ResultSet rs;

        try {
            st = conn.prepareStatement("SELECT * FROM projetos ORDER BY nome");
            rs = st.executeQuery();

            List<Projetos> list = new ArrayList<>();

            while (rs.next()) {
                Projetos obj = instantiateProjetos(rs);

                list.add(obj);
            }

            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    public List<String> listarNome() {
        PreparedStatement st;
        ResultSet rs;

        try {
            st = conn.prepareStatement("SELECT nome FROM projetos ");
            rs = st.executeQuery();

            List<String> list = new ArrayList<>();

            while (rs.next()) {
                String nome = rs.getString("nome");
                list.add(nome);
            }

            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    public String listarNomeAtualiacao(int id_projeto) {
        PreparedStatement st;
        ResultSet rs;
        String nome = "";
        try {
            st = conn.prepareStatement("SELECT nome FROM projetos WHERE id = ? ");
            st.setInt(1, id_projeto);
            rs = st.executeQuery();
            while(rs.next()){
               nome = rs.getString("nome"); 
            }
            
               
            return nome;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    public List<Object[]> buscarTodos() {
        PreparedStatement st;
        ResultSet rs;

        try {
            st = conn.prepareStatement("SELECT p.id, p.nome, s.descricao, sp.avaliacao, sp.descricao_proj"
                    + " FROM salvarprojetos sp"
                    + " JOIN projetos p ON sp.id_projetos = p.id"
                    + " JOIN subprojetos s ON sp.id_subprojetos = s.id"
                    + " ORDER BY id_descricaoproj");

            rs = st.executeQuery();

            List<Object[]> list = new ArrayList<>();

            while (rs.next()) {
                Object[] obj = new Object[5];
                obj[0] = rs.getInt("p.id");
                obj[1] = rs.getString("p.nome");
                obj[2] = rs.getString("s.descricao");
                obj[3] = rs.getDouble("sp.avaliacao");
                obj[4] = rs.getString("sp.descricao_proj");
                list.add(obj);
            }

            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    public List<Object[]> buscarAtualizacao(int id, String descricao) {
        PreparedStatement st;
        ResultSet rs;

        try {
            st = conn.prepareStatement("SELECT p.id, p.nome, s.descricao"
                    + " FROM salvarprojetos sp"
                    + " JOIN projetos p ON sp.id_projetos = p.id"
                    + " JOIN subprojetos s ON sp.id_subprojetos = s.id"
                    + " WHERE p.id = ?"
                    + " AND s.descricao = ?");

            st.setInt(1, id);
            st.setString(2, descricao);
            rs = st.executeQuery();

            List<Object[]> list = new ArrayList<>();

            while (rs.next()) {
                Object[] obj = new Object[3];
                obj[0] = rs.getInt("p.id");
                obj[1] = rs.getString("p.nome");
                obj[2] = rs.getString("s.descricao");

                list.add(obj);
            }

            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }
}

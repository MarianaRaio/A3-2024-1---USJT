/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDAO;

import conexaoBD.Conexao;
import conexaoBD.DbException;
import conexaoBD.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mariana Raio
 */
public class UsuarioDAO {

    private Connection conn;

    public UsuarioDAO() {
        this.conn = Conexao.getConnection();
    }

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    private Usuario instantiateUsuario(ResultSet rs) throws SQLException {
        Usuario obj = new Usuario();
        obj.setId(rs.getInt("id"));
        obj.setUsuario(rs.getString("usuario"));
        obj.setNome(rs.getString("nome"));
        obj.setEmail(rs.getString("email"));
        obj.setSenha(rs.getString("senha"));
        obj.setTelefone(rs.getString("telefone"));
        obj.setPermissao(rs.getString("permissao"));

        return obj;
    }

    public void inserir(Usuario obj) {
        PreparedStatement st;
        ResultSet rs;

        try {
            st = conn.prepareStatement("INSERT INTO usuarios (usuario, nome, email, senha, telefone, permissao) "
                    + "VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getUsuario());
            st.setString(2, obj.getNome());
            st.setString(3, obj.getEmail());
            st.setString(4, obj.getSenha());
            st.setString(5, obj.getTelefone());
            st.setString(6, obj.getPermissao());

            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);

                }
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    public void atualizar(Usuario obj) {
        PreparedStatement st;

        try {
            st = conn.prepareStatement("UPDATE usuarios SET usuario = ?, nome = ?, email = ?, senha = ?, telefone = ?, permissao = ?"
                    + " WHERE id = ?");
            st.setString(1, obj.getUsuario());
            st.setString(2, obj.getNome());
            st.setString(3, obj.getEmail());
            st.setString(4, obj.getSenha());
            st.setString(5, obj.getTelefone());
            st.setString(6, obj.getPermissao());
            st.setInt(7, obj.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    public void excluir(Integer id) {

        PreparedStatement st;

        try {
            st = conn.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public Usuario consultar(Integer id) {
        PreparedStatement st;
        ResultSet rs;

        try {
            st = conn.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
            st.setInt(1, id);

            rs = st.executeQuery();
            if (rs.next()) {
                Usuario obj = instantiateUsuario(rs);
                return obj;
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return null;
    }

    public List<Usuario> consultarTodos() {
        PreparedStatement st;
        ResultSet rs;

        try {
            st = conn.prepareStatement("SELECT * FROM usuarios ORDER BY id");
            rs = st.executeQuery();

            List<Usuario> list = new ArrayList<>();

            while (rs.next()) {
                Usuario obj = instantiateUsuario(rs);

                list.add(obj);
            }

            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    public Usuario validarLogin(String nome, String senha) {
        PreparedStatement sp;
        ResultSet rs;
        Usuario obj = null;
        
        try {
            sp = conn.prepareStatement("SELECT * FROM usuarios "
                    + "WHERE usuario = ? ");
            sp.setString(1, nome);
            

            rs = sp.executeQuery();
            if (rs.next()) {
                obj = instantiateUsuario(rs);
                
            }
            return obj;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
       

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDAO;

import conexaoBD.Conexao;
import conexaoBD.DbException;
import conexaoBD.Projetos;
import conexaoBD.SubProjeto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mariana Raio
 */
public class SubProjetoDAO {

    private Connection conn;

    public SubProjetoDAO(Connection conn) {
        this.conn = conn;

    }

    public SubProjetoDAO() {
        this.conn = Conexao.getConnection();
    }

    private SubProjeto instantiateSubProjeto(ResultSet rs) throws SQLException {
        SubProjeto obj = new SubProjeto();
        obj.setId(rs.getInt("id"));
        obj.setDescricao(rs.getString("descricao"));
        obj.setId_projetos(rs.getInt("id_projetos"));

        return obj;
    }

    public List<String> listarDescricao() {
        PreparedStatement st;
        ResultSet rs;

        try {
            st = conn.prepareStatement("SELECT descricao FROM subprojetos ");
            rs = st.executeQuery();

            List<String> list = new ArrayList<>();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                list.add(descricao);

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
            st = conn.prepareStatement("SELECT descricao FROM subprojetos WHERE id = ? ");
            st.setInt(1, id_projeto);
            rs = st.executeQuery();
            while(rs.next()){
                nome = rs.getString("descricao");
            }
            
               
            return nome;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    public Integer buscarId(String descricao) {
        PreparedStatement st;
        ResultSet rs;

        try {
            st = conn.prepareStatement("SELECT id, descricao, id_projetos FROM subprojetos WHERE descricao = ?");
            st.setString(1, descricao);

            rs = st.executeQuery();
            if (rs.next()) {
                SubProjeto obj = instantiateSubProjeto(rs);
                return obj.getId();
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return null;
    }
}

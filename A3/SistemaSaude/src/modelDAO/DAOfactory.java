/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDAO;

import conexaoBD.Conexao;
/**
 *
 * @author Mariana Raio
 */

public class DAOfactory {
    
    public static UsuarioDAO criarUsuario(){
        return new UsuarioDAO(Conexao.getConnection());
    }
    public static ProjetosDAO criarProjeto(){
        return new ProjetosDAO(Conexao.getConnection());
    }
    public static SubProjetoDAO criarSubProjeto(){
        return new SubProjetoDAO(Conexao.getConnection());
    }

}

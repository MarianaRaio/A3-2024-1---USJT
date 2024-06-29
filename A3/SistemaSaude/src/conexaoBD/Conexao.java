/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mariana Raio
 */
public class Conexao {

    private static String url = "jdbc:mysql://localhost:3306/sistema";
    private static String user = "root";
    private static String password = "admin2024";

    public static Connection getConnection() {
        try {
            Connection connection;
            // estabele a conexão com o banco de dados usando DriverManager
            connection = DriverManager.getConnection(url, user, password);
            // retorna a conexão
            return connection;
        }catch (SQLException e) {
            // caso dê erro ao se conectar com o banco de dados
            throw new DbException(e.getMessage());
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexaoBD;

/**
 *
 * @author Mariana Raio
 */
public class DbException extends RuntimeException{
    public DbException(String message) {
        // Chama o construtor da superclasse RuntimeException, passando a mensagem de erro
        super(message);
    }
}

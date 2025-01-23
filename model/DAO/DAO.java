import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class DAO{
    private final String url = "http://localhost/phpmyadmin/index.php?route=/database/structure&db=ecommerce"; // URL do banco de dados
	private final String user = "root"; // Usuário do banco
	private final String password = ""; // Senha do banco
    private boolean conectado = false;
    private Connection conn;

    public void conectar(){
        
        try {
            this.conn = DriverManager.getConnection(url, user, password);   
            this.conectado = true; 
        } catch (SQLException e) {
            System.out.println("Erro");
        }
    }

    public void desconectar(){

    }

}
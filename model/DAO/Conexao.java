
//import java.lang.classfile.Signature;
//import java.lang.classfile.instruction.ThrowInstruction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/ecommerce"; // URL do banco de dados
	private static final String user = "root"; // Usuário do banco
	private static final String password = ""; // Senha do banco

    public static Connection getConexao(){
        try {
            System.out.println("OK - Conectado");  
            return DriverManager.getConnection(url , user, password);    
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }
}


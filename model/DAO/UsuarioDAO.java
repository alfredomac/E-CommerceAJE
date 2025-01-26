import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

	private Connection conn;

	public UsuarioDAO () {
		//Conexao a = new Conexao();
        this.conn = Conexao.getConexao();
	}

    // Método para obter todas as categorias
	public List<Usuario> obterTodas() {
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM Usuario";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				
				usuarios.add(new Usuario(id,nome,endereco,email,senha));
			}
			
			return usuarios;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


    // Método para obter uma categoria pelo ID
	public Usuario obter(int id) {
		Usuario usuario = null;
		String sql = "SELECT * FROM Usuario WHERE id = ?";

		try {		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int idU = rs.getInt("id");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				
				usuario = new Usuario(idU, nome,endereco,email,senha);
			}
			
			return usuario;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	// Método para inserir uma nova categoria
	public boolean inserir(String nome, String endereco, String email, String senha ) {
		String sql = "INSERT INTO Usuario (nome,endereco,email,senha) VALUES (?,?,?,?)";

		try {	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nome);
			pstmt.setString(2, endereco);
			pstmt.setString(3, email);
			pstmt.setString(4, senha);
			
			int tuplasInseridas = pstmt.executeUpdate();
			
			if (tuplasInseridas > 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	// Método para atualizar uma categoria existente
	public boolean atualizar(String nome, String endereco, String email, String senha  , int id) {
		String sql = "UPDATE Usuario SET nome = ? endereco = ? email = ? senha = ? WHERE id = ?";

		try {		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nome);
			pstmt.setString(2, endereco);
			pstmt.setString(3, email);
			pstmt.setString(4, senha);
			
			int tuplasModificadas = pstmt.executeUpdate();

			if (tuplasModificadas > 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	// Método para remover uma categoria pelo ID
	public boolean remover(int id) {
		String sql = "DELETE FROM Usuario WHERE id = ?";

		try {		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "nome");
			pstmt.setString(2, "endereco");
			pstmt.setString(3, "email");
			pstmt.setString(4, "senha");
			pstmt.setInt(5,id);

			int tuplasRemovidas = pstmt.executeUpdate();
			
			if (tuplasRemovidas > 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		

	}

}
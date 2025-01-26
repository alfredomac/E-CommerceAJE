import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

	private Connection conn;

	public CategoriaDAO () {
		//Conexao a = new Conexao();
        this.conn = Conexao.getConexao();
	}


    // Método para obter todas as categorias
	public List<Categoria> obterTodas() {
		List<Categoria> categorias = new ArrayList<>();
		String sql = "SELECT * FROM Categoria";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String descricao = rs.getString("descricao");
				
				categorias.add(new Categoria(id, descricao));
			}
			
			return categorias;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


    // Método para obter uma categoria pelo ID
	public Categoria obter(int id) {
		Categoria categoria = null;
		String sql = "SELECT * FROM Categoria WHERE id = ?";

		try {		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String descricao = rs.getString("descricao");
				categoria = new Categoria(id, descricao);
			}
			
			return categoria;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	// Método para inserir uma nova categoria
	public boolean inserir(String descricao) {
		String sql = "INSERT INTO Categoria (descricao) VALUES (?)";

		try {	
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, descricao);
			
			int tuplasInseridas = pstmt.executeUpdate();
			System.out.println("OK - Inserido");
			if (tuplasInseridas > 0){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	// Método para atualizar uma categoria existente
	public boolean atualizar(String descricao, int id) {
		String sql = "UPDATE Categoria SET descricao = ? WHERE id = ?";

		try {		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, descricao);
			pstmt.setInt(2, id);
			
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
		String sql = "DELETE FROM Categoria WHERE id = ?";

		try {		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
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
		CategoriaDAO b = new CategoriaDAO();
		List<Categoria> categorias = new ArrayList<>();
		categorias = b.obterTodas();

		System.out.println( "Aqui" +  categorias.get(0).getNome());  ;


		Categoria x = new  Categoria(4,"4");
		x=b.obter(1);
		System.out.println(x.getNome());


	}

}
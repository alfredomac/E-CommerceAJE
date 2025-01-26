import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {

	private Connection conn;

	public CompraDAO () {
		//Conexao a = new Conexao();
        this.conn = Conexao.getConexao();
	}

    // Método para obter todas as categorias
	public List<Compra> obterTodas() {
		List<Compra> Compras = new ArrayList<>();
		String sql = "SELECT * FROM Compra";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				int idUsuario = rs.getInt("idUsuario");
				Timestamp dataHora = rs.getTimestamp("dataHora");
				Compras.add(new Compra(id,idUsuario,dataHora));
			}
			
			return Compras;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


    // Método para obter uma categoria pelo ID
	public Compra obter(int id) {
		Compra compra = null;
		String sql = "SELECT * FROM Compra WHERE id = ?";

		try {		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int idC = rs.getInt("id");
				int idUsuario = rs.getInt("idUsuario");
				Timestamp dataHora = rs.getTimestamp("dataHora");
				
				compra = new Compra(idC,idUsuario,dataHora);
			}
			
			return compra;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	// Método para inserir uma nova categoria
	public boolean inserir(int idUsuario, Timestamp dataHora) {
		String sql = "INSERT INTO Compra (idUsuario,dataHora) VALUES (?,?)";

		try {	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idUsuario);
			
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
	public boolean atualizar(int idUsuario, Timestamp dataHora, int id) {
		String sql = "UPDATE Compra SET nome = ? endereco = ? WHERE id = ?";

		try {		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idUsuario);
			
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
		String sql = "DELETE FROM Compra WHERE id = ?";

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

}
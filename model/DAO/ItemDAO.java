import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

	private Connection conn;

	public ItemDAO () {
		//Conexao a = new Conexao();
        this.conn = Conexao.getConexao();
	}

    // Método para obter todas as categorias
	public List<Item> obterTodas() {
		List<Item> items = new ArrayList<>();
		String sql = "SELECT * FROM item";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				int idProduto = rs.getInt("idProduto");
				int idCompra = rs.getInt("idCompra");
				int quantidade = rs.getInt("quantidade");
				float preco = rs.getInt("preco");
				
				items.add(new Item(id,idCompra,idProduto, quantidade, preco));
			}
			
			return items;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


    // Método para obter uma categoria pelo ID
	public Item obter(int id) {
		Item item = null;
		String sql = "SELECT * FROM item WHERE id = ?";

		try {		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int idI = rs.getInt("id");
				int idProduto = rs.getInt("idProduto");
				int idCompra = rs.getInt("idCompra");
				int quantidade = rs.getInt("quantidade");
				float preco = rs.getInt("preco");
				
				item = new Item(idI,idCompra,idProduto, quantidade, preco);
			}
			
			return item;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	// Método para inserir uma nova categoria
	public boolean inserir(int idCompra, int idProduto, int quantidade, float preco ) {
		String sql = "INSERT INTO item (idCompra, idProduto, quantidade, preco) VALUES (?,?,?,?)";

		try {	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idCompra);
			pstmt.setInt(2, idProduto);
			pstmt.setInt(3, quantidade);
			pstmt.setFloat(4, preco);
			
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
	public boolean atualizar(int idCompra, int idProduto, int quantidade, float preco, int id) {
		String sql = "UPDATE item SET idCompra = ? idProduto = ? quantidade = ? preco = ?  WHERE id = ?";

		try {		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idCompra);
			pstmt.setInt(2, idProduto);
			pstmt.setInt(3, quantidade);
			pstmt.setFloat(4, preco);
			
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
		String sql = "DELETE FROM item WHERE id = ?";

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

public class Item {
    private int  id;
    private int idCompra;
    private int idProduto;
    private int quantidade;
    private float preco;

    public Item(int id, int idCompra, int idProduto, int quantidade , float preco){
        this.id = id;
        this.idCompra = idCompra;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getIdCompra(){
        return this.idCompra;
    }

    public void setIdCompra(int idCompra){
        this.idCompra = idCompra;
    }
    
    public int getIdProduto(){
        return this.idProduto;
    }

    public void setIdProduto(int idProduto){
        this.idProduto = idProduto;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public float getPreco(){
        return this.preco;
    }

    public void setPreco(float preco){
        this.preco = preco;
    }


}
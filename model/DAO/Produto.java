

public class Produto {
    private int  id;
    private String descricao;
    private float preco;
    private String foto;
    private int quantidade;

    public Produto(int id, String descricao, float preco, String foto, int quantidade){
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.foto = foto;
        this.quantidade = quantidade;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public float getPreco(){
        return this.preco;
    }

    public void setPreco(float preco){
        this.preco = preco;
    }

    public String getFoto(){
        return this.foto;
    }

    public void setFoto(String foto){
        this.foto = foto;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

}
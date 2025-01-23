
import java.security.Timestamp;

public class Compra{
    private int  id;
    private int idUsuario;
    private Timestamp dataHora;
    

    public Compra(int id, int idUsuario ,Timestamp dataHora){
        this.id = id;
        this.idUsuario = idUsuario;
        this.dataHora = dataHora;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getIdUsuario(){
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }
    
    public Timestamp getDataHora(){
        return this.dataHora;
    }

    public void setDataHora(Timestamp dataHora){
        this.dataHora = dataHora;
    }

}
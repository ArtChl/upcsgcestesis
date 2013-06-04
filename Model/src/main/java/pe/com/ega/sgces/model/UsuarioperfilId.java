package pe.com.ega.sgces.model;
// Generated 04/06/2013 01:38:23 AM by Hibernate Tools 3.2.1.GA



/**
 * UsuarioperfilId generated by hbm2java
 */
public class UsuarioperfilId  implements java.io.Serializable {


     private int idUsuario;
     private int idPerfil;

    public UsuarioperfilId() {
    }

    public UsuarioperfilId(int idUsuario, int idPerfil) {
       this.idUsuario = idUsuario;
       this.idPerfil = idPerfil;
    }
   
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getIdPerfil() {
        return this.idPerfil;
    }
    
    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UsuarioperfilId) ) return false;
		 UsuarioperfilId castOther = ( UsuarioperfilId ) other; 
         
		 return (this.getIdUsuario()==castOther.getIdUsuario())
 && (this.getIdPerfil()==castOther.getIdPerfil());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdUsuario();
         result = 37 * result + this.getIdPerfil();
         return result;
   }   


}



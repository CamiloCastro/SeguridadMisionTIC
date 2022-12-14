package tutorial.misiontic.seguridad.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Usuario {

    @Id
    private String _id;
    private String seudonimo;
    private String correo;
    private String contrasena;
    private String cedula;

    @DBRef
    private Rol rol;

    public Usuario(String seudonimo, String correo, String contrasena, String cedula)
    {
        this.seudonimo = seudonimo;
        this.correo = correo;
        this.contrasena = contrasena;
        this.cedula = cedula;
    }

}

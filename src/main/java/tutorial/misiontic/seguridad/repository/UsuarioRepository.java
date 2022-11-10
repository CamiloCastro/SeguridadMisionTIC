package tutorial.misiontic.seguridad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tutorial.misiontic.seguridad.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena);

}

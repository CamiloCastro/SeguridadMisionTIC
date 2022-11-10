package tutorial.misiontic.seguridad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tutorial.misiontic.seguridad.model.Permiso;

import java.util.Optional;

public interface PermisoRepository extends MongoRepository<Permiso, String> {

    Optional<Permiso> findByUrlAndMetodo(String url, String metodo);

}

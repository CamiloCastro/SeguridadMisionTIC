package tutorial.misiontic.seguridad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tutorial.misiontic.seguridad.model.Permiso;
import tutorial.misiontic.seguridad.model.PermisoRol;
import tutorial.misiontic.seguridad.model.Rol;

import java.util.Optional;

public interface PermisoRolRepository extends MongoRepository<PermisoRol, String> {

    Optional<PermisoRol> findByRolAndPermiso(Rol rol, Permiso permiso);

}

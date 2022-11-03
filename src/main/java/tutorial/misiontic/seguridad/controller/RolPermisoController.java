package tutorial.misiontic.seguridad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tutorial.misiontic.seguridad.model.Permiso;
import tutorial.misiontic.seguridad.model.PermisoRol;
import tutorial.misiontic.seguridad.model.Rol;
import tutorial.misiontic.seguridad.repository.PermisoRepository;
import tutorial.misiontic.seguridad.repository.PermisoRolRepository;
import tutorial.misiontic.seguridad.repository.RolRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permisos-roles")
public class RolPermisoController {

    @Autowired
    private PermisoRolRepository permisoRolRepo;

    @Autowired
    private PermisoRepository permisoRepo;

    @Autowired
    private RolRepository rolRepo;

    @GetMapping("")
    public List<PermisoRol> index() {
        return this.permisoRolRepo.findAll();
    }

    @GetMapping("{id}")
    public PermisoRol show(@PathVariable String id) {
        Optional<PermisoRol> optPermiso = this.permisoRolRepo.findById(id);
        return optPermiso.orElse(null);
    }

    @PostMapping("")
    public PermisoRol create(@RequestBody PermisoRol p) {

        Optional<Permiso> optPermiso = this.permisoRepo.findById(p.getPermiso().get_id());
        if(optPermiso.isEmpty())
        {
            return null;
        }

        Optional<Rol> rolOpt = this.rolRepo.findById(p.getRol().get_id());

        if(rolOpt.isEmpty())
        {
            return null;
        }

        return this.permisoRolRepo.save(p);
    }

    @PutMapping("{id}")
    public PermisoRol update(@PathVariable String id, @RequestBody PermisoRol p) {
        Optional<PermisoRol> optPermiso = this.permisoRolRepo.findById(id);
        if(optPermiso.isPresent())
        {
            PermisoRol actual = optPermiso.get();

            return this.permisoRolRepo.save(actual);
        }
        return null;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id)
    {
        this.permisoRolRepo.deleteById(id);
    }

}

package tutorial.misiontic.seguridad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiciosPrueba {

    @GetMapping("/saludo")
    public String hello() {
        return "HOLA MUNDO";
    }

}

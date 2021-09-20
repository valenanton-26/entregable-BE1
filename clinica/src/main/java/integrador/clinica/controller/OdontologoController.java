package integrador.clinica.controller;

import integrador.clinica.model.Odontologo;
import integrador.clinica.repository.IOdontologoRepository;
import integrador.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    // CONSTRUCTOR
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    // METODOS
    @PostMapping("/agregar")
    public ResponseEntity<String> agregarOdontologo(@RequestBody Odontologo odontologo){
        ResponseEntity<String> respuesta = null;

        if(odontologoService.agregar(odontologo) != null){
            respuesta = ResponseEntity.ok("El odontologo fue agregado con éxito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("No se pudo agregar el odontologo");
        }

        return respuesta;
    }

    @GetMapping("/listado")
    public List<Odontologo> buscarTodos(){
        return odontologoService.buscarTodos();
    }


    @GetMapping(path = "{id}")
    public Optional<Odontologo> buscarPorId(@PathVariable Long id){
        return odontologoService.buscarPorId(id);
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable("id") Long id){
        odontologoService.eliminarPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}

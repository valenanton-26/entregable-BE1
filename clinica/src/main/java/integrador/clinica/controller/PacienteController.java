package integrador.clinica.controller;

import integrador.clinica.model.Odontologo;
import integrador.clinica.model.Paciente;
import integrador.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // METODOS
    @PostMapping("/agregar")
    public ResponseEntity<String> agregarPaciente(@RequestBody Paciente paciente){
        ResponseEntity<String> respuesta = null;

        if(pacienteService.agregar(paciente) != null){
            respuesta = ResponseEntity.ok("El paciente fue agregado con éxito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("No se pudo agregar al paciente");
        }

        return respuesta;
    }

    @GetMapping("/listado")
    public List<Paciente> buscarTodos(){
        return pacienteService.listadoPacientes();
    }


    @GetMapping(path = "{id}")
    public Optional<Paciente> buscarPorId(@PathVariable Long id){
        return pacienteService.buscarPorId(id);
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable("id") Long id){
        pacienteService.eliminarPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

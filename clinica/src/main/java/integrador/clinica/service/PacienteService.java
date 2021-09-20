package integrador.clinica.service;

import integrador.clinica.model.Odontologo;
import integrador.clinica.model.Paciente;
import integrador.clinica.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public String agregar(Paciente paciente){
        if(pacienteRepository.save(paciente) != null){
            return "OK";
        }else{
            return null;
        }
    }

    public List<Paciente> listadoPacientes(){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscarPorId(Long id){
        return pacienteRepository.findById(id);
    }

    public void eliminarPorId(Long id){
        pacienteRepository.deleteById(id);
    }
}

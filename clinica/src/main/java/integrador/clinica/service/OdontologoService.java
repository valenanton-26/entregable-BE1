package integrador.clinica.service;

import integrador.clinica.model.Odontologo;
import integrador.clinica.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public String agregar(Odontologo odontologo){
        if(odontologoRepository.save(odontologo) != null){
            return "Ok";
        }else{
            return null;
        }
    }

    public List<Odontologo> buscarTodos(){
        return odontologoRepository.findAll();
    }

    public Optional<Odontologo> buscarPorId(Long id){
        return odontologoRepository.findById(id);
    }


    public void eliminarPorId(Long id){
        odontologoRepository.deleteById(id);
    }

}

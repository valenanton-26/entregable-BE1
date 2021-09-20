package integrador.clinica.model;

import javax.persistence.*;

@Entity
@Table
public class Domicilio {

    // ATRIBUTOS Y ELEMENTOS DE LA TABLA
    @Id
    @SequenceGenerator(name="domicilio_sequence", sequenceName = "domicilio_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_sequence")
    private Long id;

    private String calle;
    private Integer numero;
    private String depto;
    private String localidad;


    // CONSTRUCTOR
    public Domicilio(){

    }
    public Domicilio(String calle, Integer numero, String depto, String localidad) {
        this.calle = calle;
        this.numero = numero;
        this.depto = depto;
        this.localidad = localidad;
    }

    // GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDepto() {
        return depto;
    }
    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}

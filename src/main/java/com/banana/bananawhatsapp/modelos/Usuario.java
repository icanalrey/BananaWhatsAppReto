package com.banana.bananawhatsapp.modelos;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name ="email")
    private String email;

    @Column(name="alta")
    private LocalDate alta;

    @Column(name ="activo")
    private boolean activo;

    public Usuario(Object o, String ricardo, String mail, LocalDate now, boolean b) {
    }


    private boolean validarNombre() {
        return this.nombre != null && this.nombre.length() >= 3;
    }

    private boolean validarEmail() {
        return this.email != null && this.email.indexOf("@") > 0 && this.email.indexOf(".") > 0;
    }

    private boolean validarAlta() {
        return this.alta != null && this.alta.compareTo(LocalDate.now()) <= 0;
    }

    public boolean valido() throws UsuarioException {
        if ((id != null && id > 0 || id == null)
                && activo
                && validarNombre()
                && validarEmail()
                && validarAlta()
        ) return true;
        else throw new UsuarioException("Usuario no valido");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getAlta() {
        return alta;
    }

    public void setAlta(LocalDate alta) {
        this.alta = alta;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

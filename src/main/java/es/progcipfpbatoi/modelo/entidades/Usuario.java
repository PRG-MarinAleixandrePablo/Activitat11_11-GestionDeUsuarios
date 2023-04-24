package es.progcipfpbatoi.modelo.entidades;

import es.progcipfpbatoi.utils.Validator;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario {

    private String nombre;
    private String apellidos;
    private String dni;
    private String correoElectronico;
    private String codigoPostal;
    private String telefono;
    private LocalDate birthday;
    private String password;

    public Usuario(String nombre, String apellidos, String dni, String correoElectronico, String codigoPostal, String telefono, LocalDate birthday, String password) {
        this.birthday = birthday;

        //Comprobar nombre si es válido
        if (Validator.validarNombre(nombre)) {
            this.nombre = nombre;
        }

        //Comprobar apellido si es válido
        if ( Validator.validarApellidos(apellidos)) {
            this.apellidos = apellidos;
        }

        //Comprobar dni si es válido
        if ( Validator.validarDni(dni)) {
            this.dni = dni;
        }

        //Comprobar correo si es válido
        if ( Validator.validarEmail(correoElectronico)) {
            this.correoElectronico = correoElectronico;
        }

        //Comprobar si el código postal es válido
        if ( Validator.validarcodPostal(codigoPostal)) {
            this.codigoPostal = codigoPostal;
        }

        //Comprobar si el teléfono es válido
        if ( Validator.validarTelefono(telefono)) {
            this.telefono = telefono;
        }

        //Comprobar contraseña si es válida
        if ( Validator.validarContrasenya(password)) {
            this.password = password;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getPassword() {
        return password;
    }

    public String getDni() {
        return dni;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(dni, usuario.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return "Usuario {" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", telefono='" + telefono + '\'' +
                ", birthday=" + birthday +
                ", password='" + password + '\'' +
                '}';
    }
}
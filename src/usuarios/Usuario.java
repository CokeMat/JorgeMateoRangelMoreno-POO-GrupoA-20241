package usuarios;

import usuarios.utils.Curp;
import usuarios.utils.Rol;
import utils.Fecha;
import utils.Id;

public class Usuario {
    private String nombre, apellidoP, apellidoM, direccion, fechaDeRegistro, fechaDeNacimiento, CURP;
    private String estado;
    private String genero;
    private String nombreUsuario, contrasena;
    private String rol;
    private String numeroControl, carrera;
    // Falta el numero de control Edgaron, todos los Usuarios tienen uno

    public Usuario(String nombre, String apellidoP, String apellidoM,
            String fechaDeNacimiento, String fechaDeRegistro, String direccion, String estado, String genero,
            String nombreUsuario,
            String contrasena, Rol rol,
            String carrera) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.fechaDeRegistro = fechaDeRegistro;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.estado = estado;
        this.genero = genero;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.CURP = Curp.generate(this.apellidoP, this.apellidoM, this.nombre, this.fechaDeNacimiento, this.genero,
                this.estado);
        this.rol = rol.toString();
        this.carrera = carrera;
        this.numeroControl = Id.generateNumeroControl(this.nombre, this.carrera, rol);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        this.CURP = Curp.generate(this.apellidoP, this.apellidoM, this.nombre, this.fechaDeNacimiento, this.genero,
                this.estado);
        // this.numeroControl = Id.generateNumeroControl(this.nombre, this.carrera, );

    }

    public String getApellidoP() {
        return apellidoP;

    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
        this.CURP = Curp.generate(this.apellidoP, this.apellidoM, this.nombre, this.fechaDeNacimiento, this.genero,
                this.estado);
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
        this.CURP = Curp.generate(this.apellidoP, this.apellidoM, this.nombre, this.fechaDeNacimiento, this.genero,
                this.estado);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;

    }

    public String getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(String fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.CURP = Curp.generate(this.apellidoP, this.apellidoM, this.nombre, this.fechaDeNacimiento, this.genero,
                this.estado);
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
        this.CURP = Curp.generate(this.apellidoP, this.apellidoM, this.nombre, this.fechaDeNacimiento, this.genero,
                this.estado);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
        this.CURP = Curp.generate(this.apellidoP, this.apellidoM, this.nombre, this.fechaDeNacimiento, this.genero,
                this.estado);
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreCompleto() {
        return String.format("%s %s", nombre, apellidoP);
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;

    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        String dato = String.format(
                "\n| NOMBRE: %s | APELLIDOS: %s %s | FECHA NACIMIENTO: %s | GENERO: %s | \n| CURP: %s | " +
                        " | ESTADO: %s | DIRECCION: %s | FECHA DE REGISTRO: %s | NOMBRE DE USUARIO: %s |  NUMERO DE CONTROL: %s | CARRERA: %s |",
                getNombre(), getApellidoP(), getApellidoM(),
                Fecha.imprimirFechaCompleta(getFechaDeNacimiento()), getGenero(), getCURP(),
                getEstado(), getDireccion(), Fecha.imprimirFechaCompleta(getFechaDeRegistro()), getNombreUsuario(),
                getNumeroControl(),
                getCarrera());

        return dato;
    }// creo q el ultimo de getRol , no es necesario, o si?
     // creo que no
     // gabo, por q salen como dos fechas despues de la info de cada alumno? cuales?,
     // metete a la terminal, ssale alumnos de sistemas y luego dos fechas y asi

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

}
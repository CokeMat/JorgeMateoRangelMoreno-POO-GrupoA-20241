package src.usuarios;

import java.time.LocalDate;
import src.fintech.utils.DatosComun;
import src.usuarios.utils.*;

public class Usuario {
    private String nombre, apellidoM, apellidoP;
    private String fechaNacimiento, fechaRegistro;
    private Genero genero;
    private Estado estado;
    private String Direccion, Ciudad;
    private String CURP, RFC;
    private String nombreUsuario, contrasena;
    private Rol rol;
    private String id;
    private String numTelefono;
    private boolean isActive;

    public Usuario(String nombre, String ApellidoM, String ApellidoP, String fechaNacimiento, Genero genero,
            Estado Estado, String Direccion, String ciudad,
            String nombreUsuario, String Contrasena, Rol rol, String numTelefono, String id) {

        this.nombre = nombre.toUpperCase();
        this.apellidoM = ApellidoM.toUpperCase();
        this.apellidoP = ApellidoP.toUpperCase();
        this.genero = genero;
        this.estado = Estado;
        this.Direccion = Direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = DatosComun.formateoFecha(LocalDate.now());
        this.Ciudad = ciudad;
        this.CURP = Curp.generate(this.apellidoP, this.apellidoM, this.nombre, this.fechaNacimiento, genero, Estado);
        this.RFC = Rfc.generate(this.apellidoP, this.apellidoM, this.nombre, this.fechaNacimiento);
        this.nombreUsuario = nombreUsuario;
        this.contrasena = Contrasena;
        this.rol = rol;
        this.numTelefono = numTelefono;
        this.id = id;
        this.isActive = false;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
        this.CURP = Curp.generate(apellidoP, apellidoM, this.nombre, fechaNacimiento, genero, estado);
        this.RFC = Rfc.generate(apellidoP, apellidoM, this.nombre, fechaNacimiento);
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM.toUpperCase();
        this.CURP = Curp.generate(apellidoP, this.apellidoM, nombre, fechaNacimiento, genero, estado);
        this.RFC = Rfc.generate(apellidoP, this.apellidoM, nombre, fechaNacimiento);
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP.toUpperCase();
        this.CURP = Curp.generate(this.apellidoP, apellidoM, nombre, fechaNacimiento, genero, estado);
        this.RFC = Rfc.generate(this.apellidoP, apellidoM, nombre, fechaNacimiento);
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        this.CURP = Curp.generate(apellidoP, apellidoM, nombre, this.fechaNacimiento, genero, estado);
        this.RFC = Rfc.generate(apellidoP, apellidoM, nombre, this.fechaNacimiento);
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public String getNombreCompleto() {
        return String.format("%s %s", nombre, apellidoP);
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
        this.CURP = Curp.generate(apellidoP, apellidoM, nombre, fechaNacimiento, this.genero, estado);
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
        this.CURP = Curp.generate(apellidoP, apellidoM, nombre, fechaNacimiento, genero, this.estado);
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String cURP) {
        CURP = cURP;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String rFC) {
        RFC = rFC;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Rol getRol() {
        return rol;
    }

    public void setDireccion(Rol rol) {
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    

    @Override
    public String toString() {
        String datosParte1 = String.format(
                "\n| NOMBRE: %s | APELLIDOS: %s %s | FECHA NACIMIENTO: %s | GENERO: " + getGenero().toString() + " |\n",
                getNombre(), getApellidoP(), getApellidoM(), getFechaNacimiento());
        String datosParte2 = String.format(
                "| CURP: %s | RFC: %s | ID: %s | NUMERO TELEFONO: %s |\n| ESTADO: "
                        + EntidadFederativa.getStringEstado(getEstado())
                        + " | CIUDAD: %s | DIRECCION: %s | FECHA DE REGISTRO: %s | \n",
                getCURP(), getRFC(), getId(), getNumTelefono(), getCiudad(), getDireccion(), getFechaRegistro().toString());
        return datosParte1 + datosParte2;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean b){
        this.isActive = b;
    }
}

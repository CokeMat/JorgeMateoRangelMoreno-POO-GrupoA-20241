package src.fintech.movimientos;

import java.time.*;
import src.fintech.utils.DatosComun;
import src.fintech.Sys;
import src.fintech.movimientos.utils.TipoMovimiento;
import src.usuarios.Usuario;
import src.utils.SucursalActual;


public class MovimientoBancario {
    private Usuario usuario;
    private double monto;
    private String horaMovimiento;
    private TipoMovimiento tipoMovimiento;


    public MovimientoBancario(Usuario usuario, double monto, TipoMovimiento tipoMovimiento) {
        this.usuario = usuario;
        this.monto = monto;
        this.horaMovimiento = DatosComun.formateoFecha(LocalDateTime.now());
        this.tipoMovimiento = tipoMovimiento;
    }


    @Override
    public String toString() {
        return String.format("\n | USUARIO: %s | TIPO DE USUARIO: %s | MONTO: % .2f | TIPO DE MOVIMIENTO %s | HORA DEL MOVIMIENTO: %s |", usuario.getNombreCompleto(), usuario.getRol().toString(), monto, tipoMovimiento.toString(), horaMovimiento);
    }

    public static void registrarMovimiento(Usuario usuario, double monto, TipoMovimiento tipoMovimiento){
        Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaMovimientoBancarios().add(new MovimientoBancario(usuario, monto, tipoMovimiento));
    }
}
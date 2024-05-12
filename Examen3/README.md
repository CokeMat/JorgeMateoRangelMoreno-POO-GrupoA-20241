# SISTEMA DE GESTIÓN DE TARJETAS Y USUARIOS DEL FINTECH💰
## Integrantes del proyecto
1. Gabriel Chacón Arellano
2. Jorge Mateo Rangel Moreno
3. Edgar Daniel Martínez López

Para la realización de este proyecto utilizamos conocimientos aprendidos en le tercera unidad de la materia de Programación Orientada a Objetos. Abarcando lo siguiente:
- HashMaps
- Herencia
- Sobreescritura de métodos
- Manejo de excepciones
- Uso del patrón Singleton
- Uso de ENUMS

Las indicaciones para llevar a cabo este proyecto están contenidas en el siguiente enlace: [Instrucciones](https://itmorelia-ejercicios-eder.notion.site/POO-Examen-Unidad-3-f7fd4c0181fd463995eeff7695e9b9bd)

## Estructura del código
### Clase Main
En esta clase se incializa la ejecución del programa haciendo uso de la clase `Sys`.
### Clase `Sys`
Esta clase contiene un HashMap, el cuál tiene en sus clave la sucursal, mientras que en el value contiene una instancia de la clase `Fintech`.
En esta clase se pregunta al ususario por la sucursal a la cual quiere acceder. Así como el inicio de sesión.

### Clase `Fintech`
Esta clase tiene un HashMap, el cual tiene en su clave el rol de usuario que desea acceder(Cliente, gerente, ejecutivo de cuenta o inversionista), mientras que en sus values contiene ArrayList de tipo Usuario, esto con el fin de almacenar todos los usuarios en listas. El HashMap permite clasificar las listas de acuerdo el rol del usuario. Facilitando la búsqueda de datos, así como ahorrando trabajo para la computadora.

### Clase `Menu`
En esta clase se mandan llamar todas las funciones con las que cuenta el sistema. Una vez que un usuario inicia sesión en el sistema, se le desplegará un menú u otro dependiendo de su rol con el que fue registrado.


Método que envía a cada usuario a su menú correspondiente:
```java
public static void seleccionarMenu() {
        switch (UsuarioEnSesion.getInstancia().getUsuarioActual().getRol()) {
            case CLIENTE -> ejecutarMenuCliente();
            case GERENTE -> ejecutarMenuGerente();
            case CAPTURISTA -> ejecutarMenuCapturista();
            case EJECUTIVO -> ejecutarMenuEjecutivo();
            case INVERSIONISTA -> ejecutarMenuInversionista();
        }
    }
```
Ejemplo del menú del cliente:
```java
private static void ejecutarMenuCliente() {
        boolean flag = true;
        int contador = 0;
        saludarUsuario();
        while (flag) {
            //Notificación
            if (contador == 0) Cliente.mostrarNotificacion();
            System.out.println("\n ¿Qué desea hacer?");
            System.out.println("1. Consultar información personal");
            System.out.println("2. Modificar información personal");
            System.out.println("3. Hacer un depósito a una tarjeta");
            System.out.println("4. Retirar dinero de una tarjeta");
            System.out.println("5. Consultar información sobre mis tarjetas");
            System.out.println("6. Solicitar una tarjeta de crédito");
            System.out.println("7. Ver mis solicitudes de tarjeta de crédito");
            System.out.println("8. Cerrar sesión");
            contador++;
            int option = Ask.forInt("el número de opción");

            switch (option) {
                case 1 -> {
                    System.out.println("----------------MI INFORMACIÓN PERSONAL-----------------------");
                    System.out.println(UsuarioEnSesion.getInstancia().getUsuarioActual());
                }
                case 2 -> Cliente.modificarInfoPersonal();
                case 3 -> Cliente.depositar();
                case 4 -> Cliente.retirar();
                case 5 -> Cliente.consultarInfoTarjeta();
                case 6 -> Cliente.solicitarTarjeta();
                case 7 -> Cliente.verSolicitudes();
                case 8 -> {
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    flag = false;
                }
                default -> System.out.println("Se ingresó una opción inválida, intenta de nuevo");
            }
        }

    }
```
## Clase `Usuario`
Esta clase funciona como plantilla para los diferentes tipos de usuarios registrados en el sistema. Esta contiene todos los atributos requeridos para todos los usuarios, así como los getters y setters. A partir de la clase Usuario heredan las siguientes:
- `Cliente`
- `Inversionista`
- `Empleado`
### Clase `Empleado`
Es muy similar a la de Usuario, sin embargo, contiene algunos atributos únicos de los empleados como son el horario y el salario. De la clase `Empleado` heredan las siguientes:
- `Capturista`
- `Ejecutivo`
- `Gerente`

### Uso del principio "Tell, don't ask"
Para la creación de los CRUDS de todos los usuarios nos encargamos de colocarlos en sus clases correspondientes. Es decir, el código empleado para realizar cualquier operación con un cliente está contenida en su totalidad en la clase `Cliente`. Dandole una mejor estructura y organización al proyecto

---
# Clases auxiliares
## Clase `UsuarioEnSesion`
Esta clase sigue el patrón Singleton, el cuál evita tener que pasar como parámetro al usuario en sesión a todos los métodos del proyecto. 
```java
public class UsuarioEnSesion {
    private static UsuarioEnSesion instancia;
    private Usuario usuarioActual;

    private UsuarioEnSesion() {
    }

    public static UsuarioEnSesion getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioEnSesion();
        }
        return instancia;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuario(Usuario usuario) {
        this.usuarioActual = usuario;
    }

    public boolean hayUsuarioActual() {
        return usuarioActual != null;
    }

    public void cerrarSesion() {
        instancia = null;
        usuarioActual = null;
    }
}
```

## Clase `SucursalActual`
Al igual que la clase `UsuarioEnSesion`, sigue el patrón Singleton. Permite conocer al programa en todo momento la sucursal en la que se encuentra el usuario. Podiendo ser accedida por todas las clases.

```java
public class SucursalActual {
    private static SucursalActual instancia;
    private Sucursal sucursalActual;

    private SucursalActual() {
    }

    public static SucursalActual getInstancia() {
        if (instancia == null) {
            instancia = new SucursalActual();
        }
        return instancia;
    }

    public Sucursal getSucursalActual() {
        return sucursalActual;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursalActual = sucursal;
    }

    public boolean hayUsuarioActual() {
        return sucursalActual != null;
    }

    public void cerrarSucursal() {
        instancia = null;
        sucursalActual = null;
    }
}
```

## Clase Tarjeta
Una de las condiciones solicitadas en las instrucciones era que los clientes pudieran contar con una tarjeta de debito y hasta 3 tarjetas de crédito. Para ello nos apoyamos de una clase Tarjeta, de la cual heredan las siguientes:
- Debito
- Credito

Al igual que con los usuarios, seguimos el principio "Tell, don't ask", colocando la lógica de cada tipo de tarjeta en su clase correspondiente.

## Clase Solicitud
Los clientes tienen como opción solicitar una tarjeta de crédito si cuentan con el saldo suficiente para ello. Para ello debe hacer una petición, la cual puede ser aceptada o rechazada por un trabajador del Fintech. Esta clase permite almacenar todos los datos necesarios para el empleado.
Dentro de esta clase se encuentra el código que se encarga de aceptar, rechazar y mostrar las solicitudes registradas en el sistema. Evitando saturar las clases de los trabajadores. Ya que unicamente tienen que hacer uso de la clase `Solicitud` para llevar a cabo sus actividades.
Ejemplo:

```java
public static void menuSolicitudes() {// MENÚ DINÁMICO PARA LAS SOLICITUDES
        if (Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual())
                .getListaSolicitudes().isEmpty()) {
            System.out.println("No hay solicitudes registradas en el sistema");
        } else {
            boolean flag = true;
            while (flag) {
                if (Solicitud.containsEstatus(Estatus.PENDIENTE)) {
                    System.out.println("\n************** Tiene solicitudes pendientes ***************");
                }
                System.out.println("\n¿Qué desea realizar?");
                System.out.println("1. Ver todas las solicitudes registradas en el sistema");
                System.out.println("2. Mostrar las solicitudes aprobadas");
                System.out.println("3. Mostrar las solicitudes rechazadas");
                System.out.println("4. Mostrar las solicitudes pendientes");
                System.out.println("5. Aceptar una tarjeta de crédito");
                System.out.println("6. Rechazar una tarjeta de crédito");
                System.out.println("7. Volver al menu principal");
                int option = Ask.forInt("el número de opción");

                switch (option) {
                    case 1 -> Solicitud.mostrarListaSolicitudes();
                    case 2 -> Solicitud.mostrarListaSolicitudes(Estatus.APROBADA);
                    case 3 -> Solicitud.mostrarListaSolicitudes(Estatus.RECHAZADA);
                    case 4 -> Solicitud.mostrarListaSolicitudes(Estatus.PENDIENTE);
                    case 5 -> Solicitud.aceptarSolicitud(CLAVE_GERENTE);
                    case 6 -> Solicitud.rechazarSolicitud(CLAVE_GERENTE);
                    case 7 -> {
                        System.out.println("Regresando al menu principal...");
                        flag = false;
                    }
                    default -> System.out.println("Se ingresó una opción inválida, intenta de nuevo");
                }
            }

        }
    }
```
## Clase MovimientoBancario
El banco desea conocer todos los movimientos bancarios que son realizados en el sistema. Por lo que cada vez que se hace un depósito o un retiro son registrados en un ArrayList las operaciones realizadas. Y cuando el gerente lo desee puede visualizar todos los movimientos bancarios realizados en el sistema


```java
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
```

# Conclusiones
Con la realización de este proyecto sentimos una gran satisfacción. Ya que hemos notado un avance significativo en nuestras habilidades técnicas, respecto al comienzo del semestre. Logramos implementar patrones y principios que nos permiten crear código de calidad. Así como aprovechar librerias y estructuras de datos que hacen más sencillo el trabajo.

Sin duda este tipo de proyectos nos permiten seguir en nuestra vida personal y profesional debido a la exigencia que requieren.


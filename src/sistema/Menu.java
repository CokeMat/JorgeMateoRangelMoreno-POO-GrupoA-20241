package sistema;

import usuarios.Usuario;
import usuarios.Alumnos.Alumno;
import usuarios.Trabajadores.*;
import utils.*;

public class Menu {

    public static void ejecutarMenuPrincipal() {
        System.out.println("***********BIENVENIDO A MINDBOX DEL INSTITUTO TECNOLOGICO DE MORELIA***************");
        while (true) {
            iniciarSesion();
            System.out.println("¿Desea iniciar sesión nuevamente?");
            System.out.println("1. SI \n2. NO");
            int ans = Ask.forInt("el número de opción");
            if (ans == 1)
                iniciarSesion();
            else {
                System.out.println("Gracias por utilizar Mindbox, vuelva pronto :))");
                break;
            }
        }

    }

    private static void iniciarSesion() {
        int contador = 0;
        boolean datosCorrectos = false;
        System.out.print("\n----------------Inicie sesión para continuar----------------");
        do {
            String nombreUsuario = Ask.forString("el nombre de usuario");
            String contrasena = Ask.forString("la contraseña");

            Usuario usuario = Sistema.verificarInicioSesion(nombreUsuario, contrasena);

            if (usuario != null) {
                UsuarioEnSesion.getInstancia().setUsuario(usuario);
                datosCorrectos = true;
                Menu.seleccionarMenu();
            } else {
                contador++;
                if (contador == 3) {
                    System.out.println("Ha excedido el número de intentos. Volviendo al menú anterior...");
                }
                System.out.println("Nombre de usuario o contraseña incorrectos. Intente de nuevo");
            }
        } while (!datosCorrectos && contador != 3);
    }

    public static void seleccionarMenu() {
        if (UsuarioEnSesion.getInstancia().getUsuarioActual() instanceof Trabajador) {
            if (UsuarioEnSesion.getInstancia().getUsuarioActual() instanceof Coordinador) {
                Coordinador coordinador = (Coordinador) UsuarioEnSesion.getInstancia().getUsuarioActual();
                CarreraActual.getInstancia().setCarreraActual(coordinador.getCarrera());
                ejecutarMenuCoordinador();
            } else {
                Profesor profesor = (Profesor) UsuarioEnSesion.getInstancia().getUsuarioActual();
                CarreraActual.getInstancia().setCarreraActual(profesor.getCarrera());
                ejecutarMenuProfesor();
            }
        } else {
            Alumno alumno = (Alumno) UsuarioEnSesion.getInstancia().getUsuarioActual();
            CarreraActual.getInstancia().setCarreraActual(alumno.getCarrera());
            ejecutarMenuAlumno();
        }
    }

    private static void ejecutarMenuAlumno() {
        saludarUsuario();//
        int opcion = 0;
        boolean flag = true;
        while (flag) {
            System.out.println("\n-----------------OPCIONES DEL ALUMNO-----------------");
            System.out.println("1. Consultar información personal");
            System.out.println("2. Modificar información personal");
            System.out.println("3. Consultar la información del semestre actual");// la info completa de los 3 periodos
            System.out.println("4. Consultar información de una materia en específico");
            System.out.println("5. Consultar mi historial de calificaciones");
            System.out.println("6. Cerrar sesión");
            opcion = Ask.forInt("una opcion");
            switch (opcion) {
                case 1 -> Alumno.consultarInfo();
                case 2 -> Alumno.modificarInfoPersonal();
                case 3 -> Alumno.consultarInfoSemestre();
                case 4 -> Alumno.consultarInfoMateria();
                case 5 -> Alumno.consultarHistorialCalficaciones();
                case 6 -> {
                    flag = false;
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    CarreraActual.getInstancia().cerrarCarreraActual();
                    System.out.println("Cerrando sesión...");// listo
                }
                default -> System.out.println("Se ingresó una opción inválida, intente de nuevo");
            }
        }
    }

    private static void ejecutarMenuProfesor() {
        saludarUsuario();
        int opcion = 0;
        boolean flag = true;
        while (flag) {
            System.out.println("\n-----------------OPCIONES DEL PROFESOR-----------------");
            System.out.println("1. Consultar informacion personal");
            System.out.println("2. Modificar informacion personal");
            System.out.println("3. Ver mis grupos");
            System.out.println("4. Asignar calificaciones");
            System.out.println("5. Salir");

            opcion = Ask.forInt("una opcion");
            switch (opcion) {
                case 1 -> Profesor.consultarInfo();
                case 2 -> Profesor.modificarInfoPersonal();
                case 3 -> Profesor.verGrupos();
                case 4 -> Profesor.asignarCalificacion();
                case 5 -> {
                    flag = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Se ingresó una opción inválida, intente de nuevo");
            }
        }
    }

    private static void ejecutarMenuCoordinador() {
        saludarUsuario();
        int opcion = 0;
        boolean flag = true;
        while (flag) {
            System.out.println("\n-----------------OPCIONES DEL COORDINADOR-----------------");
            System.out.println("1. Ir al apartado de alumnos");
            System.out.println("2. Ir al apartado de profesores");
            System.out.println("3. Ir al apartado de docente(como coordinador)");
            System.out.println("4. Ir al apartado de grupos");
            System.out.println("5. Ir al apartado de materias");
            System.out.println("6. Ver la lista de alumnos graduados");
            System.out.println("7. Ver la información de la carrera");
            System.out.println("8. Consultar información personal");
            System.out.println("9. Modificar información personal");
            System.out.println("10. Salir");
            opcion = Ask.forInt("una opcion");
            switch (opcion) {
                case 1 -> Coordinador.apartadoAlumnos();
                case 2 -> Coordinador.apartadoProfesores();
                case 3 -> Coordinador.apartadoDocente();
                case 4 -> Coordinador.apartadoGrupos();
                case 5 -> Coordinador.apartadoMaterias();
                case 6 -> Coordinador.listaGraduados();// JORCH,
                case 7 -> Coordinador.mostrarInfoCarrera();// JORCH
                case 8 -> Coordinador.consultarInfo();// hola, smn
                case 9 -> Coordinador.modificarInfoPersonal();// hola, te puedes rifar estos dos métodos porfa?? vap
                case 10 -> {
                    flag = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Se ingreso una opción inválida, intente de nuevo");
            }
        }
    }

    private static void saludarUsuario() {
        System.out.printf("\n*********BIENVENIDO AL SISTEMA %s*********\n",
                UsuarioEnSesion.getInstancia().getUsuarioActual().getNombreCompleto());
    }
}

## POO-EXAMEN FINAL
# MINDBOX 
## Integrantes del proyecto
1. Gabriel Chacón Arellano
2. Jorge Mateo Rangel Moreno
3. Edgar Daniel Martínez López
4. Israel Ramirez Morales

Para la realización de este proyecto utilizamos conocimientos aprendidos durante toda la materia de Programación Orientada a Objetos. Abarcando lo siguiente:
- HashMaps
- Herencia
- Sobreescritura de métodos
- Manejo de excepciones
- Uso del patrón Singleton
- Uso de ENUMS
- Serializers de Json
- Deserializers de Json


Las indicaciones para llevar a cabo este proyecto están contenidas en el siguiente enlace: [Instrucciones](https://itmorelia-ejercicios-eder.notion.site/POO-Examen-Final-0a7a92ddc8b24876aa683a34b0f86ad3)

## Estructura del código
## SISTEMA
### Clase `Main`
En esta clase se incializa la ejecución del programa haciendo uso de la clase `Sistema`.
### Clase `Sistema`
Esta clase contiene varios HashMap, donde se van almacenando profesores, alumnos, coordinadores, carreras, graduados, historiales, etc. ,asi como algunos de estos usuarios precargados para agilizar el proceso del sistema, los metodos para guardar los datos en un archivo Json, luego otro metodo para poder leer este mismo y asi como el verificar el inicio de sesion.

### Clase `Menu`
En esta clase se mandan llamar todas las funciones con las que cuenta el sistema. Una vez que un usuario inicia sesión en el sistema, se le desplegará un menú u otro dependiendo de su rol con el que fue registrado.


Método que envía a cada usuario a su menú correspondiente:
```java
public static void seleccionarMenu() {
        if (UsuarioEnSesion.getInstancia().getUsuarioActual() instanceof Trabajador) {
            if (UsuarioEnSesion.getInstancia().getUsuarioActual() instanceof Coordinador) {
                Coordinador coordinador = (Coordinador) UsuarioEnSesion.getInstancia().getUsuarioActual();
                CarreraActual.getInstancia().setCarreraActual(coordinador.getCarrera());
                ejecutarMenuCoordinador();
            } else {
                ejecutarMenuProfesor();
            }
        } else {
            Alumno alumno = (Alumno) UsuarioEnSesion.getInstancia().getUsuarioActual();
            CarreraActual.getInstancia().setCarreraActual(alumno.getCarrera());
            ejecutarMenuAlumno();
        }
}
```
Ejemplo del menú para los Alumnos:
```java
 private static void ejecutarMenuAlumno() {
        saludarUsuario();//
        int opcion = 0;
        boolean flag = true;
        while (flag) {
            System.out.println("-----------------OPCIONES DEL ALUMNO-----------------");
            System.out.println("1. Consultar información personal");
            System.out.println("2. Modificar información personal");
            System.out.println("3. Consultar la información del semestre actual");
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
                    System.out.println("Cerrando sesión...");
                }
                default -> System.out.println("Se ingresó una opción inválida, intente de nuevo");
            }
        }
    }
```
## USUARIOS
## Clase `Usuario`
Esta clase funciona como plantilla para los diferentes tipos de usuarios registrados en el sistema. Esta contiene todos los atributos requeridos para todos los usuarios, así como los getters y setters. A partir de la clase Usuario heredan las siguientes:
- `Alumno`

 La clase Trabajador hereda de esta pero hereda a las clases de:
- `Coordinador`
- `Profesor`

### Clase `Trabajador`
Es muy similar a la de Usuario, sin embargo, contiene algunos atributos únicos de los trabajadores como son el sueldo y el RFC. De la clase `Trabajador` heredan las siguientes:
- `Coordinador`
- `Profesor`

## Clase Coordinador
EL sistema nos dice que el coordinador es el rango mas alto del sistema por lo cual puede hacer cualquier operacion dentro del mismo entonces, lo que hicimos fue crear varios apartados para el menu del coordinador, para que haga distintas funciones, incluyendo la parte de que un coordinador también puede ser profesor.


```java
 private static void ejecutarMenuCoordinador() {
        saludarUsuario();
        int opcion = 0;
        boolean flag = true;
        while (flag) {
            System.out.println("-----------------OPCIONES DEL COORDINADOR-----------------");
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
                case 6 -> System.out.println();// Coordinador.listaGraduados();
                case 7 -> System.out.println();// Carrera.mostrarInfo();
                case 8 -> Coordinador.consultarInfo();
                case 9 -> Coordinador.modificarInfoPersonal();
                case 10 -> {
                    flag = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Se ingreso una opción inválida, intente de nuevo");
            }
        }
    }
```
## Clase Profesor
En este sistema fue requerido que el profesor pueda elegir sus materias, asignara calificaciones a sus alumnos, etc. Entonces hicimos metodos para que uno por uno (alumnos) fuera asignando sus calificaciones y que pudiera ver sus grupos.

Ejemplo de metodo para asignar calificación:
```java
    public static void asignarCalificacion() {// hola
        Profesor profesor = (Profesor) UsuarioEnSesion.getInstancia().getUsuarioActual();
        ArrayList<String> listaMaterias = profesor.getMateriasImpartidas();
        System.out.println("Debemos obtener los datos de la materia y del alumno para poder asignarle su calificación");
        int ansOption = 0;
        String nombreMateria = "";

        while (true) {
            System.out.println("Ingrese el número de opción para la materia");
            int n = 1;
            for (String materia : listaMaterias) {
                System.out.printf("\n %d. %s", n, materia);
                n++;
            }
            ansOption = Ask.forInt("la opción numérica");
            if (ansOption >= 1 && ansOption <= listaMaterias.size()) {
                nombreMateria = listaMaterias.get(ansOption - 1);
                break;
            } else {
                System.out.println("Ingresó una opción inválida");
                System.out.println("¿Desea intentarlo de nuevo?");
                System.out.println("1. SI\n2. NO");
                int ans = Ask.forInt("una opción");
                if (ans != 1) {
                    break;
                }
            }
        }
        String nombreCarrera = "";
        if (!nombreMateria.equals("")) {
            System.out.println("Ahora seleccione una opción para la carrera");
            while (true) {
                System.out.println("Ingrese el número de opción para la carrera");
                for (int i = 1; i <= 3; i++) {
                    if (i == 1)
                        System.out.println("1. SISTEMAS");
                    else if (i == 2)
                        System.out.println("2. ELECTRONICA");
                    else
                        System.out.println("3. MATERIALES");
                }
                ansOption = Ask.forInt("la opción numérica");
                if (ansOption >= 1 && ansOption <= 3) {
                    switch (ansOption) {
                        case 1 -> nombreCarrera = "SISTEMAS";
                        case 2 -> nombreCarrera = "ELECTRONICA";
                        case 3 -> nombreCarrera = "MATERIALES";
                    }
                    break;
                } else {
                    System.out.println("Ingresó una opción inválida");
                    System.out.println("¿Desea intentarlo de nuevo?");
                    System.out.println("1. SI\n2. NO");
                    int ans = Ask.forInt("una opción: ");
                    if (ans != 1) {
                        break;
                    }
                }
            }
        }
        // sino aqui se acaba
        String numeroControl = "";
        if (!nombreCarrera.equals("")) {
            if (Sistema.carreras.get(nombreCarrera).getMaterias().containsKey(nombreMateria)) {
                boolean flag = false;
                HashMap<String, Grupo> gruposProfesor = new HashMap<>();
                // verificar que realmente imparta la materia
                for (Materia materia : Sistema.carreras.get(nombreCarrera).getMaterias().get(nombreMateria)) {
                    if (materia.getProfesor().getNumeroControl().equals(profesor.getNumeroControl())) {
                        // aqui aseguramos que la imparte
                        Grupo grupo = Grupo.getGrupo(nombreCarrera, materia);
                        gruposProfesor.put(materia.getId(), grupo);// si hay 2 aquí tendrían la misma key, cuidado con
                                                                   // eso
                        flag = true;
                    }
                }
                if (flag) {
                    if (gruposProfesor.size() == 1) {// SOLO UN GRUPO
                        System.out.println("Usted sólo cuenta con un grupo");

                        Set<String> claves = gruposProfesor.keySet();
                        String keyMapa = "";
                        for (String string : claves) {
                            keyMapa = string;
                        }
                        if (gruposProfesor.get(keyMapa).getAlumnosGrupo().isEmpty()) {
                            System.out.println("No hay alumnos registrados en el grupo");
                        } else {
                            while (true) {
                                System.out.println("Aquí está la lista de números de control para este grupo");
                                for (Alumno alumno : gruposProfesor.get(keyMapa).getAlumnosGrupo()) {
                                    System.out.printf(" | NOMBRE DEL ALUMNO: %s | NÚMERO DE CONTROL DEL ALUMNO: %s |",
                                            alumno.getNombreCompleto(), alumno.getNumeroControl());
                                }
                                System.out.println("\nAhora debe ingresar el número de control del alumno");
                                numeroControl = Ask.forString("el número de control del alumno");
                                if (Alumno.getAlumno(nombreCarrera, numeroControl) == null) {
                                    System.out.println("No se encontró al alumno, ¿desea intentarlo de nuevo?");
                                    System.out.println("1. SI\n 2. NO");
                                    int ans = Ask.forInt("una opción: ");
                                    if (ans != 1) {
                                        numeroControl = "";
                                        break;
                                    }
                                } else
                                    break;
                            }
                        }

                    } else {
                        // debe elegir primero la key si grupo A o grupo B
                        System.out.println("Usted imparte esta materia a más de un grupo, elija el grupo");
                        String keyMapa = "";
                        boolean bandera = true;
                        while (bandera) {// obtenemos la key
                            System.out.println("Elija una opción");
                            for (int i = 0; i < 2; i++) {
                                if (i == 0)
                                    System.out.println((i + 1) + ". GRUPO A");
                                else if (i == 1)
                                    System.out.println((i + 1) + ". GRUPO B");
                            }
                            int ans = Ask.forInt("el número de opción: ");
                            if (ans >= 1 && ans <= 2) {
                                Set<String> claves = gruposProfesor.keySet();
                                int n = 1;// para los alumnos
                                for (String string : claves) {
                                    if (n == ans) {
                                        keyMapa = string;
                                        bandera = false;
                                        break;
                                    } else {
                                        n++;
                                    }
                                }
                            } else {
                                System.out.println("Opción inválida trate de nuevo");
                            }
                        }

                        // obtener la key con un fori
                        if (gruposProfesor.get(keyMapa).getAlumnosGrupo().isEmpty()) {
                            System.out.println("Este grupo no tiene alumnos registrados");
                        } else {
                            System.out.println("Aquí está la lista de números de control para este grupo");
                            while (true) {
                                for (Alumno alumno : gruposProfesor.get(keyMapa).getAlumnosGrupo()) {
                                    System.out.printf(" | NOMBRE DEL ALUMNO: %s | NÚMERO DE CONTROL DEL ALUMNO: %s |",
                                            alumno.getNombreCompleto(), alumno.getNumeroControl());
                                }
                                System.out.println("\nAhora debe ingresar el número de control del alumno");
                                numeroControl = Ask.forString("el número de control del alumno");
                                if (Alumno.getAlumno(nombreCarrera, numeroControl) == null) {
                                    System.out.println("No se encontró al alumno, ¿desea intentarlo de nuevo?");
                                    System.out.println("1. SI\n 2. NO");
                                    int ans = Ask.forInt("una opción: ");
                                    if (ans != 1) {
                                        numeroControl = "";
                                        break;
                                    }
                                } else
                                    break;
                            }
                        }
                    }
                } else {
                    System.out.println("No se econtró ningún grupo que lo tenga a usted asignado como profesor");
                }
            } else {
                System.out.println("La carrera que ingresó no cuenta con esta materia");
            }
        }
        if (!numeroControl.equals("")) {
            System.out.println("\nAhora debe ingresar la calificación del alumno");
            while (true) {
                double calificacion = Ask.forDouble("la calificación: ");
                if (calificacion >= 0 && calificacion <= 100) {
                    String periodoActual = NumeroPeriodo.numerosPeriodo.get(Sistema.semestreActual.get(nombreCarrera));
                    for (Curso curso : Sistema.historiales.get(nombreCarrera).get(numeroControl).getPeriodos()
                            .get(periodoActual).getMateriasPeriodo()) {
                        if (curso.getMateria().getNombre().equals(nombreMateria)) {
                            int indexCurso = Sistema.historiales.get(nombreCarrera).get(numeroControl).getPeriodos()
                                    .get(periodoActual).getMateriasPeriodo().indexOf(curso);
                            Sistema.historiales.get(nombreCarrera).get(numeroControl).getPeriodos()
                                    .get(periodoActual).getMateriasPeriodo().get(indexCurso)
                                    .setCalificacionAsignada(true);
                            Sistema.historiales.get(nombreCarrera).get(numeroControl).getPeriodos()
                                    .get(periodoActual).getMateriasPeriodo().get(indexCurso)
                                    .setCalificacionFinal(calificacion);
                            curso.setCalificacionFinal(calificacion);
                            curso.setCalificacionAsignada(true);
                            System.out.println("Se asignó la calificación!");
                            break;
                        }
                    }
                    break;
                } else {
                    System.out.println("Ingresó un valor inválido para la calificación");
                    System.out.println("¿Desea intentarlo de nuevo?");
                    System.out.println("1. SI\n2. NO");
                    int ans = Ask.forInt("una opción");
                    if (ans != 1)
                        break;

                }
            }

        }
    }
```

### Uso del principio "Tell, don't ask"
Para la creación de los CRUDS de todos los usuarios nos encargamos de colocarlos en sus clases correspondientes. Es decir, el código empleado para realizar cualquier operación con un alumno está contenida en su totalidad en la clase `Alumno`. Dandole una mejor estructura y organización al proyecto

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

## Clase `CarreraActual`
Al igual que la clase `UsuarioEnSesion`, sigue el patrón Singleton. Permite conocer al programa en todo momento la carrera en la que se encuentra el usuario. Podiendo ser accedida por todas las clases.

```java
public class CarreraActual {
    private static CarreraActual instancia;
    private String carreraActual;

    private CarreraActual() {
    }

    public static CarreraActual getInstancia() {
        if (instancia == null) {
            instancia = new CarreraActual();
        }
        return instancia;
    }

    public String getCarreraActual() {
        return carreraActual;
    }

    public void setCarreraActual(String carreraActual) {
        this.carreraActual = carreraActual;
    }

    public boolean hayUsuarioActual() {
        return carreraActual != null;
    }

    public void cerrarCarreraActual() {
        instancia = null;
        carreraActual = null;
    }

}
```
## JSON
## Clases Serializer
Una de las condiciones solicitadas en las instrucciones era que toda la información debe de guardarse en archivos JSON para que se tenga siempre un registro de la información, para eso se usaron las clases Serializer para cada tipo de usuario, historial y carrera, estas escriben o registran los usuarios que se van registrando a la hora de usar el programa en un archivo Json.

Ejemplo de clase serializer:
```java
public class AlumnoSerializer {
    public static void serialize() {
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("alumnos.json"));
            json.toJson(Sistema.alumnos, writer);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
```
## Clases Deserializer
Una de las condiciones solicitadas en las instrucciones era que toda la información debe de guardarse en archivos JSON para que se tenga siempre un registro de la información, para eso se usaron las clases Serializer para cada tipo de usuario, historial y carrera, estas leen el archivo Json y su contenido se va pasando a objetos o lenguaje Java.

Ejemplo de clase Deserializer:
```java
public class AlumnoDeserializer {
    public static void deserialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("alumnos.json"));
            Gson gson = new Gson();
            AlumnoModel alumnosModel = gson.fromJson(reader, AlumnoModel.class);

            ArrayList<Alumno> sistemas = new ArrayList<>(alumnosModel.getListaSistemas());
            ArrayList<Alumno> materiales = new ArrayList<>(alumnosModel.getListaMateriales());
            ArrayList<Alumno> electronica = new ArrayList<>(alumnosModel.getListaElectronica());

            Sistema.alumnos.put(NombreCarrera.SISTEMAS.toString(), sistemas);
            Sistema.alumnos.put(NombreCarrera.MATERIALES.toString(), materiales);
            Sistema.alumnos.put(NombreCarrera.ELECTRONICA.toString(), electronica);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (JsonSyntaxException e) {
            System.out.println(e);
        } catch (JsonParseException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
```

## ESCUELA
## Clase Historial
Los alumnos tienen la opcion de ver su historial de materias, ver el periodo, el semestre, carrera, etc. Entonces lo que hicimos fue hacer una clase historial que contrajera un HashMap de periodos que estons son tipo: "AGOSTO_DICIEMBRE_2023".

## Clase Curso
Aqui en esta clase se guarda el periodo, las materias, si la calificacion fue asignada o no y la calificacion final, complementando el historial del alumno.

## Clase Periodo
En esta clase se le siguio dando formato a lo que es el historial del alumno agregando el formato de las calificaciones.
```java
public void formatoCalificaciones() {
        // Como en el mindbox
        System.out.println("\n |    MATERIA    | \t |  CALIFICAION  | \t |   OBSERVACIONES   | ");
        boolean pendientePorAsignar = false;

        for (Curso curso : getMateriasPeriodo()) {
            String nombreMateria = curso.getMateria().getNombre();
            String cad = String.format("\n | %s | ", nombreMateria);

            
            int espaciosRestantes = 15 - nombreMateria.length();
            for (int i = 0; i < espaciosRestantes; i++) {
                cad += " ";
            }

            cad += String.format("| %.0f | ", curso.getCalificacionFinal());

            if (!curso.isCalificacionAsignada()) {
                cad += " | CALIFICACION NO ASIGNADA | ";
                pendientePorAsignar = true;
            } else {
                if (curso.getCalificacionFinal() >= 70)
                    cad += " | CURSO APROBADO | ";
                else
                    cad += " | CURSO NO APROBADO | ";
            }
            System.out.print(cad);
        }
        System.out.printf("\n ***ESTATUS DEL PERIODO: %s ***", getEstatus());

        if (pendientePorAsignar) {
            System.out.println("\nNo han sido asignada todas las calificaciones");
            System.out.println("Por lo que aún no podemos determinar su calificación final de este periodo");
        } else {
            System.out.printf("\n | CALIFICACION FINAL DEL PERIODO %. 2f |", getPromedioFinal());
            if (getPromedioFinal() >= 70)
                System.out.println(" | RESULTADO DEL PERIODO: **APROBADO** | ");
            else
                System.out.println(" | RESULTADO DEL PERIODO: **NO APROBADO** | ");
        }
    }
```


## Clase Semestre
En esta clase se gestiona la información sobre un semestre académico, incluyendo su identificador, número, carrera y los grupos de estudiantes. Los grupos se inicializan con las materias correspondientes a la carrera y al número de semestre, organizando la estructura necesaria para gestionar las calificaciones y materias de los estudiantes del sistema.


## Así se mostraría el historial de un alumno: 

![alt text](f4ae45f6-6799-4bf2-97bf-bf40a25bb2b8-1.jpeg)

# Conclusión
Con la realización de este proyecto sentimos una gran satisfacción y alegria. Ya que pusimos en practica todas las habilidades, tecnicas y temas vistos en toda la materia de Programación Orientada a Objetos. También hubo un ambiente sano y alegre durante todo este proceso lo que hizo que fluyera mejor el trabajo en equipo y surgieran mejores ideas. Asi como aprendimos a usar archivos Json, como escribirlos y leerlos, aun que nos costo mucho terminarlo creo que al final nos resulto un excelente proyecto y estamos muy orgullosos de este.



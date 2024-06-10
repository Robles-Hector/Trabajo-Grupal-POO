package Grupo_K;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class GrupoK_MainPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GrupoK_Encuesta encuesta = new GrupoK_Encuesta();
        GrupoK_Barrio barrio = new GrupoK_Barrio(null, null);
        int opcion;
        do {
            System.out.println("----------------------------");
            System.out.println("Ingrese la opción a realizar");
            System.out.println("1. Iniciar encuesta");
            System.out.println("2. Salir");
            System.out.println("----------------------------");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    encuesta.AgregarPersona();
                    encuesta.Encuesta();
                    encuesta.RegistrarPersona();
                    guardarEncuestaEnCSV(encuesta);
                    break;
                case 2:
                    System.out.println("Gracias por utilizar este sistema de encuestas");
                    break;
                default:
                    System.out.println("La opción ingresada es incorrecta");
            }
        } while (opcion != 2);
        scanner.close();
    }

    private static void guardarEncuestaEnCSV(GrupoK_Encuesta encuesta) {
        try {
            FileWriter writer = new FileWriter("encuesta.csv");
            writer.append("Nombre,Apellido,Genero,Ocupacion,DNI,Etnia,FechaNacimiento,Edad,IdEncuesta,Paredes,Piso,Habitaciones,"
            		+ "Banos,Neveras,Lavadoras,Secadoras,Televisores,Vehiculos\n");
            writer.append(encuesta.nombre + "," + encuesta.apellido + "," + encuesta.genero + "," + encuesta.ocupacion + "," + 
            		encuesta.dni + "," + encuesta.etnia + "," + encuesta.fechaNacimiento + "," + encuesta.edad + "," + 
            		encuesta.idEncuesta + "," + encuesta.paredes + "," + encuesta.piso + "," + encuesta.habitaciones + "," + 
            		encuesta.banos + "," + encuesta.neveras + "," + encuesta.lavadoras + "," + encuesta.secadoras + "," + 
            		encuesta.televisores + "," + encuesta.vehiculos + "\n");
            writer.flush();
            writer.close();
            System.out.println("Los datos de la encuesta se han guardado en encuesta.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package Grupo_K;
 
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;  

public class GrupoK_PersonaCensada {
	
	public Scanner scanner = new Scanner (System.in);
	public String nombre, apellido, genero, ocupacion, dni, etnia, fechaNacimiento;
	public int edad;
	
	public GrupoK_PersonaCensada(){
		
	}
	
	public GrupoK_PersonaCensada (String nombre, String apellido, String genero, String ocupacion, String dni, String etnia, String fechaNacimiento, int edad){
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.ocupacion = ocupacion;
		this.dni = dni;
		this.etnia = etnia;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public void AgregarPersona(){
	    // ingreso nombre
	    System.out.println("Ingrese su nombre: ");
	    nombre = scanner.nextLine();
	    while (!nombre.matches("[a-zA-Z ]+")) {
	        System.out.println("Nombre inválido. Inténtelo de nuevo: ");
	        nombre = scanner.nextLine();
	    }
	    // ingreso apellido
	    System.out.println("Ingrese su apellido: ");
	    apellido = scanner.nextLine();
	    while (!apellido.matches("[a-zA-Z ]+")) {
	        System.out.println("Apellido inválido. Inténtelo de nuevo: ");
	        apellido = scanner.nextLine();
	    }
	    // ingreso genero
	    System.out.println("Ingrese su genero (Masculino o Femenino): ");
	    genero = scanner.nextLine();
	    while (!genero.equalsIgnoreCase("Masculino") && !genero.equalsIgnoreCase("Femenino")) {
	        System.out.println("Género inválido. Inténtelo de nuevo: ");
	        genero = scanner.nextLine();
	    }
	    // ingreso edad
	    do {
	        System.out.println("Ingrese su edad (debe ser mayor o igual a 18 y menor a 70): ");
	        while (!scanner.hasNextInt()) {
	            System.out.println("Por favor, ingrese un número válido para la edad: ");
	            scanner.next(); 
	        }
	        edad = scanner.nextInt();
	        if (edad < 18 || edad >= 70) {
	            System.out.println("La edad ingresada está fuera del rango permitido. Inténtelo de nuevo.");
	        }
	        scanner.nextLine(); 
	    } while (edad < 18 || edad >= 70);
	    // ingreso fecha nacimiento
	    System.out.println("Ingrese su fecha de nacimiento: ");
	    fechaNacimiento = scanner.nextLine();
	    while (!fechaNacimiento.matches("\\d{2}/\\d{2}/\\d{4}")) {
	        System.out.println("Formato de fecha inválido. Inténtelo de nuevo (DD/MM/AAAA): ");
	        fechaNacimiento = scanner.nextLine();
	    }
	    // ingreso ocupacion
	    System.out.println("Ingrese su ocupacion: ");
	    ocupacion = scanner.nextLine();
	    while (ocupacion.isEmpty()) {
	        System.out.println("La ocupación no puede estar vacía. Inténtelo de nuevo: ");
	        ocupacion = scanner.nextLine();
	    }
	    // ingreso DNI
	    System.out.println("Ingrese su DNI: ");
	    dni = scanner.nextLine();
	    while (dni.isEmpty() || !dni.matches("\\d{1,10}")) {
	        System.out.println("DNI inválido. Inténtelo de nuevo (máximo 10 dígitos, no puede estar vacío): ");
	        dni = scanner.nextLine();
	    }
	    // ingreso etnia
	    System.out.println("Ingrese su etnia (Meztiso, Blanco, Afroamericano, Indigena): ");
	    etnia = scanner.nextLine();
	    while (!etnia.matches("(Meztiso|Blanco|Afroamericano|Indigena)")) {
	        System.out.println("Etnia inválida. Inténtelo de nuevo: ");
	        etnia = scanner.nextLine();
	    }
	}
	
	public void RegistrarPersona(){
		
		System.out.println("Nombre: " + nombre);
		System.out.println("Apellido: " + apellido);
		System.out.println("Genero: " + genero);
		System.out.println("Edad: " + edad);
		System.out.println("Fecha de nacimiento: " + fechaNacimiento);
		System.out.println("Ocupacion: " + ocupacion);
		System.out.println("DNI: " + dni);
		System.out.println("Etnia: " + etnia);
	}
	// Metodo para guardar en CSV
    public void guardarEnCSV(String nombreArchivo) {
        try {
            FileWriter writer = new FileWriter(nombreArchivo + ".csv");
            writer.append("Nombre,Apellido,Genero,Edad,FechaNacimiento,Ocupacion,DNI,Etnia\n");
            writer.append(nombre + "," + apellido + "," + genero + "," + edad + "," + fechaNacimiento + "," + ocupacion + "," + dni + "," + etnia + "\n");
            writer.flush();
            writer.close();
            System.out.println("Los datos se han guardado en " + nombreArchivo + ".csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package Grupo_K;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GrupoK_Casa {
    // Atributos
    private String direccion;
    private int habitantes;
    private Scanner scanner;
    // Constructor
    public GrupoK_Casa(String direccion, int habitantes) {
        this.direccion = direccion;
        this.habitantes = habitantes;
        scanner = new Scanner(System.in);
    }
    // Métodos
    public void registrarCasa() {
        System.out.println("Casa registrada en: " + direccion);
    }

    public void agregarHabitante() {
        int habitantesAgregar;
        System.out.println("Ingrese el número de habitantes a agregar (debe ser un número positivo y menor que 10): ");
        // Validación de entrada
        while (true) {
            if (scanner.hasNextInt()) {
                habitantesAgregar = scanner.nextInt();
                if (habitantesAgregar > 0 && habitantesAgregar < 10) {
                    break; // Salir del bucle si la entrada es válida
                } else {
                    System.out.println("El número ingresado debe ser un número positivo y menor que 10. Inténtelo de nuevo: ");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número positivo y menor que 10: ");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
        // Agregar habitantes
        if (this.habitantes + habitantesAgregar < 10) {
            this.habitantes += habitantesAgregar;
            System.out.println("Habitantes agregados: " + habitantesAgregar);
            System.out.println("Total de habitantes ahora: " + this.habitantes);
        } else {
            System.out.println("No se pueden agregar más de 10 habitantes en total.");
        }
    }

    public void eliminarHabitante() {
        if (this.habitantes > 0) {
            this.habitantes--;
            System.out.println("Habitante eliminado.");
            System.out.println("Total habitantes: " + habitantes);
        } else {
            System.out.println("No hay habitantes para eliminar.");
        }
    }

    // Getters y Setters
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }
 // Método para guardar en CSV
    public void guardarEnCSV(String nombreArchivo) {
        try {
            FileWriter writer = new FileWriter(nombreArchivo + ".csv");
            writer.append("Direccion,Habitantes\n");
            writer.append(direccion + "," + habitantes + "\n");
            writer.flush();
            writer.close();
            System.out.println("Los datos se han guardado en " + nombreArchivo + ".csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package Grupo_K;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class GrupoK_CasaArriendo extends GrupoK_Casa {
    private int tiempoArriendo;
    private double valorArriendo;
    public GrupoK_CasaArriendo(String nombre, String apellido, int edad, String genero, String ocupacion, String DNI, String etnia, 
    		String fechaNacimiento, String direccion, int habitantes, int tiempoArriendo, double valorArriendo) {
        super(nombre, edad);
        this.tiempoArriendo = tiempoArriendo;
        this.valorArriendo = valorArriendo;
    }
    public void IngresoCasaArriendo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tiempo que lleva arrendando: ");
        tiempoArriendo = scanner.nextInt();
        
        System.out.println("Ingrese el valor del arriendo (debe ser mayor a 50 y menor a 500): ");
        while (true) {
            valorArriendo = scanner.nextDouble();
            if (valorArriendo > 50 && valorArriendo < 500) {
                break; // Salir del bucle si el valor es válido
            } else {
                System.out.println("El valor del arriendo debe ser mayor a 50 y menor a 500. Inténtelo de nuevo: ");
            }
        }
    }
    @Override
    public void agregarHabitante() {
        double valorTotal;
        valorTotal = tiempoArriendo * valorArriendo;
        System.out.println("Su gasto total en arriendo es: " + valorTotal);
    }
 // Metodo para guardar en CSV
    public void guardarEnCSV(String nombreArchivo) {
        try {
            FileWriter writer = new FileWriter(nombreArchivo + ".csv");
            writer.append("Direccion,Habitantes,TiempoArriendo,ValorArriendo\n");
            writer.append(getDireccion() + "," + getHabitantes() + "," + tiempoArriendo + "," + valorArriendo + "\n");
            writer.flush();
            writer.close();
            System.out.println("Los datos se han guardado en " + nombreArchivo + ".csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package Grupo_K;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException; 

public class GrupoK_CasaPropia extends GrupoK_Casa {
	//Atributos
	private int tiempoAdquisicion;
	private boolean cumplimientoImpuestos;
	private String hipoteca; 
	//Constructor
	public GrupoK_CasaPropia(String nombre, String apellido, int edad, String genero, String ocupacion, String DNI, String etnia, 
			String fechaNacimiento, String direccion, int habitantes, int tiempoAdquisicion, boolean cumplimintoImpuestos, 
			String hipoteca, boolean cumplimientoImpuestos) {
		super(nombre, edad);
		this.tiempoAdquisicion = tiempoAdquisicion;
		this.cumplimientoImpuestos = cumplimientoImpuestos;
		this.hipoteca = hipoteca; 
	}
	//Metodos
    public void informacionHipoteca() {
        System.out.println("Información de la hipoteca: " + hipoteca);
    }
    //Getters y Setters
    public int getTiempoAdquisicion() {
        return tiempoAdquisicion;
    }

    public void setTiempoAdquisicion(int tiempoAdquisicion) {
        this.tiempoAdquisicion = tiempoAdquisicion;
    }

    public boolean isCumplimientoImpuestos() {
        return cumplimientoImpuestos;
    }

    public void setCumplimientoImpuestos(boolean cumplimientoImpuestos) {
        this.cumplimientoImpuestos = cumplimientoImpuestos;
    }

    public String getHipoteca() {
        return hipoteca;
    }

    public void setHipoteca(String hipoteca) {
        this.hipoteca = hipoteca;
    }
 // Metodo para guardar en CSV
    public void guardarEnCSV(String nombreArchivo) {
        try {
            FileWriter writer = new FileWriter(nombreArchivo + ".csv");
            writer.append("Direccion,Habitantes,TiempoAdquisicion,CumplimientoImpuestos,Hipoteca\n");
            writer.append(getDireccion() + "," + getHabitantes() + "," + tiempoAdquisicion + "," + cumplimientoImpuestos + "," + 
            hipoteca + "\n");
            writer.flush();
            writer.close();
            System.out.println("Los datos se han guardado en " + nombreArchivo + ".csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package Grupo_K;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class GrupoK_Barrio {
    // Atributos
    private String nombreBarrio;
    private String tipoBarrio;
    private ArrayList<GrupoK_Casa> casas;

    // Constructor
    public GrupoK_Barrio(String nombreBarrio, String tipoBarrio) {
        this.nombreBarrio = nombreBarrio;
        this.tipoBarrio = tipoBarrio;
        this.casas = new ArrayList<>();
    }

    // Métodos
    public void ingresarDatosBarrio(Scanner scanner) {
        System.out.println("Ingrese el nombre del Barrio: ");
        nombreBarrio = scanner.nextLine();
        // Validación del tipo de barrio
        while (true) {
            System.out.println("Ingrese el tipo de barrio (Rural o Urbano): ");
            tipoBarrio = scanner.nextLine();
            if (tipoBarrio.equalsIgnoreCase("Rural") || tipoBarrio.equalsIgnoreCase("Urbano")) {
                break; // Salir del bucle si el tipo de barrio es válido
            } else {
                System.out.println("Tipo de barrio inválido. Por favor, ingrese 'Rural' o 'Urbano'.");
            }
        }
    }

    public void mostrarDatosBarrio() {
        System.out.println("Barrio: " + nombreBarrio);
        System.out.println("Tipo: " + tipoBarrio);
        System.out.println("Casas en el barrio:");
        for (GrupoK_Casa casa : casas) {
            System.out.println("- Dirección: " + casa.getDireccion() + ", Habitantes: " + casa.getHabitantes());
        }
    }

    public void agregarCasa(GrupoK_Casa casa) {
        casas.add(casa);
        System.out.println("Casa agregada en el barrio: " + nombreBarrio);
    }

    public void eliminarCasa(String direccion) {
        GrupoK_Casa casaAEliminar = null;
        for (GrupoK_Casa casa : casas) {
            if (casa.getDireccion().equalsIgnoreCase(direccion)) {
                casaAEliminar = casa;
                break;
            }
        }
        if (casaAEliminar != null) {
            casas.remove(casaAEliminar);
            System.out.println("Casa eliminada: " + direccion);
        } else {
            System.out.println("No se encontró una casa con la dirección proporcionada.");
        }
    }

    public void listarCasas() {
        System.out.println("Listado de casas en el barrio " + nombreBarrio + ":");
        for (GrupoK_Casa casa : casas) {
            System.out.println("Dirección: " + casa.getDireccion() + ", Habitantes: " + casa.getHabitantes());
        }
    }

    // Getters y Setters
    public String getNombreBarrio() {
        return nombreBarrio;
    }

    public void setNombreBarrio(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }

    public String getTipoBarrio() {
        return tipoBarrio;
    }

    public void setTipoBarrio(String tipoBarrio) {
        this.tipoBarrio = tipoBarrio;
    }

    public ArrayList<GrupoK_Casa> getCasas() {
        return casas;
    }

    public void setCasas(ArrayList<GrupoK_Casa> casas) {
        this.casas = casas;
    }

    // Método para guardar en CSV
    public void guardarEnCSV(String nombreArchivo) {
        try {
            FileWriter writer = new FileWriter(nombreArchivo + ".csv");
            writer.append("NombreBarrio,TipoBarrio\n");
            writer.append(nombreBarrio + "," + tipoBarrio + "\n");

            writer.append("Direccion,Habitantes\n");
            for (GrupoK_Casa casa : casas) {
                writer.append(casa.getDireccion() + "," + casa.getHabitantes() + "\n");
            }

            writer.flush();
            writer.close();
            System.out.println("Los datos se han guardado en " + nombreArchivo + ".csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package Grupo_K;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException; 

public class GrupoK_Encuesta extends GrupoK_PersonaCensada{
	int idEncuesta;
	int paredes;
	int piso;
	int habitaciones;
	int banos;
	int neveras;
	int lavadoras;
	int secadoras;
	int televisores;
	int vehiculos;
	public GrupoK_Encuesta() {
        // Constructor vacio
    }
	public GrupoK_Encuesta (String nombre, String apellido, String genero, String ocupacion, String dni, String etnia, 
			String fechaNacimiento, int edad, int idEncuesta, int paredes, int piso, int habitaciones, int banos, int neveras, 
			int lavadoras, int secadoras, int televisores, int vehiculos) {
		super (nombre, apellido, genero, ocupacion, dni, etnia, fechaNacimiento, edad);
		this.idEncuesta = idEncuesta;
		this.paredes = paredes;
		this.piso = piso;
		this.habitaciones = habitaciones;
		this.banos = banos;
		this.neveras = neveras;
		this.lavadoras = lavadoras;
		this.secadoras = secadoras;
		this.televisores = televisores;
		this.vehiculos = vehiculos;
    }
	
	public void Encuesta(){
		System.out.println("Ingrese el materiasl de las paredes de la vivienda (1/5)");
		System.out.println("1. Hormigon/Bloque/Ladrillo");
		System.out.println("2. Madera");
		System.out.println("3. Caña/Estera");
		System.out.println("4. Adobe/Tapia");
		System.out.println("5. Otro");
		paredes = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese el materiasl del piso de la vivienda");
		System.out.println("1. Baldosa/Vinyl/Ceramica");
		System.out.println("2. Marmol/Marmeton");
		System.out.println("3. Cemento/Ladrillo");
		System.out.println("4. Tierra");
		System.out.println("5. Otro");
		piso = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese la cantidad de habitaciones");
		habitaciones = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese la cantidad de baños");
		banos = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese la cantidad de neveras");
		neveras = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese la cantidad de lavadoras");
		lavadoras = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese la cantidad de secadoras");
		secadoras = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese la cantidad de televisores");
		televisores = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese la cantidad de vehiculos");
		vehiculos = scanner.nextInt();
		scanner.nextLine();
	}
	@Override
	public void RegistrarPersona(){
		super.RegistrarPersona();
		System.out.println("Materiasl de las paredes: " + paredes);
		System.out.println("Materiasl del piso: " + piso);
		System.out.println("Cantidad de habitaciones: " + habitaciones);
		System.out.println("Cantidad de baños: " + banos);
		System.out.println("Cantidad de neveras: " + neveras);
		System.out.println("Cantidad de lavadoras: " + lavadoras);
		System.out.println("Cantidad de secadoras: " + secadoras);
		System.out.println("Cantidad de televisores: " + televisores);
		System.out.println("Cantidad de vehiculo: " + vehiculos);
	}
	 // Metodo para guardar en CSV
    public void guardarEnCSV(String nombreArchivo) {
        try {
            FileWriter writer = new FileWriter(nombreArchivo + ".csv");
            writer.append("Nombre,Apellido,Genero,Ocupacion,DNI,Etnia,FechaNacimiento,Edad,IdEncuesta,Paredes,Piso,Habitaciones,"
            		+ "Banos,Neveras,Lavadoras,Secadoras,Televisores,Vehiculos\n");
            writer.append(nombre + "," + apellido + "," + genero + "," + ocupacion + "," + dni + "," + etnia + "," + 
            		fechaNacimiento + "," + edad + "," + idEncuesta + "," + paredes + "," + piso + "," + habitaciones + "," + 
            		banos + "," + neveras + "," + lavadoras + "," + secadoras + "," + televisores + "," + vehiculos + "\n");
            writer.flush();
            writer.close();
            System.out.println("Los datos se han guardado en " + nombreArchivo + ".csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

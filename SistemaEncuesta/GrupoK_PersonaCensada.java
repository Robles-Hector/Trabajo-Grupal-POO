package SistemaEncuesta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class GrupoK_PersonaCensada {
    Scanner scanner = new Scanner(System.in);
    protected String firstName, lastName, gender, occupation, id, ethnicity, birthDate;
    protected int age;

    public GrupoK_PersonaCensada() {
        // Constructor vacio
    }

    public GrupoK_PersonaCensada(String firstName, String lastName, String gender, String occupation, String id, String ethnicity, String birthDate, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.occupation = occupation;
        this.id = id;
        this.ethnicity = ethnicity;
        this.age = age;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void addPerson() {
        System.out.println("Ingrese su nombre: ");
        firstName = scanner.nextLine();
        while (!firstName.matches("[a-zA-Z ]+")) {
            System.out.println("Nombre invalido");
            System.out.println("Intentelo de nuevo.....");
            firstName = scanner.nextLine();
        }
        System.out.println("Ingrese su apellido: ");
        lastName = scanner.nextLine();
        while (!lastName.matches("[a-zA-Z ]+")) {
            System.out.println("Apellido invalido");
            System.out.println("Intentelo de nuevo.....");
            lastName = scanner.nextLine();
        }
        System.out.println("Ingrese su genero (Masculino/Femenino): ");
        gender = scanner.nextLine();
        while (!gender.equalsIgnoreCase("Masculino") && !gender.equalsIgnoreCase("Femenino")) {
            System.out.println("Genero invalido");
            System.out.println("Intentelo de nuevo.....");
            gender = scanner.nextLine();
        }
        do {
            System.out.println("Ingrese su edad (Mayor o igual a 18 y menor o igual a 70): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Edad invalida");
                System.out.println("Intentelo de nuevo.....");
                scanner.next();
            }
            age = scanner.nextInt();
            if (age < 18 || age >= 70) {
                System.out.println("La edad ingresada esta fuera del rango permitido");
                System.out.println("Intentelo de nuevo.....");
            }
            scanner.nextLine();
        } while (age < 18 || age >= 70);
        System.out.println("Ingrese su fecha de nacimiento (DD/MM/AAAA): ");
        birthDate = scanner.nextLine();
        while (!birthDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Formato de fecha invalido");
            System.out.println("Intentelo de nuevo (DD/MM/AAAA)");
            birthDate = scanner.nextLine();
        }
        System.out.println("Ingrese su ocupacion: ");
        occupation = scanner.nextLine();
        while (occupation.isEmpty()) {
            System.out.println("La ocupacion no puede estar vacia");
            occupation = scanner.nextLine();
        }
        System.out.println("Ingrese su DNI: ");
        id = scanner.nextLine();
        while (id.isEmpty() || !id.matches("\\d{1,10}")) {
            System.out.println("DNI invalido (maximo 10 digitos, no puede estar vacio)");
            id = scanner.nextLine();
        }
        System.out.println("Ingrese su etnia (Meztiso, Blanco, Afroamericano, Indigena) ");
        ethnicity = scanner.nextLine();
        while (!ethnicity.matches("(Meztiso|Blanco|Afroamericano|Indigena)")) {
            System.out.println("Etnia invalida");
            ethnicity = scanner.nextLine();
        }
    }

    public void surveyInfo() {
        System.out.println("Nombre: " + firstName);
        System.out.println("Apellido: " + lastName);
        System.out.println("Genero: " + gender);
        System.out.println("Edad: " + age);
        System.out.println("Fecha de nacimiento: " + birthDate);
        System.out.println("Ocupacion: " + occupation);
        System.out.println("DNI: " + id);
        System.out.println("Etnia: " + ethnicity);
    }

    public void saveToCSV() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("PersonasCensadas.csv", true))) {
            pw.append(firstName + "," + lastName + "," + gender + "," + age + "," + birthDate + "," + occupation + "," + id + "," + ethnicity + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readCSV() {
        String archivoCSV = "PersonasCensadas.csv";
        String linea;
        String separador = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String encabezado = br.readLine();
            System.out.println("Personas censadas ");
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                System.out.println("Nombre: " + datos[0]);
                System.out.println("Apellido: " + datos[1]);
                System.out.println("Genero: " + datos[2]);
                System.out.println("Edad: " + datos[3]);
                System.out.println("Fecha de Nacimiento: " + datos[4]);
                System.out.println("Ocupacion: " + datos[5]);
                System.out.println("DNI: " + datos[6]);
                System.out.println("Etnia: " + datos[7]);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToJSON() {
        JSONObject personaJson = new JSONObject();
        personaJson.put("nombre", firstName);
        personaJson.put("apellido", lastName);
        personaJson.put("dni", id);

        try (FileWriter file = new FileWriter("PersonaEncuestada.json")) {
            file.write(personaJson.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromJSON() {
        try (FileReader reader = new FileReader("PersonaEncuestada.json")) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder jsonText = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText.append(line);
            }

            JSONObject personaJson = (JSONObject) org.json.simple.JSONValue.parse(jsonText.toString());

            String firstName = (String) personaJson.get("nombre");
            String lastName = (String) personaJson.get("apellido");
            String id = (String) personaJson.get("dni");

            System.out.println("Nombre: " + firstName);
            System.out.println("Apellido: " + lastName);
            System.out.println("DNI: " + id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

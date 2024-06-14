package SistemaEncuesta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; 

public class GrupoK_Sistema {
    Scanner scanner = new Scanner(System.in);
    GrupoK_PersonaCensada person = new GrupoK_PersonaCensada();
    GrupoK_Encuesta survey = new GrupoK_Encuesta();
    GrupoK_Casa house;
    GrupoK_CasaArriendo rentedHouse = new GrupoK_CasaArriendo();
    GrupoK_CasaPropia ownedHouse = new GrupoK_CasaPropia();
    
    String[] header = {"UNIVERSIDAD DE LAS FUERZAS ARMADAS-ESPE", "Integrantes: Nereyda Pita - Hector Robles", "Asignatura: Programacion Orientada a Objetos"};
    
    public void menu() {
        int i = 0;
        System.out.println("--------------------------------------------");
        int option, houseInfo;
        for (String item : header) {
            System.out.println(item);
        }
        System.out.println("--------------------------------------------");
        do {
            System.out.println("----------------------------");
            System.out.println("Ingrese la opcion a realizar");
            System.out.println("1. Iniciar encuesta");
            System.out.println("2. Mostar encuesta realizada");
            System.out.println("3. Mostrar personas sensadas CSV");
            System.out.println("4. Mostrar personas sensadas JSON");
            System.out.println("5. Salir");
            System.out.println("----------------------------");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    person.addPerson();
                    System.out.println("Su casa es: ");
                    System.out.println("1: Arrendada");
                    System.out.println("2: Propia");
                    
                    do {
                        while (!scanner.hasNextInt()) {
                            System.out.println("Incorrecto, ingrese el numero (1/2)");
                            scanner.next();
                        }
                        houseInfo = scanner.nextInt();
                    } while (houseInfo != 1 && houseInfo != 2);
                    if (houseInfo == 1) {
                        house = new GrupoK_CasaArriendo();
                        i = 1;
                    } else {
                        house = new GrupoK_CasaPropia();
                        i = 2;
                    }
                    house.enterHouseInfo();
                    house.enterHouse();
                    //Encuesta
                    survey.survey();
                    person.saveToCSV();
                    person.saveToJSON();
                    break;
                case 2:
                    person.surveyInfo();
                    survey.surveyInfo();
                    house.surveyInfo();
                    break;
                case 3:
                    person.readCSV();
                    break;
                case 4:
                    person.readFromJSON();
                    break;
                case 5:
                    System.out.println("Gracias por utilizar este sistema de encuestas");
                    break;
                default:
                    System.out.println("La opcion ingresada es incorrecta");
            }
        } while (option != 5);
    }
}

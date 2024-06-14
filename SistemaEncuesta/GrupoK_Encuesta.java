package SistemaEncuesta;

import org.json.simple.JSONObject;

public class GrupoK_Encuesta extends GrupoK_PersonaCensada {
    protected String walls, floor;
    protected int rooms, bathrooms, refrigerators, washingMachines, dryers, televisions, vehicles;

    public GrupoK_Encuesta() {
        // Constructor vacio
    }

    public GrupoK_Encuesta(String firstName, String lastName, String gender, String occupation, String id, String ethnicity, String birthDate, int age, String walls, String floor, int rooms, int bathrooms, int refrigerators, int washingMachines, int dryers, int televisions, int vehicles) {
        super(firstName, lastName, gender, occupation, id, ethnicity, birthDate, age);
        this.walls = walls;
        this.floor = floor;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.refrigerators = refrigerators;
        this.washingMachines = washingMachines;
        this.dryers = dryers;
        this.televisions = televisions;
        this.vehicles = vehicles;
    }

    public void survey() {
        int wallsOption, floorOption;
        System.out.println("Ingrese el material de las paredes de la vivienda (1/5)");
        System.out.println("1. Hormigon/Bloque/Ladrillo");
        System.out.println("2. Madera");
        System.out.println("3. Cana/Estera");
        System.out.println("4. Adobe/Tapia");
        System.out.println("5. Otro");
        wallsOption = scanner.nextInt();
        switch (wallsOption) {
            case 1:
                walls = "Hormigon/Bloque/Ladrillo";
                break;
            case 2:
                walls = "Madera";
                break;
            case 3:
                walls = "Cana/Estera";
                break;
            case 4:
                walls = "Adobe/Tapia";
                break;
            default:
                walls = "Otro";
                break;
        }
        scanner.nextLine();

        System.out.println("Ingrese el material del piso de la vivienda");
        System.out.println("1. Baldosa/Vinyl/Ceramica");
        System.out.println("2. Marmol/Marmeton");
        System.out.println("3. Cemento/Ladrillo");
        System.out.println("4. Tierra");
        System.out.println("5. Otro");
        floorOption = scanner.nextInt();
        switch (floorOption) {
            case 1:
                floor = "Baldosa/Vinyl/Ceramica";
                break;
            case 2:
                floor = "Marmol/Marmeton";
                break;
            case 3:
                floor = "Cemento/Ladrillo";
                break;
            case 4:
                floor = "Tierra";
                break;
            default:
                floor = "Otro";
                break;
        }
        scanner.nextLine();

        System.out.println("Ingrese la cantidad de habitaciones");
        rooms = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la cantidad de banos");
        bathrooms = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la cantidad de neveras");
        refrigerators = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la cantidad de lavadoras");
        washingMachines = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la cantidad de secadoras");
        dryers = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la cantidad de televisores");
        televisions = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la cantidad de vehiculos");
        vehicles = scanner.nextInt();
        scanner.nextLine();
    }

    @Override
    public void surveyInfo() {
        System.out.println("Material de las paredes: " + walls);
        System.out.println("Material del piso: " + floor);
        System.out.println("Cantidad de habitaciones: " + rooms);
        System.out.println("Cantidad de banos: " + bathrooms);
        System.out.println("Cantidad de neveras: " + refrigerators);
        System.out.println("Cantidad de lavadoras: " + washingMachines);
        System.out.println("Cantidad de secadoras: " + dryers);
        System.out.println("Cantidad de televisores: " + televisions);
        System.out.println("Cantidad de vehiculos: " + vehicles);
    }
}

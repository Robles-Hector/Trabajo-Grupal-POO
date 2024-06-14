package SistemaEncuesta;

public abstract class GrupoK_Casa extends GrupoK_PersonaCensada {
    protected String address;
    protected int inhabitants;

    public GrupoK_Casa() {
        // Constructor vacio
    }

    public GrupoK_Casa(String firstName, String lastName, String gender, String occupation, String id, String ethnicity, String birthDate, int age, String address, int inhabitants) {
        super(firstName, lastName, gender, occupation, id, ethnicity, birthDate, age);
        this.address = address;
        this.inhabitants = inhabitants;
    }

    public void enterHouseInfo() {
        System.out.println("Ingrese la direccion de la casa: ");
        address = scanner.nextLine();
        while (!address.matches("[a-zA-Z ]+")) {
            System.out.println("Direccion invalida");
            System.out.println("Intentelo de nuevo...");
            address = scanner.nextLine();
        }
        
        System.out.println("Ingrese la cantidad de habitantes: ");
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Cantidad incorrecta");
                System.out.println("Ingrese un numero, que no sea 0");
                scanner.next();
            }
            inhabitants = scanner.nextInt();
        } while (inhabitants == 0);
        
        confirmInhabitants(inhabitants);
    }

    public int confirmInhabitants(int inhabitants) {
        int confirmation;
        System.out.println("Desea confirmar la cantidad de habitantes");
        System.out.println("1: Si");
        System.out.println("2: No");
        
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Incorrecto, ingrese el numero (1/2)");
                scanner.next();
            }
            confirmation = scanner.nextInt();
        } while (confirmation != 1 && confirmation != 2);
        
        if (confirmation == 2) {
            do {
                while (!scanner.hasNextInt()) {
                    System.out.println("Cantidad incorrecta");
                    System.out.println("Ingrese un numero, que no sea 0");
                    scanner.next();
                }
                inhabitants = scanner.nextInt();
            } while (inhabitants == 0);
        }
        
        return inhabitants;
    }

    public abstract void enterHouse();

    @Override
    public void surveyInfo() {
        System.out.println("Direccion: " + address);
        System.out.println("Habitantes: " + inhabitants);
    }
}

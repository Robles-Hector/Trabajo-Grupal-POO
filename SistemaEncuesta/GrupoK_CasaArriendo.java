package SistemaEncuesta;

import java.util.Scanner;

public class GrupoK_CasaArriendo extends GrupoK_Casa {
    protected int rentalTime;
    protected double rentalCost;

    public GrupoK_CasaArriendo() {
    	// Constructor vacio
    }

    public GrupoK_CasaArriendo(String firstName, String lastName, String gender, String occupation, String id, String ethnicity, String birthDate, int age, String address, int inhabitants, int rentalTime, double rentalCost) {
        super(firstName, lastName, gender, occupation, id, ethnicity, birthDate, age, address, inhabitants);
        this.rentalTime = rentalTime;
        this.rentalCost = rentalCost;
    }

    @Override
    public void enterHouse() {
        System.out.println("Ingrese el tiempo que lleva arrendando (meses): ");
        rentalTime = scanner.nextInt();
        System.out.println("Ingrese el precio del arriendo: ");
        rentalCost = scanner.nextDouble();
    }

    public double totalRentalCost() {
        return rentalTime * rentalCost;
    }

    @Override
    public void surveyInfo() {
        System.out.println("Gasto total en arriendo: " + totalRentalCost());
    }
}

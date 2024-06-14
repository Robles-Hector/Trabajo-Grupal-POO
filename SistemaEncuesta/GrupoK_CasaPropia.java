package SistemaEncuesta;

import java.util.Scanner;

public class GrupoK_CasaPropia extends GrupoK_Casa {
    Scanner scanner = new Scanner(System.in);
    private int acquisitionTime;
    private String taxCompliance;
    private String mortgage;

    public GrupoK_CasaPropia() {
        // Constructor vacío
    }

    public GrupoK_CasaPropia(String firstName, String lastName, String gender, String occupation, String id, String ethnicity, String birthDate, int age, String address, int inhabitants, int acquisitionTime, String taxCompliance, String mortgage) {
        super(firstName, lastName, gender, occupation, id, ethnicity, birthDate, age, address, inhabitants);
        this.acquisitionTime = acquisitionTime;
        this.taxCompliance = taxCompliance;
        this.mortgage = mortgage;
    }

    @Override
    public void enterHouse() {
        int cond = 3;
        System.out.println("Ingrese el tiempo en el que adquirio la propiedad (meses): ");
        acquisitionTime = scanner.nextInt();
        enterMortgageInfo(cond);
        enterTaxInfo(cond);
    }

    public String enterTaxInfo(int cond) {
        int taxInfo;
        if (cond == 3) {
            System.out.println("Ha realizado los todos los pagos del impuesto predial");
            System.out.println("1: Si");
            System.out.println("2: No");

            do {
                while (!scanner.hasNextInt()) {
                    System.out.println("Incorrecto, ingrese el numero (1/2)");
                    scanner.next();
                }
                taxInfo = scanner.nextInt();
            } while (taxInfo != 1 && taxInfo != 2);
            if (taxInfo == 1) {
                taxCompliance = "Casa al dia";
            } else {
                taxCompliance = "Casa con deuda pendiente";
            }
        }
        return taxCompliance;
    }

    public String enterMortgageInfo(int cond) {
        int mortgageInfo = 0;
        if (cond == 3) {
            System.out.println("La casa se encuentra hipotecada");
            System.out.println("1: Si");
            System.out.println("2: No");

            do {
                while (!scanner.hasNextInt()) {
                    System.out.println("Incorrecto, ingrese el numero (1/2)");
                    scanner.next();
                }
                mortgageInfo = scanner.nextInt();
            } while (mortgageInfo != 1 && mortgageInfo != 2);

            if (mortgageInfo == 1) {
                mortgage = "Casa hipotecada";
            } else {
                mortgage = "Casa no hipotecada";
            }
        }
        return mortgage;
    }

    @Override
    public void surveyInfo() {
        int cond = 4;
        System.out.println("Tipo de adquisicion: " + acquisitionTime + "(meses)");
        System.out.println("Hipoteca: " + enterMortgageInfo(cond));
        System.out.println("Impuesto predial: " + enterTaxInfo(cond));
    }
}

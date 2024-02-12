import java.util.Scanner;


public class Main {


    Scanner input = new Scanner(System.in);
    public String[][] clients = new String[100][2];
    public String[][] mecanics = new String[100][3];
    public String[][] vehicles = new String[100][3];
    public String[][] reparacions = new String[100][3];


    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }


    public void init() {
        int menuItem = 0;
        do {
            System.out.println("TALLER DE REPARACIÓ DE VEHICLES");
            System.out.println("[1] Donar d’alta nou client");
            System.out.println("[2] Donar d’alta nou mecànic");
            System.out.println("[3] Introduir nou vehicle");
            System.out.println("[4] Crear fitxa de nova reparació");
            System.out.println("[5] Modificar reparació");
            System.out.println("[6] Sortir");
            System.out.println("Sel·lecciona una opció: ");


            if (input.hasNextInt()) {
                menuItem = input.nextInt();
                switch (menuItem) {
                    case 1:
                        System.out.println("Has triat donar d’alta nou client....");
                        break;
                    case 2:
                        System.out.println("Has triat donar d’alta nou mecànic....");
                        break;
                    case 3:
                        System.out.println("Has triat introduir nou vehicle....");
                        break;
                    case 4:
                        System.out.println("Has triat crear fitxa de nova reparació....");
                        crearFitxaNovaReparacio();
                        break;
                    case 5:
                        System.out.println("Has triat modificar reparació....");
                        break;
                    case 6:
                        System.out.println("Sortint....");
                        break;
                    default:
                        System.out.println("Opció no vàlida");
                }
            } else {
                System.out.println("Opció no vàlida");
            }
            input.nextLine(); // Limpiar el buffer del scanner
            System.out.println(" ");


        } while (menuItem != 6);
    }

    private void crearFitxaNovaReparacio() {
        System.out.println("Introdueix la matrícula del vehicle:");
        String matricula = input.next();


        // Validar que exista un vehículo con la matrícula proporcionada
        boolean vehicleExists = false;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i][0] != null && vehicles[i][0].equalsIgnoreCase(matricula)) {
                vehicleExists = true;
                break;
            }
        }
        if (!vehicleExists) {
            System.out.println("No s'ha trobat cap vehicle amb aquesta matrícula.");
            return;
        }


        // Mostrar lista de mecànicos disponibles
        System.out.println("Mecànics disponibles:");
        for (int i = 0; i < mecanics.length; i++) {
            if (mecanics[i][0] != null && mecanics[i][2].equalsIgnoreCase("lliure")) {
                System.out.println(mecanics[i][0] + " - " + mecanics[i][1]);
            }
        }


        System.out.println("Introdueix el codi d'empleat del mecànic:");
        String codiMecanic = input.next();


        // Validar que el mecànic existeixi i estigui lliure
        boolean mecanicExists = false;
        for (int i = 0; i < mecanics.length; i++) {
            if (mecanics[i][0] != null && mecanics[i][0].equalsIgnoreCase(codiMecanic)
                    && mecanics[i][2].equalsIgnoreCase("lliure")) {
                mecanicExists = true;
                // Actualizar el estado del mecànic a "ocupat"
                mecanics[i][2] = "ocupat";
                break;
            }
        }
        if (!mecanicExists) {
            System.out.println("No s'ha trobat cap mecànic disponible amb aquest codi d'empleat.");
            return;
        }


        // Crear la fitxa de reparació
        for (int i = 0; i < reparacions.length; i++) {
            if (reparacions[i][0] == null) {
                reparacions[i][0] = matricula;
                reparacions[i][1] = codiMecanic;
                reparacions[i][2] = "en curs"; // L'estat inicial serà "en curs"
                System.out.println("Fitxa de reparació creada amb èxit.");
                return;
            }
        }
        System.out.println("No es poden afegir més fitxes de reparació. S'ha assolit el límit.");
    }
    private void modificarReparacio() {
        System.out.println("Introdueix la matrícula del vehicle per buscar la reparació:");
        String matricula = input.next();
        boolean found = false;


        for (int i = 0; i < reparacions.length; i++) {
            if (reparacions[i][0] != null && reparacions[i][0].equalsIgnoreCase(matricula)) {
                System.out.println("Reparació trobada:");
                System.out.println("Matrícula del vehicle: " + reparacions[i][0]);
                System.out.println("Codi d'empleat: " + reparacions[i][1]);
                System.out.println("Estat de la reparació: " + reparacions[i][2]);


                System.out.println("Introdueix el nou estat de la reparació (oberta/en curs/acabada):");
                String nouEstat = input.next();
                reparacions[i][2] = nouEstat;
                found = true;
                break;
            }
        }


        if (!found) {
            System.out.println("No s'ha trobat cap reparació amb aquesta matrícula.");
        }
    }
}


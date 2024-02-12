private void introduirNouVehicle() {
    System.out.println("Introdueix la matrícula del vehicle:");
    String matricula = input.next();


    // Validar el format de la matrícula
    if (!matricula.matches("\\d{4}[A-Za-z]{3}")) {
        System.out.println("El format de la matrícula no és vàlid. Ha de ser de 4 digits seguits de 3 lletres.");
        return;
    }


    // Validar que la matrícula del vehicle no existeixi prèviament
    for (int i = 0; i < vehicles.length; i++) {
        if (vehicles[i][0] != null && vehicles[i][0].equalsIgnoreCase(matricula)) {
            System.out.println("Aquesta matrícula ja existeix. Si us plau, introdueix una altra matrícula.");
            return;
        }
    }


    System.out.println("Introdueix el nom del model del vehicle:");
    String model = input.next();


    // Validar que el nom del model no estigui buit
    if (model.trim().isEmpty()) {
        System.out.println("El nom del model no pot ser buit.");
        return;
    }


    // Mostrar lista de DNIs de clients disponibles
    System.out.println("DNIs de clients disponibles:");
    for (int i = 0; i < clients.length; i++) {
        if (clients[i][0] != null) {
            System.out.println(clients[i][0]);
        }
    }


    System.out.println("Introdueix el DNI del propietari del vehicle:");
    String dniPropietari = input.next();


    // Validar que el DNI del propietari existeixi
    boolean dniExists = false;
    for (int i = 0; i < clients.length; i++) {
        if (clients[i][0] != null && clients[i][0].equalsIgnoreCase(dniPropietari)) {
            dniExists = true;
            break;
        }
    }
    if (!dniExists) {
        System.out.println("Aquest DNI de propietari no existeix. Si us plau, introdueix un DNI vàlid.");
        return;
    }


    // Afegir el nou vehicle
    for (int i = 0; i < vehicles.length; i++) {
        if (vehicles[i][0] == null) {
            vehicles[i][0] = matricula;
            vehicles[i][1] = model;
            vehicles[i][2] = dniPropietari;
            System.out.println("Vehicle afegit amb èxit.");
            return;
        }
    }


    System.out.println("No es poden afegir més vehicles. S'ha assolit el límit.");
}






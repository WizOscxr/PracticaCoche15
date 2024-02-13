
private void altaNouClient() {
    System.out.println("Introdueix el DNI del client:");
    String dni = input.next();


    // Validar el formato del DNI
    if (!dni.matches("\\d{8}[A-Za-z]")) {
        System.out.println("El format del DNI no és vàlid. Ha de ser de 8 digits seguits d'una lletra.");
        return;
    }


    // Validar que el DNI no existeixi prèviament
    for (int i = 0; i < clients.length; i++) {
        if (clients[i][0] != null && clients[i][0].equalsIgnoreCase(dni)) {
            System.out.println("Aquest DNI ja existeix. Si us plau, introdueix un altre.");
            return;
        }
    }


    System.out.println("Introdueix el nom del client:");
    String nom = input.next();


    // Validar que el nom del client no estigui buit
    if (nom.trim().isEmpty()) {
        System.out.println("El nom del client no pot ser buit.");
        return;
    }


    // Afegir el nou client
    for (int i = 0; i < clients.length; i++) {
        if (clients[i][0] == null) {
            clients[i][0] = dni;
            clients[i][1] = nom;
            System.out.println("Client afegit amb èxit.");
            return;
        }
    }


    System.out.println("No es poden afegir més clients. S'ha assolit el límit.");
}






private void altaNouMecanic() {
    System.out.println("Introdueix el codi de l'empleat:");
    String codiEmpleat = input.next();


    // Validar el format del codi d'empleat
    if (!codiEmpleat.matches("\\d{6}")) {
        System.out.println("El format del codi d'empleat no és vàlid. Ha de ser de 6 digits.");
        return;
    }


    // Validar que el codi d'empleat no existeixi prèviament
    for (int i = 0; i < mecanics.length; i++) {
        if (mecanics[i][0] != null && mecanics[i][0].equalsIgnoreCase(codiEmpleat)) {
            System.out.println("Aquest codi d'empleat ja existeix. Si us plau, introdueix un altre.");
            return;
        }
    }


    System.out.println("Introdueix el nom de l'empleat:");
    String nomEmpleat = input.next();


    // Validar que el nom de l'empleat no estigui buit
    if (nomEmpleat.trim().isEmpty()) {
        System.out.println("El nom de l'empleat no pot ser buit.");
        return;
    }


    // Afegir el nou mecànic
    for (int i = 0; i < mecanics.length; i++) {
        if (mecanics[i][0] == null) {
            mecanics[i][0] = codiEmpleat;
            mecanics[i][1] = nomEmpleat;
            mecanics[i][2] = "lliure"; // L'estat inicial serà "lliure"
            System.out.println("Mecànic afegit amb èxit.");
            return;
        }
    }


    System.out.println("No es poden afegir més mecànics. S'ha assolit el límit.");
}




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

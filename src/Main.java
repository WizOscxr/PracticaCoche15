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





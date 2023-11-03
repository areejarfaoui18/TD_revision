public class Main {
    public static void main(String[] args) {

        Agence agence = new Agence("Agence A");


        Voiture car1 = new Voiture(1, "BMW", 150);
        Voiture car2 = new Voiture(2, "Tesla", 200);
        Voiture car3 = new Voiture(3, "Ford", 70);


        Client client1 = new Client(101, "A", "B");
        Client client2 = new Client(102, "Z", "D");


        try {
            agence.ajoutVoiture(car1);
            agence.ajoutVoiture(car2);
            agence.ajoutVoiture(car3);
        } catch (VoitureException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            agence.loueClientVoiture(client1, car1);
            agence.loueClientVoiture(client1, car2);
            agence.loueClientVoiture(client2, car3);
        } catch (VoitureException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Cars rented by " + client1.toString() + ":");
        agence.ClientVoitureLoue.get(client1).affiche();

        try {
            agence.retourClientVoiture(client1, car1);
        } catch (VoitureException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("******************************************");
        agence.afficheLesClientsEtLeursListesVoitures();

    }
}

import java.util.*;

public class Agence {
    private String nom;
    private ListVoitures vs;
    public Map<Client, ListVoitures> ClientVoitureLoue;

    public Agence(String nom) {
        this.nom = nom;
        vs = new ListVoitures();
        ClientVoitureLoue = new HashMap<>();
    }

    public void ajoutVoiture(Voiture v) throws VoitureException {
        vs.ajoutVoiture(v);
    }

    public void suppVoiture(Voiture v) throws VoitureException {
        vs.supprimeVoiture(v);
    }

    public void loueClientVoiture(Client cl, Voiture v) throws VoitureException {
        ListVoitures voituresLouees = ClientVoitureLoue.get(cl);
        if (voituresLouees == null) {
            voituresLouees = new ListVoitures();
            ClientVoitureLoue.put(cl, voituresLouees);
        }
        voituresLouees.ajoutVoiture(v);
    }

    public void retourClientVoiture(Client cl, Voiture v) throws VoitureException {
        ListVoitures voituresLouees = ClientVoitureLoue.get(cl);
        if (voituresLouees != null) {
            voituresLouees.supprimeVoiture(v);
        }
    }

    public List<Voiture> selectVoitureSelonCritere(Critere c) {
        List<Voiture> voituresSatisfaisantes = new ArrayList<>();
        for (Voiture v : vs.getVoitures()) {
            if (c.estSatisfaitPar(v)) {
                voituresSatisfaisantes.add(v);
            }
        }
        return voituresSatisfaisantes;
    }

    public Set<Client> ensembleClientsLoueurs() {
        return ClientVoitureLoue.keySet();
    }

    public Collection<ListVoitures> collectionVoituresLouees() {
        return ClientVoitureLoue.values();
    }

    public void afficheLesClientsEtLeursListesVoitures() {
        for (Map.Entry<Client, ListVoitures> entry : ClientVoitureLoue.entrySet()) {
            System.out.println("Client: " + entry.getKey());
            System.out.println("Voitures louées: ");
            entry.getValue().affiche();
        }
    }

    public Map<Client, ListVoitures> triCode() {
        TreeMap<Client, ListVoitures> tri = new TreeMap<>(ClientVoitureLoue);
        return tri;
    }

    public Map<Client, ListVoitures> triNom() {
        TreeMap<Client, ListVoitures> tri = new TreeMap<>(new Comparator<Client>() {
            @Override
            public int compare(Client c1, Client c2) {
                return c1.getNom().compareTo(c2.getNom());
            }
        });
        tri.putAll(ClientVoitureLoue);
        return tri;
    }
}
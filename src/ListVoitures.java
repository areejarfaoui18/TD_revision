import java.util.ArrayList;
import java.util.List;
public class ListVoitures {
    private List<Voiture> voitures;

    public ListVoitures(List<Voiture> voitures) {
        this.voitures = voitures;

    }

    public ListVoitures() {
        this.voitures = new ArrayList<>();
    }
    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public void ajoutVoiture(Voiture v) throws VoitureException{
        if (!voitures.contains(v)) {
            voitures.add(v);
        } else {
            throw new VoitureException("La voiture existe déjà");
        }
    }
    public void supprimeVoiture(Voiture v) throws VoitureException{
        if (voitures.contains(v)) {
            voitures.remove(v);
        } else {
            throw new VoitureException("La voiture n existe pas");
        }
    }
    public int size(){
        return voitures.size();
    }
    public void affiche() {
        System.out.println("ListVoitures{" +
                "voitures=" + voitures +
                '}');
    }
}

package fr.bastienluben.cgj2025.Objets;

public class Consommable extends Objet{
    private int nombreUtilisation;

    public Consommable(String nomObjet, String description, int nbUtilisationMax) {
        super(nomObjet, description);

        this.nombreUtilisation = nbUtilisationMax;
    }

    public boolean utiliser(){
        if(nombreUtilisation <= 0){
            return false;
        }


        nombreUtilisation--;
        return true;
    }

}

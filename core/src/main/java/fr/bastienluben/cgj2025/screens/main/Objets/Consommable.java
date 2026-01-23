package fr.bastienluben.cgj2025.screens.main.Objets;

public class Consommable extends Objet{
    private int nombreUtilisation;

    public Consommable(String nomObjet, String description, int nbUtilisationMax) {
        super(nomObjet, description);

        this.nombreUtilisation = nbUtilisationMax;
    }

    public void utiliser(){

    }


}

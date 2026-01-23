package fr.bastienluben.cgj2025.Objets;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Consommable extends Objet{
    private int nombreUtilisation;

    public Consommable(String nomObjet, String description, Sprite sprite, int nbUtilisationMax) {
        super(nomObjet, description, sprite);

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

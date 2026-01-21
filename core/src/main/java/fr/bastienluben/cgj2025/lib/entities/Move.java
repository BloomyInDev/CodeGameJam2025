package fr.bastienluben.cgj2025.lib.entities;

import com.badlogic.gdx.math.Vector2;

public class Move {
    private Vector2 vitesse;
    private Vector2 vitesseNormal;

    public Move(Vector2 vitesseParDefaut){
        this.vitesse = vitesseParDefaut;
        this.vitesseNormal = vitesseParDefaut;
    }

    public Vector2 ajoutVitesse(Vector2 pos){
        return pos.add(this.vitesse);
    }

    public void revenirVitesseParDefaut(){
        vitesse = vitesseNormal;
    }

    private void multiplicateurVitesse(double multiplicateur){
        vitesse.x *= multiplicateur;
        vitesse.y *= multiplicateur;
    }

    public void ralentissement(double coefDeRalentissement){
        if(coefDeRalentissement < 1){
            multiplicateurVitesse(coefDeRalentissement);
        }
    }

    // Par défaut : Vitesse / 2
    public void ralentissement(){
        ralentissement(0.5);
    }

    public void acceleration(double coefDAcceleration){
        if(coefDAcceleration > 1){
            multiplicateurVitesse(coefDAcceleration);
        }
    }

    // Par défaut : Vitesse * 1.5
    public void acceleration(){
        multiplicateurVitesse(0.5);
    }
}

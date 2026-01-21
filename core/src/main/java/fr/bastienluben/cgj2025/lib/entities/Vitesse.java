package fr.bastienluben.cgj2025.lib.entities;

import com.badlogic.gdx.math.Vector2;

public enum Vitesse {
    PlateformeHorizontal(new Vector2(1, 0));


    private Vector2 vitesseDefaut;
    private Vitesse(Vector2 vitesseParDefaut){
        vitesseDefaut = vitesseParDefaut;
    }

    public Vector2 Vitesse(){
        return vitesseDefaut;
    }
}


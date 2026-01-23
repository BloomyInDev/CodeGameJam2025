package fr.bastienluben.cgj2025.Objets;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Objet {
    private final String nomObjet;
    private final String description;
    private final Sprite sprite;

    public Objet(String nomObjet, String description, Sprite sprite) {
        this.nomObjet = nomObjet;
        this.description = description;
        this.sprite = sprite;
    }

    public String getNomObjet(){
        return this.nomObjet;
    }

    public String getDescription(){
        return this.description;
    }

    public Sprite getSprite() {
        return sprite;
    }
}

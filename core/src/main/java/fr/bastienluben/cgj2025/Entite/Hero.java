package fr.bastienluben.cgj2025.Entite;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import fr.bastienluben.cgj2025.Objets.Objet;

public class Hero extends Entite {
    private ArrayList<Objet> listeObjetDuHero;
    private float taille = 50f; // Taille du carré représentant le héros

    private static Hero INSTANCE;

    private Hero(String nom, float x, float y) {
        super();
        super.nom = nom;
        super.position = new Vector2(x, y);
        super.pointDeVie = 10; // 10 points de vie par défaut
        listeObjetDuHero = new ArrayList<>();
    }

    public synchronized static Hero getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Hero("héros", Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        }
        return INSTANCE;
    }

    public void ajouterObjet(Objet objetAAJouter) {
        listeObjetDuHero.add(objetAAJouter);
    }

    @Override
    public void attaquer() {
        // TODO Auto-generated method stub
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    public float getTaille() {
        return taille;
    }

    public double getPointDeVie() {
        return pointDeVie;
    }

    public boolean estMort() {
        return pointDeVie <= 0;
    }
}

package fr.bastienluben.cgj2025.Entite;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import fr.bastienluben.cgj2025.Objets.Objet;

public class Hero extends Personnage {
    private ArrayList<Objet> listeObjetDuHero;
    private float taille = 50f; // Taille du carré représentant le héros

    private static Hero INSTANCE;

    private Hero(String nom, float x, float y) {
        super(100, 1,1);
        this.nom = nom;
        super.position = new Vector2(x, y);
        listeObjetDuHero = new ArrayList<>();
    }

    public synchronized static Hero getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Hero("héros", Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f - 200f);
        }
        return INSTANCE;
    }

    public void ajouterObjet(Objet objetAAJouter) {
        listeObjetDuHero.add(objetAAJouter);
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    public float getTaille() {
        return taille;
    }

    public double getPointDeVie() {
        return getVie().getNbStat();
    }

    public boolean estMort() {
        return getVie().getNbStat() <= 0;
    }
}

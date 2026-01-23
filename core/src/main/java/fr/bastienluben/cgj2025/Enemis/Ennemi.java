package fr.bastienluben.cgj2025.Enemis;

import com.badlogic.gdx.graphics.g2d.Sprite;
import fr.bastienluben.cgj2025.Attaques.Attaque;
import fr.bastienluben.cgj2025.Entite.Personnage;

public abstract class Ennemi extends Personnage {
    private final boolean estUnBoss;
    protected Sprite spriteSimple;
    protected Sprite spriteBoss;

    public Ennemi(String nom, double maxPV, double forceDefaut, double defenceDefaut, boolean boss) {
        super(maxPV, forceDefaut, defenceDefaut);
        estUnBoss = boss;
        this.nom = nom;
        spriteSimple = setSpriteSimple();
        spriteBoss = setSpriteBoss();
    }

    protected abstract Sprite setSpriteBoss();

    protected abstract Sprite setSpriteSimple();

    public Ennemi(String nom,double maxPV, double forceDefaut, double defenceDefaut) {
        this(nom, maxPV, forceDefaut, defenceDefaut, false);
    }

    protected void ajouterAttaque(Attaque attaqueAjouter){
        this.listesAttaques.add(attaqueAjouter);
    }

    public abstract void attaquer();

}

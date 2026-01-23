package fr.bastienluben.cgj2025.Enemis;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import fr.bastienluben.cgj2025.Attaques.Attaque;
import fr.bastienluben.cgj2025.Attaques.TirDeBalle;

public class Hugo extends Ennemi {

    public Hugo() {
        super("Hugo", 100, 1.3,1);
    }

    @Override
    protected Sprite setSpriteBoss() {
        return null;
    }

    @Override
    protected Sprite setSpriteSimple() {
        return null;
    }

    @Override
    public void attaquer() {
        Attaque tirDeBalle = new TirDeBalle();
    }

    @Override
    public Vector2 getPosition() {
        return new Vector2(0, 0);
    }
}

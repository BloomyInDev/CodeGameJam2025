package fr.bastienluben.cgj2025.Entite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class BalleNormale extends Balle {
    private Random random;

    public BalleNormale(float x, float y, float rayon, Vector2 cible, float vitesseMin, float vitesseMax) {
        super(x, y, rayon, cible, 1, "normale");
        random = new Random();
        setVitesse(random.nextFloat(vitesseMin, vitesseMax));

        int numTete = random.nextInt(7);
        setTexture(new Texture(Gdx.files.internal("enerve" + (numTete + 1) + ".png")));

        int numMouvement = random.nextInt(2);

        if (numMouvement == 0) {
            setTypeMouvement(new MouvementLineaire());
        } else {
            setTypeMouvement(new MouvementSinusoidal());
        }
    }
}

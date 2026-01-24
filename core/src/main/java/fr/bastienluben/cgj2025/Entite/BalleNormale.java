package fr.bastienluben.cgj2025.Entite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class BalleNormale extends Balle {

    private Random random;
    private static final int frameCount = 2;
    private Texture[] animation;
    private float timer;

    public BalleNormale(float x, float y, Vector2 cible, float vitesseMin, float vitesseMax) {
        super(x, y, 80f, cible, 1, "normale");
        random = new Random();
        setVitesse(random.nextFloat(vitesseMin, vitesseMax));

        int numTete = random.nextInt(6);

        animation = new Texture[]
        {
            new Texture(Gdx.files.internal("enemies/enem" + numTete + "/frame(2).png")),
            new Texture(Gdx.files.internal("enemies/enem" + numTete + "/frame(3).png"))
        };

        int numMouvement = random.nextInt(2);

        if (numMouvement == 0) {
            setTypeMouvement(new MouvementLineaire());
        } else {
            setTypeMouvement(new MouvementSinusoidal());
        }
        timer = 0f;
    }

    @Override
    public void mettreAJour(float dt)
    {
        super.mettreAJour(dt);
        timer += dt * 2;
        setTexture(animation[(int)Math.floor((timer % (double)frameCount))]);
    }
}

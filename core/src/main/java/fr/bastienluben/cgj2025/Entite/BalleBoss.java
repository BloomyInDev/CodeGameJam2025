package fr.bastienluben.cgj2025.Entite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BalleBoss extends Balle
{
    public BalleBoss(float x, float y, Vector2 cible)
    {
        super(x, y, 200f, cible, 15, "boss");
        setVitesse(100f);

        setTexture(new Texture(Gdx.files.internal("enerve.png")));

        setTypeMouvement(new MouvementLineaire());
    }
}

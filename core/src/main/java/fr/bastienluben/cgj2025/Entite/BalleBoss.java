package fr.bastienluben.cgj2025.Entite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BalleBoss extends Balle
{
    public BalleBoss(float x, float y, Vector2 cible)
    {
        super(x, y, 200f, cible, 50, "boss", true);
        setVitesse(45f);

        setTexture(new Texture(Gdx.files.internal("boss.png")));

        setTypeMouvement(new MouvementLineaire());
    }

    @Override
    public void mettreAJour(float dt)
    {
        super.mettreAJour(dt);
        this.rotation -= dt * 128;
        if (rotation < 0)
        {
            rotation = 0;
        }
    }

    @Override
    public boolean estGrosseBalle() {
        return true;
    }
}

package fr.bastienluben.cgj2025.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import fr.bastienluben.cgj2025.lib.entities.ISpriteDrawable;
import fr.bastienluben.cgj2025.lib.ui.Bounds;
import fr.bastienluben.cgj2025.lib.ui.Button;

import java.util.Random;

public class Enemy1 implements ISpriteDrawable
{
    Button but;
    Runnable run;

    public Enemy1(Runnable run, Random rnd, Texture tex, int indexInArr)
    {
        this.run = run;
        but = new Button(() -> onDie(), tex);
        but.setPosition(Bounds.Center);
        but.posOffset = new Vector2(rnd.nextInt(360) - 180, rnd.nextInt(360) - 180);
    }



    private void onDie()
    {
        run.run();
        but.hide(true);
    }

    public void draw(SpriteBatch batch)
    {
        but.draw(batch);
    }
}

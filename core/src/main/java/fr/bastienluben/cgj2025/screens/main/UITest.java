package fr.bastienluben.cgj2025.screens.main;

import fr.bastienluben.cgj2025.lib.ui.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.bastienluben.cgj2025.lib.*;

public class UITest implements IScript
{
    Image test;

    @Override
    public void onLoad(AssetManager manager)
    {
        //test = new Image(manager.getTexture("default.png"));
    }

    @Override
    public void start()
    {
        //test.setPosition(Bounds.BottomLeft);
    }

    @Override
    public void update(float delta)
    {

    }

    @Override
    public void draw(SpriteBatch batch)
    {
        //test.render(batch);
    }

    @Override
    public void draw(ShapeRenderer shape)
    {

    }
}

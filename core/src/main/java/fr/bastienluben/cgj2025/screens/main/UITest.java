package fr.bastienluben.cgj2025.screens.main;

import com.badlogic.gdx.graphics.g2d.Batch;
import fr.bastienluben.cgj2025.lib.ui.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.bastienluben.cgj2025.lib.*;

public class UITest implements IScript
{
    Image test;
    Text testtext;

    @Override
    public void onLoad(AssetManager manager)
    {
        test = new Image(256, 128, manager.getTexture("default.png"));
    }

    @Override
    public void start()
    {
        test.setMargin(8);
        test.setPosition(Bounds.TopLeft);
        testtext = new Text("hello guys");
        testtext.setPosition(Bounds.Right);
    }

    @Override
    public void update(float delta)
    {

    }

    @Override
    public void draw(SpriteBatch batch)
    {
        test.draw(batch);
        testtext.draw(batch);
    }

    @Override
    public void draw(ShapeRenderer shape)
    {

    }
}

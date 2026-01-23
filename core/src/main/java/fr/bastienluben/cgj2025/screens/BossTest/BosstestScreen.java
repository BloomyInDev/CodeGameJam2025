package fr.bastienluben.cgj2025.screens.BossTest;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.screens.AbstractScreen;

public class BosstestScreen extends AbstractScreen
{
    public BosstestScreen(Main game, AssetManager assets) {
        super(game, assets);
    }

    MembreArticulable membre;


    @Override
    public void onLoad(AssetManager assets)
    {
        membre = new MembreArticulable(new Vector2(300, 300), new Vector2(0.5f, 0.5f),
            assets.getTexture("Silksong.jpg"));
    }

    @Override
    public void start()
    {

    }

    @Override
    public void update(float dt)
    {
        membre.addRotation(180f * dt);
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.begin();
        membre.draw(batch);
        batch.end();
    }
}

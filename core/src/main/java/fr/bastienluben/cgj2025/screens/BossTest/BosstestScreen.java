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
    Vector2 positionDuMembretest;

    @Override
    public void onLoad(AssetManager assets)
    {
        positionDuMembretest = new Vector2(400, 300);
        membre = new MembreArticulable(
            positionDuMembretest,
            new Vector2[]
            {
                new Vector2(1, 0),
                new Vector2(0.5f, 0.5f),
                new Vector2(1f, 1f)
            },
            0,
            assets.getTexture("Silksong.jpg")
        );
    }

    @Override
    public void start()
    {

    }

    @Override
    public void update(float dt)
    {
        membre.addRotation(0f);
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.begin();
        membre.draw(batch);
        membre.debug(batch);
        batch.end();
    }
}

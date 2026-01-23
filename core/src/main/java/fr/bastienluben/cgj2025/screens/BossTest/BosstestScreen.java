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

    BossEntity boss;

    @Override
    public void onLoad(AssetManager assets)
    {
        boss = new BossEntity();
        boss.onLoad(assets);
    }

    @Override
    public void start()
    {

    }

    @Override
    public void update(float dt)
    {
        boss.update(dt);
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.begin();
        boss.draw(batch);
        batch.end();
    }
}

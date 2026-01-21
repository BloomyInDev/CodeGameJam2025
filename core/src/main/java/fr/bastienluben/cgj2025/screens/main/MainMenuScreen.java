package fr.bastienluben.cgj2025.screens.main;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.IScript;
import fr.bastienluben.cgj2025.lib.ui.Button;
import fr.bastienluben.cgj2025.screens.AbstractScreen;

public class MainMenuScreen extends AbstractScreen
{
    public MainMenuScreen(Main game, AssetManager assets) {
        super(game, assets);
    }

    IScript[] scripts;

    @Override
    public void onLoad(AssetManager assets)
    {
        scripts = new IScript[] {
                new UITest()
        };

        for (IScript s : scripts)
        {
            s.onLoad(assets);
        }
    }

    @Override
    public void start()
    {
        for (IScript s : scripts)
        {
            s.start();
        }
    }

    @Override
    public void update(float delta)
    {
        for (IScript s : scripts)
        {
            s.update(delta);
        }
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.begin();
        for (IScript s : scripts)
        {
            s.draw(batch);
        }
        batch.end();
    }
}

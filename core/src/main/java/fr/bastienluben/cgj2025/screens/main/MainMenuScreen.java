package fr.bastienluben.cgj2025.screens.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.IScript;
import fr.bastienluben.cgj2025.lib.ui.Button;
import fr.bastienluben.cgj2025.lib.ui.UI;
import fr.bastienluben.cgj2025.screens.AbstractScreen;

import java.util.ArrayList;
import java.util.List;

public class MainMenuScreen extends AbstractScreen
{
    public MainMenuScreen(Main game, AssetManager assets) {
        super(game, assets);
    }

    private List<IScript> scripts;

    @Override
    public void onLoad(AssetManager assets)
    {
        this.scripts = new ArrayList<>();
        this.scripts.add(new UITest());

        for (IScript s : scripts)
        {
            s.onLoad(assets);
        }
    }

    @Override
    public void start()
    {
        scripts.forEach(script -> script.start());
    }

    @Override
    public void update(float delta)
    {
        Button.updateAllButtons(
            UI.normalToGdx(
                new Vector2(Gdx.input.getX(), Gdx.input.getY())
            ),
            Gdx.input.isTouched());
        scripts.forEach(script -> script.update(delta));
    }

    @Override
    public void draw(SpriteBatch batch)
    {

        batch.begin();
        scripts.forEach(script -> script.draw(batch));
        batch.end();
    }


}

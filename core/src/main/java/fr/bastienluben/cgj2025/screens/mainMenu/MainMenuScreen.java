package fr.bastienluben.cgj2025.screens.mainMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.IScript;
import fr.bastienluben.cgj2025.lib.ui.*;
import fr.bastienluben.cgj2025.screens.AbstractScreen;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainMenuScreen extends AbstractScreen {
    private Image background;

    public MainMenuScreen(Main game, AssetManager assets) {
        super(game, assets);
    }

    private List<IScript> scripts;

    @Override
    public void onLoad(AssetManager assets)
    {
        scripts = new ArrayList<>();
        scripts.addAll(Arrays.asList(new HighScoreText(), new MenuButtons(this)));
        background = new Image(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), assets.getTexture("background.png"));

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
        background.draw(batch);
        scripts.forEach(script -> script.draw(batch));
        batch.end();
    }

}

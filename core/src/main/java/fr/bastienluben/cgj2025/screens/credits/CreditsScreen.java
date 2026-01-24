package fr.bastienluben.cgj2025.screens.credits;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.Chrono;
import fr.bastienluben.cgj2025.lib.ui.*;
import fr.bastienluben.cgj2025.screens.AbstractScreen;
import fr.bastienluben.cgj2025.screens.gameScreen.FeuxDartifice;
import fr.bastienluben.cgj2025.screens.gameScreen.FeuxDartificeManager;
import fr.bastienluben.cgj2025.screens.mainMenu.MainMenuScreen;

import java.util.Random;

public class CreditsScreen extends AbstractScreen
{
    public CreditsScreen(Main game, AssetManager assets)
    {
        super(game, assets);
    }

    Text credits;
    Button retour;
    FeuxDartificeManager feux;
    Chrono timer;
    Random rnd;
    Image morganaaaaaaa;

    @Override
    public void onLoad(AssetManager assets)
    {
        morganaaaaaaa = new Image(138, 198,
            assets.getTexture("morgana.png"));
        morganaaaaaaa.setMargin(0, 0, 32, 0);
        morganaaaaaaa.setPosition(Bounds.BottomLeft);
    }

    @Override
    public void start()
    {
        credits = new Text("Bastinou L\nClement ?\nQuentin N\nLeo M\nOmar Q\nRomain ?\nRomain T");
        credits.setPosition(Bounds.Center);
        credits.posOffset.y -= 16;
        rnd = new Random();
        retour = new Button(() ->
        {
            Button.disoseAllButtons();
            this.getGame().setScreen(new MainMenuScreen(getGame(), getGame().getAssets()));
        }, 256, 64, Color.BLUE, "retour");
        retour.setPosition(Bounds.Bottom);
        retour.setMargin(0, 128);
        feux = new FeuxDartificeManager(2f);

        timer = new Chrono(() ->
        {
            feux.createExplosionAt(new Vector2
            (
                    rnd.nextFloat(Gdx.graphics.getWidth()),
                    rnd.nextFloat(Gdx.graphics.getHeight())
            ), 1f, new Color(
                    rnd.nextFloat(1f),
                    rnd.nextFloat(1f),
                    rnd.nextFloat(1f),
                    1f
            ));
        }, 0.1f);
    }

    @Override
    public void update(float dt)
    {
        Button.updateAllButtons(
                UI.normalToGdx(
                        new Vector2(Gdx.input.getX(), Gdx.input.getY())
                ),
                Gdx.input.isTouched());

        timer.update(dt);
        feux.update(dt);
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.begin();
        feux.draw(batch);
        credits.draw(batch);
        retour.draw(batch);
        morganaaaaaaa.draw(batch);
        batch.end();
    }
}

package fr.bastienluben.cgj2025.screens.credits;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.Chrono;
import fr.bastienluben.cgj2025.lib.ui.Bounds;
import fr.bastienluben.cgj2025.lib.ui.Button;
import fr.bastienluben.cgj2025.lib.ui.Image;
import fr.bastienluben.cgj2025.lib.ui.Text;
import fr.bastienluben.cgj2025.lib.ui.UI;
import fr.bastienluben.cgj2025.screens.AbstractScreen;
import fr.bastienluben.cgj2025.screens.gameScreen.FeuxDartificeManager;
import fr.bastienluben.cgj2025.screens.mainMenu.MainMenuScreen;

public class CreditsScreen extends AbstractScreen
{
    public CreditsScreen(Main game, AssetManager assets)
    {
        super(game, assets);
    }

    Image credits;
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

        retour = new Button(() ->
        {
            Button.disoseAllButtons();
            this.getGame().setScreen(new MainMenuScreen(getGame(), getGame().getAssets()));
            game.getSoundManager().play("fondMusicalJeu");
        }, assets.getTexture("retour.png"), 252, 103);

        credits = new Image(360, 560, assets.getTexture("creditsName.png"));
        credits.setPosition(Bounds.Center);
        credits.posOffset.y += 32;
        feux = new FeuxDartificeManager(2f, assets);
    }

    @Override
    public void start()
    {
        game.getSoundManager().play("credit");
        rnd = new Random();

        retour.setPosition(Bounds.Bottom);
        retour.setMargin(0, 16);

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

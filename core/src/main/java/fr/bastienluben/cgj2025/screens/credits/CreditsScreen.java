package fr.bastienluben.cgj2025.screens.credits;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.ui.Bounds;
import fr.bastienluben.cgj2025.lib.ui.Button;
import fr.bastienluben.cgj2025.lib.ui.Text;
import fr.bastienluben.cgj2025.lib.ui.UI;
import fr.bastienluben.cgj2025.screens.AbstractScreen;
import fr.bastienluben.cgj2025.screens.mainMenu.MainMenuScreen;

public class CreditsScreen extends AbstractScreen
{
    public CreditsScreen(Main game, AssetManager assets)
    {
        super(game, assets);
    }

    Text credits;
    Button retour;

    @Override
    public void start()
    {
        credits = new Text("Bastinou\nClement\nQuentin\nLeo\nOmar\nRomain\nRomain");
        credits.setPosition(Bounds.Center);
        credits.posOffset.y -= 16;
        retour = new Button(() ->
        {
            Button.disoseAllButtons();
            this.getGame().setScreen(new MainMenuScreen(getGame(), getGame().getAssets()));
        }, 256, 64, Color.BLUE, "retour");
        retour.setPosition(Bounds.Bottom);
        retour.setMargin(0, 128);
    }

    @Override
    public void update(float dt)
    {
        Button.updateAllButtons(
                UI.normalToGdx(
                        new Vector2(Gdx.input.getX(), Gdx.input.getY())
                ),
                Gdx.input.isTouched());
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.begin();
        credits.draw(batch);
        retour.draw(batch);
        batch.end();
    }
}

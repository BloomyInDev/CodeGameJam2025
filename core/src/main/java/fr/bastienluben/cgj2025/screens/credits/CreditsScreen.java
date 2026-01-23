package fr.bastienluben.cgj2025.screens.credits;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.ui.Bounds;
import fr.bastienluben.cgj2025.lib.ui.Button;
import fr.bastienluben.cgj2025.lib.ui.Text;
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
        credits = new Text("Bastinou\nClement\nClement\nLeo\nOmar\nRomain\nRomain");
        credits.setPosition(Bounds.Top);
        credits.posOffset.y -= 16;
        retour = new Button(() ->
        {
            this.getGame().setScreen(new MainMenuScreen(this.game, this.getGame().getAssets()));
        }, 64, 24, Color.BLUE);
    }

    @Override
    public void update(float dt)
    {

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

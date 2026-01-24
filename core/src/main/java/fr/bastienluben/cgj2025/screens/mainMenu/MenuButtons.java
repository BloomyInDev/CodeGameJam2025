package fr.bastienluben.cgj2025.screens.mainMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.IScript;
import fr.bastienluben.cgj2025.lib.fonts.FontLoader;
import fr.bastienluben.cgj2025.lib.fonts.FontParameterBuilder;
import fr.bastienluben.cgj2025.lib.ui.Bounds;
import fr.bastienluben.cgj2025.lib.ui.Button;
import fr.bastienluben.cgj2025.lib.ui.Text;
import fr.bastienluben.cgj2025.screens.AbstractScreen;
import fr.bastienluben.cgj2025.screens.credits.CreditsScreen;
import fr.bastienluben.cgj2025.screens.gameScreen.GameScreen;
import fr.bastienluben.cgj2025.screens.main.MainTirDeBalleScreen;

import java.util.Arrays;

public class MenuButtons implements IScript {
    private AbstractScreen screen;

    private Text titleText;
    private Button startGameButton;
    private Button exitButton;
    private Button credits;


    public MenuButtons(AbstractScreen screen) {
        this.screen = screen;
    }

    @Override
    public void onLoad(AssetManager manager)
    {
        startGameButton = new Button(() -> {
            this.screen.getGame().setScreen(new MainTirDeBalleScreen(this.screen.getGame(), this.screen.getGame().getAssets()));
        }, manager.getTexture("jouer.png"), 252, 103);
        startGameButton.setPosition(Bounds.Bottom);
        startGameButton.setMargin(0, 300);

        exitButton = new Button(() -> {
            System.out.println("Bouton exit cliqué");
            Gdx.app.exit();
        }, manager.getTexture("quiter.png"), 252, 103);
        exitButton.setPosition(Bounds.Bottom);
        exitButton.setMargin(0, 100);

        credits = new Button(() -> {
            Button.disoseAllButtons();
            screen.getGame().setScreen(new CreditsScreen(this.screen.getGame(), screen.getGame().getAssets()));
        }, manager.getTexture("credits.png"), 252, 103);
        credits.setMargin(0, 200);
        credits.setPosition(Bounds.Bottom);
    }

    @Override
    public void start() {
        BitmapFont smallFont = FontLoader.getInstance().getFont("default", new FontParameterBuilder().setSize(20).build());
        BitmapFont titleFont = FontLoader.getInstance().getFont("default", new FontParameterBuilder().setSize(40).build());


        titleText = new Text("Le Carnaval de Makoto");
        titleText.setPosition(Bounds.Top);
        titleText.setFont(titleFont);
        titleText.setMargin(150);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(SpriteBatch batch) {
        Arrays.asList(titleText, startGameButton, exitButton, credits).forEach(e -> e.draw(batch));

    }

    @Override
    public void draw(ShapeRenderer shape) {

    }
}

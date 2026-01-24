package fr.bastienluben.cgj2025.screens.mainMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.IScript;
import fr.bastienluben.cgj2025.lib.Lerps;
import fr.bastienluben.cgj2025.lib.fonts.FontLoader;
import fr.bastienluben.cgj2025.lib.fonts.FontParameterBuilder;
import fr.bastienluben.cgj2025.lib.ui.*;
import fr.bastienluben.cgj2025.screens.AbstractScreen;
import fr.bastienluben.cgj2025.screens.credits.CreditsScreen;
import fr.bastienluben.cgj2025.screens.gameScreen.GameScreen;
import fr.bastienluben.cgj2025.screens.main.MainTirDeBalleScreen;

import java.util.Arrays;

public class MenuButtons implements IScript {
    private AbstractScreen screen;

    private Image titleText;
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
            this.screen.getGame().setScreen(new GameScreen(this.screen.getGame(), this.screen.getGame().getAssets()));
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

        titleText = new Image(1000, 200, manager.getTexture("titre.png"));
        titleText.setPosition(Bounds.Top);
    }

    @Override
    public void start() {
        BitmapFont smallFont = FontLoader.getInstance().getFont("default", new FontParameterBuilder().setSize(20).build());
        BitmapFont titleFont = FontLoader.getInstance().getFont("default", new FontParameterBuilder().setSize(40).build());

        timer = 0f;
    }

    private float timer;

    @Override
    public void update(float delta) {
        titleText.setMargin((int)Math.round(Lerps.BounceOut(-60, 60, timer, false)));
        timer += delta;
    }

    @Override
    public void draw(SpriteBatch batch) {
        titleText.setColor(Color.BLACK);
        for (Vector2 po : UI.outlinePos)
        {
            titleText.posOffset.x = po.x * 2;
            titleText.posOffset.y = po.y * 2;
            titleText.draw(batch);
        }
        batch.setColor(Color.WHITE);
        titleText.setColor(Color.WHITE);
        titleText.posOffset = new Vector2(0, 0);
        Arrays.asList(titleText, startGameButton, exitButton, credits).forEach(e -> e.draw(batch));

    }

    @Override
    public void draw(ShapeRenderer shape) {

    }
}

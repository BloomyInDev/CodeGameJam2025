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

import java.util.Arrays;

public class MenuButtons implements IScript {
    private AbstractScreen screen;

    private Text titleText;
    private Text startGameText;
    private Text exitText;
    private Button startGameButton;
    private Button exitButton;
    private Button credits;


    public MenuButtons(AbstractScreen screen) {
        this.screen = screen;
    }

    @Override
    public void onLoad(AssetManager manager) {

    }

    @Override
    public void start() {
        BitmapFont smallFont = FontLoader.getInstance().getFont("default", new FontParameterBuilder().setSize(20).build());
        BitmapFont titleFont = FontLoader.getInstance().getFont("default", new FontParameterBuilder().setSize(60).build());


        titleText = new Text("CGJ2025");
        titleText.setPosition(Bounds.Top);
        titleText.setFont(titleFont);
        titleText.setMargin(150);

        startGameButton = new Button(() -> {
            this.screen.getGame().setScreen(new GameScreen(this.screen.getGame(), this.screen.getGame().getAssets()));
        }, 400, 100, Color.BLUE);
        startGameButton.setPosition(Bounds.Bottom);
        startGameButton.setMargin(0, 300);

        startGameText = new Text("Jouer");
        startGameText.setFont(smallFont);
        startGameText.setPosition(Bounds.Bottom);
        startGameText.setMargin(0, 345);

        exitButton = new Button(() -> {
            System.out.println("Bouton exit cliqué");
            Gdx.app.exit();
        }, 400, 100, Color.BLUE);
        exitButton.setPosition(Bounds.Bottom);
        exitButton.setMargin(0, 150);
        exitText = new Text("Quitter");
        exitText.setFont(smallFont);
        exitText.setPosition(Bounds.Bottom);
        exitText.setMargin(0, 195);

        credits = new Button(() -> {
            screen.getGame().setScreen(new CreditsScreen(this.screen.getGame(), screen.getGame().getAssets()));
        }, 64, 32, Color.YELLOW, "credits");
        credits.setPosition(Bounds.Bottom);
        credits.posOffset.y -= 24;
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(SpriteBatch batch) {
        Arrays.asList(titleText, startGameButton, startGameText, exitButton, exitText, credits).forEach(e -> e.draw(batch));

    }

    @Override
    public void draw(ShapeRenderer shape) {

    }
}

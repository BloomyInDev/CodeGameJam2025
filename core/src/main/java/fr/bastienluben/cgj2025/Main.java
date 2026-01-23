package fr.bastienluben.cgj2025;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.config.ConfigLoader;
import fr.bastienluben.cgj2025.lib.fonts.FontLoader;
import fr.bastienluben.cgj2025.lib.ui.Image;
import fr.bastienluben.cgj2025.lib.ui.Text;
import fr.bastienluben.cgj2025.lib.ui.UI;
import fr.bastienluben.cgj2025.screens.AbstractScreen;
import fr.bastienluben.cgj2025.screens.BossTest.BosstestScreen;
import fr.bastienluben.cgj2025.screens.mainMenu.MainMenuScreen;
import fr.bastienluben.cgj2025.screens.main.MainTirDeBalleScreen;
import fr.bastienluben.cgj2025.screens.testScreen.TestScreen;

public class Main extends Game {
    public static final boolean DEBUG = true;

    private SpriteBatch sprite;
    private ShapeRenderer shape;
    private FontLoader fonts;
    private FitViewport viewport;
    private AssetManager assets;
    private SpriteBatch batch;

    private AbstractScreen notreScreen;

    private float timer;

    public void create() {
        sprite = new SpriteBatch();
        shape = new ShapeRenderer();
        fonts = FontLoader.getInstance();

        ConfigLoader.getInstance().parseFile();

        // use libGDX's default font

        viewport = new FitViewport(16, 9);

        batch = new SpriteBatch();

        fonts.loadFont("font.ttf", "font");
        fonts.loadFont("font.ttf", "default");

        assets = new AssetManager();
        UI.setScreenResolution(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Image.setDefaultTexture(assets.getTexture("default.png"));

        //notreScreen = new BosstestScreen(this, assets);
        notreScreen = new MainTirDeBalleScreen(this, assets);
        this.setScreen(notreScreen);
    }

    public void render() {
        ScreenUtils.clear(0.1f, 0f, 0f, 0f);  // faut clear avant bande de batard

        // ça appelle le draw du screen
        super.render(); // important ?!?!?!


        batch.begin();

        batch.end();
    }

    public void dispose() {
        sprite.dispose();
        assets.dispose();
        fonts.dispose();
        ConfigLoader.getInstance().storeFile();
    }

    public SpriteBatch getSprite() {
        return sprite;
    }

    public ShapeRenderer getShape() {
        return shape;
    }

    public FitViewport getViewport() {
        return viewport;
    }

    public AssetManager getAssets() {
        return assets;
    }
}

package fr.bastienluben.cgj2025;

import java.util.Random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.config.ConfigLoader;
import fr.bastienluben.cgj2025.lib.fonts.FontLoader;
import fr.bastienluben.cgj2025.lib.son.SoundManager;
import fr.bastienluben.cgj2025.lib.ui.Image;
import fr.bastienluben.cgj2025.lib.ui.UI;
import fr.bastienluben.cgj2025.screens.AbstractScreen;
import fr.bastienluben.cgj2025.screens.mainMenu.MainMenuScreen;

public class Main extends Game {
    public static final boolean DEBUG = true;
    public static final int BPM = 140;

    public static Vector2 camera = new Vector2(0, 0);
    private static Random rand = new Random();
    private static float shakeTimer, shakeTime;
    private static int shakeAmount;
    public static void resetCamera()
    {
        camera.x = 0;
        camera.y = 0;
    }

    public static void updateShake(float dt)
    {
        if (shakeTimer < shakeTime)
        {
            shakeTimer += dt;
            camera.x = rand.nextInt(shakeAmount) - (shakeAmount / 2);
            camera.y = rand.nextInt(shakeAmount) - (shakeAmount / 2);
        }
        else
        {
            camera.x = 0;
            camera.y = 0;
        }
    }
    public static void shake(float duree, int amount)
    {
        shakeTimer = 0f;
        shakeTime = duree;
        shakeAmount = amount;
    }

    private SpriteBatch sprite;
    private ShapeRenderer shape;
    private FontLoader fonts;
    private FitViewport viewport;
    private AssetManager assets;
    private SoundManager soundManager;

    private AbstractScreen notreScreen;

    private float timer;

    public void create() {
        sprite = new SpriteBatch();
        shape = new ShapeRenderer();
        fonts = FontLoader.getInstance();

        ConfigLoader.getInstance().parseFile();

        // use libGDX's default font

        viewport = new FitViewport(16, 9);

        fonts.loadFont("font.ttf", "font");
        fonts.loadFont("font.ttf", "default");

        soundManager = new SoundManager();
        soundManager.play("fondMusicalJeu");

        assets = new AssetManager();
        UI.setScreenResolution(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Image.setDefaultTexture(assets.getTexture("default.png"));

        this.setScreen(new MainMenuScreen(this, assets));

        //notreScreen = new BosstestScreen(this, assets);
        //notreScreen = new MainTirDeBalleScreen(this, assets);
        this.setScreen(new MainMenuScreen(this, assets));

        //notreScreen = new MainTirDeBalleScreen(this, assets);
        //this.setScreen(notreScreen);

    }

    public void render() {
        ScreenUtils.clear(0f, 0f, 0f, 0f);  // faut clear avant bande de batard

        // ça appelle le draw du screen
        super.render(); // important ?!?!?!
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

    public SoundManager getSoundManager() {
        return soundManager;
    }
}

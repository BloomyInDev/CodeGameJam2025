package fr.bastienluben.cgj2025;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.ui.Text;
import fr.bastienluben.cgj2025.lib.ui.UI;
import fr.bastienluben.cgj2025.screens.AbstractScreen;
import fr.bastienluben.cgj2025.screens.main.MainMenuScreen;

public class Main extends Game {
    private SpriteBatch sprite;
    private ShapeRenderer shape;
    private BitmapFont font;
    private FitViewport viewport;
    private AssetManager assets;

    private Texture shawImage;
    private SpriteBatch batch;

    private AbstractScreen notreScreen;

    public void create() {
        sprite = new SpriteBatch();
        shape = new ShapeRenderer();

        // use libGDX's default font
        font = new BitmapFont();
        viewport = new FitViewport(16, 9);

        shawImage = new Texture("Silksong.jpg");
        batch = new SpriteBatch();

        // font has 15pt, but we need to scale it to our viewport by ratio of viewport
        // height to screen height
        font.setUseIntegerPositions(false);
        font.getData().setScale(2);

        assets = new AssetManager();
        UI.setScreenResolution(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Text.setFont(font);

        notreScreen = new MainMenuScreen(this, assets);
        this.setScreen(notreScreen);
    }

    public void render() {


        ScreenUtils.clear(0.1f, 0f, 0f, 0f);  // faut clear avant bande de batard

        // ça appelle le draw du screen
        super.render(); // important ?!?!?!
        notreScreen.draw(shape);

        batch.begin();
        batch.draw(shawImage, 0, 0);
        // Quelqu'un peut faire en sorte que l'image soit toujours
        // en bas à gauche même quand on change la taille de la fenêtre
        batch.end();
    }

    public void dispose() {
        sprite.dispose();
        font.dispose();
    }

    public SpriteBatch getSprite() {
        return sprite;
    }

    public ShapeRenderer getShape() {
        return shape;
    }

    public BitmapFont getFont() {
        return font;
    }

    public FitViewport getViewport() {
        return viewport;
    }
}

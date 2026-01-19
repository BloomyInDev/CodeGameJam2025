package fr.bastienluben.cgj2025;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import fr.bastienluben.cgj2025.screens.MainMenuScreen;

public class Main extends Game {
    private SpriteBatch sprite;
    private ShapeRenderer shape;
    private BitmapFont font;
    private FitViewport viewport;
    private AssetManager assets;

    public void create() {
        sprite = new SpriteBatch();
        shape = new ShapeRenderer();
        // use libGDX's default font
        font = new BitmapFont();
        viewport = new FitViewport(16, 9);


        // font has 15pt, but we need to scale it to our viewport by ratio of viewport
        // height to screen height
        font.setUseIntegerPositions(false);
        font.getData().setScale(viewport.getWorldHeight() / Gdx.graphics.getHeight());

        this.setScreen(new MainMenuScreen(this));
    }

    public void render() {
        super.render(); // important!
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

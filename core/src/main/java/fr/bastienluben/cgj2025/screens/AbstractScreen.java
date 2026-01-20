package fr.bastienluben.cgj2025.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.IScript;
import fr.bastienluben.cgj2025.lib.ui.Button;

public abstract class AbstractScreen implements Screen, IScript
{
    protected Main game;


    public AbstractScreen(Main game, AssetManager assets) {
        this.game = game;
        this.onLoad(assets);
    }

    public void onLoad(AssetManager assets) {}

    /**
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void update(float delta) { }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() { }

    @Override
    public void dispose() { }

    public void draw(SpriteBatch batch) {}
    public void draw(ShapeRenderer batch) {}

    @Override
    public void resize(int width, int height) {
        game.getViewport().update(width, height, true);
    }

    @Override
    public final void show() { start(); }
    public final void render(float delta) {
        Button.updateAllButtons(new Vector2(Gdx.input.getX(), Gdx.input.getY()),
                Gdx.input.isKeyJustPressed(Input.Buttons.LEFT), Gdx.input.isKeyPressed(Input.Buttons.LEFT));
        update(delta);
        draw(game.getSprite());
        draw(game.getShape());
    }

}

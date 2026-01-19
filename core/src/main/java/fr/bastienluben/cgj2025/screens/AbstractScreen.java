package fr.bastienluben.cgj2025.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import fr.bastienluben.cgj2025.AssetManager;
import fr.bastienluben.cgj2025.Main;

public abstract class AbstractScreen implements Screen {
    protected Main game;

    public AbstractScreen(Main game, AssetManager assets) {
        this.game = game;
        this.onLoad(assets);
    }

    public abstract void onLoad(AssetManager assets);

    /**
     * @param delta The time in seconds since the last render.
     */
    public abstract void update(float delta);
    public abstract void pause();
    public abstract void resume();
    public abstract void show();
    public abstract void hide();
    public abstract void dispose();

    @Override
    public void resize(int width, int height) {
        game.getViewport().update(width, height, true);
    }
    public void render(float delta) {
        update(delta);
    }
}

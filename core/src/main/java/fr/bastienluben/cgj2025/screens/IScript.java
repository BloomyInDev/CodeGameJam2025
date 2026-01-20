package fr.bastienluben.cgj2025.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.bastienluben.cgj2025.lib.AssetManager;

public interface IScript {
    public void load(AssetManager manager);
    public void start();
    public void update(float delta);
    public void draw(SpriteBatch batch);
    public void draw(ShapeRenderer shape);
}

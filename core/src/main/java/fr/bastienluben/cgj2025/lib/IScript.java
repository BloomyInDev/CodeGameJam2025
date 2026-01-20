package fr.bastienluben.cgj2025.lib;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public interface IScript {
    public void onLoad(AssetManager manager);
    public void start();
    public void update(float delta);
    public void draw(SpriteBatch batch);
    public void draw(ShapeRenderer shape);
}

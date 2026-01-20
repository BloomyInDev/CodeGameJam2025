package fr.bastienluben.cgj2025.lib.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Entity implements ISpriteDrawable {
    private Sprite sprite;
    private Vector2 position;

    public Entity(Sprite sprite, Vector2 position) {
        this.sprite = sprite;
        this.position = position;
    }

    public Entity(Sprite sprite) {
        this(sprite, new Vector2());
    }

    public Sprite getSprite() {
        return sprite;
    }

    public Vector2 getPosition() {
        return position;
    }

    @Override
    public void draw(SpriteBatch spriteDrawer) {
        spriteDrawer.draw(sprite, position.x, position.y);
    }
}

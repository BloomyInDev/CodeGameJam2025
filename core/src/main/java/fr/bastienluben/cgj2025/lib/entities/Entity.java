package fr.bastienluben.cgj2025.lib.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Entity implements ISpriteDrawable {
    protected Sprite sprite;
    protected Vector2 position;

    public Entity(Sprite sprite, Vector2 position) {
        this.sprite = sprite;
        this.position = new Vector2(position);
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

    // Raccourcis
    public float getX(){
        return position.x;
    }

    public float getY(){
        return position.y;
    }

    public float getWidth(){
        return sprite.getWidth();
    }

    public float getHeight(){
        return sprite.getHeight();
    }

    public Rectangle getRectangle()
    {
        return new Rectangle(position.x, position.y, sprite.getWidth(), sprite.getHeight());
    }

    @Override
    public void draw(SpriteBatch spriteDrawer) {
        spriteDrawer.draw(sprite, position.x, position.y);
    }

}

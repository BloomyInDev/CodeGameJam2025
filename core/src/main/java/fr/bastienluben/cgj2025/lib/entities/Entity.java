package fr.bastienluben.cgj2025.lib.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.lib.ui.Image;

public class Entity implements ISpriteDrawable {
    protected Sprite sprite;
    protected Vector2 position;

    public Entity() {
        this.sprite = new Sprite(Image.getDefaultTexture(), 32, 32);
        this.position = new Vector2(0, 0);
    }

    public Entity(Sprite sprite) {
        this.sprite = sprite;
        this.position = new Vector2(0, 0);
    }

    public Entity(Texture texture) {
        this.sprite = new Sprite(texture, 32, 32);
        this.position = new Vector2(0, 0);
    }

    public Entity(Texture texture, Vector2 taille) {
        this.sprite = new Sprite(texture, (int)taille.x, (int)taille.y);
        this.position = new Vector2(0, 0);
    }


    public Sprite getSprite() {
        return sprite;
    }

    public Vector2 getPosition() {
        return position;
    }
    public Vector2 getTaille() {
        return new Vector2(sprite.getWidth(), sprite.getHeight());
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

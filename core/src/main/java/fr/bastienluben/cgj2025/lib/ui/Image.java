package fr.bastienluben.cgj2025.lib.ui;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Image extends UI
{
    private static Texture defaultTexture;
    public static void setDefaultTexture(Texture value)
    {
        defaultTexture = value;
    }

    private Texture img;
    private Color color;

    public void setColor(Color value)
    {
        color = value;
    }

    public Color getColor()
    {
        return color;
    }

    public Image(Texture tex)
    {
        super(tex.getWidth(), tex.getHeight());
        this.img = tex;
        this.color = Color.WHITE;
    }

    public Image(Texture tex, Color color)
    {
        super(tex.getWidth(), tex.getHeight());
        this.img = tex;
        this.color = color;
    }

    public Image(int width, int height, Color color)
    {
        super(width, height);
        this.img = defaultTexture;
        this.color = color;
    }

    public Image(int width, int height, Texture tex)
    {
        super(width, height);
        this.img = tex;
        this.color = Color.WHITE;
    }

    public Image(int width, int height, Texture tex, Color color)
    {
        super(width, height);
        this.img = tex;
        this.color = color;
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        if (visible)
        {
            batch.setColor(color);
            batch.draw(img, rect.x + posOffset.x, rect.y + posOffset.y, rect.width, rect.height);

            super.draw(batch);
        }
    }
}

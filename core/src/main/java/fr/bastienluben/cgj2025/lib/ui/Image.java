package tonpere.tamerecestjava;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Image extends UI
{
    private Texture img;
    public Color color;

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

    public void render(SpriteBatch batch)
    {
        if (visible)
        {
            batch.setColor(color);
            batch.draw(img, rect.x, rect.y, rect.width, rect.height);
        }
    }
}

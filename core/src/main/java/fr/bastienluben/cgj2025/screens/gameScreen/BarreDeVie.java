package fr.bastienluben.cgj2025.screens.gameScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.entities.ISpriteDrawable;

public class BarreDeVie implements ISpriteDrawable
{
    private final int maxValue;
    private int value;
    private final Texture outline;
    private final TextureRegion inner;
    private final Rectangle valueRectangle;

    public BarreDeVie(int maxValue, AssetManager assets)
    {
        this.maxValue = maxValue;
        this.value = maxValue;
        this.outline = assets.getTexture("healthOutline.png");
        valueRectangle = new Rectangle(outline.getHeight(), 10,
            outline.getWidth() - outline.getHeight(), outline.getHeight() - 10);
        inner = new TextureRegion(assets.getTexture("healthValue.png"));
    }

    public void takeDamage(int value)
    {
        this.value += value;
        if (value > maxValue)
        {
            value = maxValue;
        }

        inner.setRegion(0, 0,
            ((value * inner.getRegionWidth()) / maxValue),
            inner.getRegionHeight());
    }

    public boolean isAlive()
    {
        return value > 0;
    }

    public void draw(SpriteBatch batch)
    {
        batch.draw(outline, 8, 8);
        batch.draw(inner,
            valueRectangle.x,
            valueRectangle.y,
            valueRectangle.getWidth(),
            valueRectangle.getHeight()
        );
    }
}

package fr.bastienluben.cgj2025.screens.gameScreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.entities.ISpriteDrawable;

public class BarreDeVie implements ISpriteDrawable
{
    private final double maxValue;
    private double value;
    private final Texture outline;
    private final TextureRegion inner;
    private final Rectangle valueRectangle;
    private float timer;
    private Color warningColor;

    public BarreDeVie(double maxValue, AssetManager assets)
    {
        this.maxValue = maxValue;
        this.value = maxValue;

        this.outline = assets.getTexture("healthOutline.png");
        valueRectangle = new Rectangle(outline.getHeight() - 1, 36,
            outline.getWidth() - outline.getHeight(), outline.getHeight() - 58);
        inner = new TextureRegion(assets.getTexture("healthValue.png"));
        timer = 0f;
        warningColor = new Color(1f, 1f, 1f, 1f);
    }

    public void takeDamage(double v)
    {
        this.value += MathUtils.clamp(v, 0, maxValue);
        updateRegionSize();
    }

    public void setLife(double v) {
        this.value = MathUtils.clamp(v, 0, maxValue);
        updateRegionSize();
    }

    public void update(float dt)
    {
        timer += dt;
        if ((value * 100f) / maxValue < 25)
        {
            warningColor.g = (float)(Math.sin(timer * 20f) + 1f) / 2f;
            warningColor.b = (float)(Math.sin(timer * 20f) + 1f) / 2f;
        }
        else
        {
            warningColor.g = 1f;
            warningColor.b = 1f;
        }
    }

    private void updateRegionSize() {
        inner.setRegion(0, 0,
            (int) ((value * inner.getTexture().getWidth()) / maxValue),
            inner.getRegionHeight());
    }

    public boolean isAlive()
    {
        return value > 0;
    }

    public void draw(SpriteBatch batch)
    {
        batch.setColor(Color.WHITE);
        batch.draw(outline, 8, 8);
        batch.setColor(warningColor);
        batch.draw(inner,
            valueRectangle.x,
            valueRectangle.y,
            (float) ((valueRectangle.getWidth() * value) / maxValue),
            valueRectangle.getHeight()
        );
        batch.setColor(Color.WHITE);
    }
}

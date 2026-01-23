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

    public BarreDeVie(double maxValue, AssetManager assets)
    {
        this.maxValue = maxValue;
        this.value = maxValue;

        this.outline = assets.getTexture("healthOutline.png");
        valueRectangle = new Rectangle(outline.getHeight() - 1, 36,
            outline.getWidth() - outline.getHeight(), outline.getHeight() - 58);
        inner = new TextureRegion(assets.getTexture("healthValue.png"));
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
        batch.draw(inner,
            valueRectangle.x,
            valueRectangle.y,
            (float) ((valueRectangle.getWidth() * value) / maxValue),
            valueRectangle.getHeight()
        );
    }
}

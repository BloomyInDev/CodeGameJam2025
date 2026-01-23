package fr.bastienluben.cgj2025.lib.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.lib.fonts.FontLoader;

public class Text extends UI
{
    private BitmapFont font;
    private GlyphLayout layout;
    private String text;
    public Color color;

    public Text(String text)
    {
        super();
        font = FontLoader.getInstance().getFont("default");
        layout = new GlyphLayout(font, text);
        rect = new Rectangle(0, 0, layout.width, layout.height);
        this.text = text;
        this.color = Color.WHITE;
    }

    public Text(String text, Color color)
    {
        this(text);
        this.color = color;
    }

    /*
    * change le texte
    * */
    public void changeText(String value)
    {
        text = value;
        layout.setText(font, text);
        rect = new Rectangle(0, 0, layout.width, layout.height);
        updatePosition();
    }

    /*
     * change le texte
     * */
    public void setText(String value) {changeText(value);}
    /*
     * change le texte
     * */
    public void updateText(String value) {changeText(value);}

    @Override
    public void draw(SpriteBatch batch)
    {
        if (visible)
        {
            batch.setColor(color);
            font.setColor(Color.BLACK);
            for (Vector2 p : UI.outlinePos)
            {
                font.draw(batch, text, rect.x + p.x + posOffset.x, rect.y + layout.height + p.y + posOffset.y);
            }
            font.setColor(color);
            font.draw(batch, text, rect.x + posOffset.x, rect.y + layout.height + posOffset.y);

            super.draw(batch);
        }
    }

    public void setFont(BitmapFont font)
    {
        this.font = font;
        layout = new GlyphLayout(this.font, text);
        rect = new Rectangle(0, 0, layout.width, layout.height);
        updatePosition();
    }
}

package fr.bastienluben.cgj2025.screens.BossTest;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.lib.entities.Element;
import fr.bastienluben.cgj2025.lib.entities.ISpriteDrawable;
import fr.bastienluben.cgj2025.lib.ui.Image;



public class MembreArticulable extends Element implements ISpriteDrawable
{
    private static void applyRotation(
        Vector2 origin,
        Vector2 output,
        float degree)
    {
        float dx = output.x - origin.x;
        float dy = output.y - origin.y;
        float dist = Vector2.dst(output.x, output.y, origin.x, origin.y);

        float rot;
        if (dx == 0)
        {
            rot = dy > 0 ? 90f : -90f;
        }
        else
        {
            rot = (float)Math.atan2(dy, dx);

            if (dx > 0)
            {
                rot += 180f;
            }
        }

        output.x = (float)(Math.cos(Math.toRadians(rot + degree)) * dist);
        output.y = (float)(Math.sin(Math.toRadians(rot + degree)) * dist);
    }

    private final Vector2[] connectionsData;
    private final Vector2 origin;
    private final Vector2[] pointsToScreen;

    private float rotation;

    /// @param connectionsData - la position des articulations
    /// avec des porté de 0f - 1f.
    public MembreArticulable(
        Vector2 positionRef,
        Vector2[] connectionsData,
        int indexDeLaConnectoinQuiSertDePointDeRotation,
        Texture tex
        )
    {
        super(tex);
        this.position = positionRef;
        this.connectionsData = connectionsData;
        this.pointsToScreen = new Vector2[connectionsData.length];

        for (byte i = 0; i < connectionsData.length; i++)
        {
            pointsToScreen[i] = new Vector2();
        }

        this.origin = new Vector2(
            connectionsData[indexDeLaConnectoinQuiSertDePointDeRotation].x * tex.getWidth(),
            connectionsData[indexDeLaConnectoinQuiSertDePointDeRotation].y * tex.getHeight()
        );
        setRotation(0f);
    }

    public void setRotation(float degree)
    {
        this.rotation = degree;
        for (byte i = 0; i < connectionsData.length; i++)
        {
            pointsToScreen[i].x = position.x + (connectionsData[i].x * sprite.getWidth());
            pointsToScreen[i].y = position.y + (connectionsData[i].y * sprite.getHeight());

            applyRotation(origin, pointsToScreen[i], rotation);
        }
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.setColor(Color.WHITE);
        batch.draw(
            getSprite(),
            position.x,
            position.y,
            origin.x,
            origin.y,
            getWidth(),
            getHeight(),
            getWidth(),
            getHeight(),
            rotation);
    }

    public void debug(SpriteBatch batch)
    {
        batch.setColor(Color.RED);
        for (Vector2 p : pointsToScreen)
        {
            batch.draw(Image.getDefaultTexture(),
                p.x, p.y,
                2, 2);
        }
    }
}

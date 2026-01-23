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
            rot = (float)Math.toDegrees(Math.atan2(dy, dx));

            if (dx > 0)
            {
                rot += 180f;
            }
        }

        float finalRot = (float)Math.toRadians(rot + degree);

        output.x = origin.x + (float)(Math.cos(finalRot) * dist);
        output.y = origin.y + (float)(Math.sin(finalRot) * dist);
    }

    private final Vector2[] connectionsData;
    private final Vector2 origin;
    private final Vector2[] pointsToScreen;
    private final Vector2 justeunPoolpourorigin;
    private final byte indexOrigin;

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
        indexOrigin = (byte)indexDeLaConnectoinQuiSertDePointDeRotation;
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
        justeunPoolpourorigin = new Vector2(0f, 0f);
        setRotation(0f);
    }

    public Vector2 getConnection(int id)
    {
        return pointsToScreen[id];
    }

    public void setRotation(float degree)
    {
        this.rotation = degree;
        update();
    }

    public void addRotation(float degree)
    {
        this.rotation += degree;
        update();
    }

    private void update()
    {
        justeunPoolpourorigin.x = position.x + origin.x;
        justeunPoolpourorigin.y = position.y + origin.y;

        for (byte i = 0; i < connectionsData.length; i++)
        {
            pointsToScreen[i].x = position.x + (connectionsData[i].x * sprite.getWidth());
            pointsToScreen[i].y = position.y + (connectionsData[i].y * sprite.getHeight());

            if (i != indexOrigin) // pas besoin de rotate le point de rotation
            {
                applyRotation(justeunPoolpourorigin, pointsToScreen[i], rotation);
            }
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
            1f,
            1f,
            rotation);
    }

    public void debug(SpriteBatch batch)
    {
        batch.setColor(Color.BLUE);
        for (Vector2 p : pointsToScreen)
        {
            batch.draw(Image.getDefaultTexture(),
                p.x - 2, p.y - 2,
                4, 4);
        }
    }
}

package fr.bastienluben.cgj2025.screens.BossTest;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.lib.entities.Element;


public class MembreArticulable extends Element
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

    public MembreArticulable(Vector2 positionRef, Vector2 origin, Texture tex)
    {
        super(tex);
        connectorPoints = new ArrayList<Vector2>();

    }

    @Override
    public void draw(SpriteBatch batch)
    {
        //batch.draw();
    }
}

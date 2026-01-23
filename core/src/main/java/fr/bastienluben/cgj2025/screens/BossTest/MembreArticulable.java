package fr.bastienluben.cgj2025.screens.BossTest;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.lib.entities.Entity;

import java.util.ArrayList;

public class MembreArticulable extends Entity
{
    private ArrayList<Vector2> connectorPoints;

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

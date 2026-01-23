package fr.bastienluben.cgj2025.screens.BossTest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.IScript;

public class BossEntity implements IScript
{
    MembreArticulable tete, corp, brasG, brasD, jambeG, jambeD;
    MembreArticulable[] membres;
    Vector2 position;

    public BossEntity()
    {
        position = new Vector2(500, 500);
    }

    @Override
    public void onLoad(AssetManager assets)
    {
        corp = new MembreArticulable(
            null,
            position,
            new Vector2[]
                {
                    new Vector2(0.5f, 1f),
                    new Vector2(0f, 0.9f),
                    new Vector2(1f, 0.9f),
                    new Vector2(0.2f, 0f),
                    new Vector2(0.8f, 0f)
                },
            0,
            assets.getTexture("middle.png")
        );

        tete = new MembreArticulable(
            corp,
            corp.getConnection(0),
            new Vector2[]
                {
                    new Vector2(0.5f, 0f)
                },
            0,
            assets.getTexture("head.png"),
            0
        );

        brasG = new MembreArticulable(
            corp,
            corp.getConnection(1),
            new Vector2[]
                {
                    new Vector2(0.5f, 0f),
                    new Vector2(0.5f, 1f)
                },
            0,
            assets.getTexture("stick.png"),
            180
        );

        brasD = new MembreArticulable(
            corp,
            corp.getConnection(2),
            new Vector2[]
                {
                    new Vector2(0.5f, 0f),
                    new Vector2(0.5f, 1f)
                },
            0,
            assets.getTexture("stick.png")
        );

        jambeG = new MembreArticulable(
            corp,
            corp.getConnection(3),
            new Vector2[]
                {
                    new Vector2(0.5f, 0f),
                    new Vector2(0.5f, 1f)
                },
            0,
            assets.getTexture("stick.png"),
            -90f
        );

        jambeD = new MembreArticulable(
            corp,
            corp.getConnection(4),
            new Vector2[]
                {
                    new Vector2(0.5f, 0f),
                    new Vector2(0.5f, 1f)
                },
            0,
            assets.getTexture("stick.png"),
            -90f
        );

        membres = new MembreArticulable[]
        {
            corp, tete, brasD, brasG, jambeG, jambeD
        };
    }

    @Override
    public void start()
    {

    }

    @Override
    public void update(float delta)
    {
        corp.setRotation(0);
        tete.setRotation(12);
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        for (MembreArticulable ma : membres)
        {
            ma.draw(batch);
        }
        corp.debug(batch);
    }

    @Override
    public void draw(ShapeRenderer shape)
    {

    }
}

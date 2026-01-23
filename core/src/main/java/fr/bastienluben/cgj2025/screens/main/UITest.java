package fr.bastienluben.cgj2025.screens.main;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.sun.tools.javac.util.List;
import fr.bastienluben.cgj2025.enemies.Enemy1;
import fr.bastienluben.cgj2025.lib.config.ConfigLoader;
import fr.bastienluben.cgj2025.lib.ui.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.bastienluben.cgj2025.lib.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Random;

public class UITest implements IScript
{
    Text score;
    int scoreValue;

    private int countValue;
    private float timer;
    Chrono enemyLoop;
    Texture enemyTexture;
    Random rnd;
    ArrayList<Enemy1> queue;

    @Override
    public void onLoad(AssetManager manager)
    {
        enemyTexture = manager.getTexture("head.png");
    }

    @Override
    public void start()
    {
        scoreValue = 0;
        score = new Text("score : 0");
        score.setPosition(Bounds.Top);
        enemyLoop = new Chrono(() -> onEnemySpawn(), 1f);
        rnd = new Random();
        queue = new ArrayList<>();
    }

    @Override
    public void update(float delta)
    {
        Vector2 mouse = new Vector2(Gdx.input.getX(), Gdx.input.getY());
        Vector2 o = UI.normalToGdx(mouse);
        Button.updateAllButtons(o, Gdx.input.isTouched());

        enemyLoop.update(delta);
    }

    private void onEnemySpawn()
    {
        queue.add(new Enemy1(() -> onEnemyDeleted(), rnd, enemyTexture));
    }

    private void onEnemyDeleted()
    {
        scoreValue++;
        score.setText("score : " + scoreValue);
        queue.remove(0);
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        score.draw(batch);
        for(Enemy1 en : queue)
        {
            en.draw(batch);
        }
    }

    @Override
    public void draw(ShapeRenderer shape)
    {

    }
}

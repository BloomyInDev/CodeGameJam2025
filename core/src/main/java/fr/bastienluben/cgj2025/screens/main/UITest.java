package fr.bastienluben.cgj2025.screens.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.sun.tools.javac.util.List;
import fr.bastienluben.cgj2025.lib.config.ConfigLoader;
import fr.bastienluben.cgj2025.lib.ui.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.bastienluben.cgj2025.lib.*;

import java.util.Arrays;

public class UITest implements IScript
{
    private Image test, shaw;
    private Text test_text, count;
    private Button button;

    private int countValue;

    @Override
    public void onLoad(AssetManager manager)
    {
        test = new Image(256, 128, manager.getTexture("default.png"));
        shaw = new Image(manager.getTexture("Silksong.jpg"));
    }

    @Override
    public void start()
    {
        countValue = ConfigLoader.getInstance().getConfig().getScore();

        test.setMargin(8);
        test.setPosition(Bounds.TopLeft);

        test_text = new Text("hello guys");
        test_text.setPosition(Bounds.Right);

        button = new Button(() -> {
            countValue++;
            count.setText("count: " + countValue);
            ConfigLoader.getInstance().getConfig().setScore(countValue);
        }, 300, 200, Color.BLUE, "push me !");
        button.setPosition(Bounds.Center);

        count = new Text(String.format("count: %d", countValue));
        count.setPosition(Bounds.Top);
    }

    @Override
    public void update(float delta)
    {
        Vector2 mouse = new Vector2(Gdx.input.getX(), Gdx.input.getY());
        Vector2 o = UI.normalToGdx(mouse);
        test_text.setText("normale: " + mouse.toString()
        + "\ngdx: " + o.toString());
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        Arrays.asList(test, shaw, test_text, button, count).forEach(e -> e.draw(batch));
    }

    @Override
    public void draw(ShapeRenderer shape)
    {

    }
}

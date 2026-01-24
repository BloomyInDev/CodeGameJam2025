package fr.bastienluben.cgj2025.screens.mainMenu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.IScript;
import fr.bastienluben.cgj2025.lib.config.ConfigLoader;
import fr.bastienluben.cgj2025.lib.fonts.FontLoader;
import fr.bastienluben.cgj2025.lib.fonts.FontParameterBuilder;
import fr.bastienluben.cgj2025.lib.ui.*;

import java.util.Arrays;

public class HighScoreText implements IScript {
    private int highScore;
    private Text highScoreText, testText;
    private float timer;

    @Override
    public void onLoad(AssetManager manager) {

    }

    @Override
    public void start() {
        BitmapFont smallFont = FontLoader.getInstance().getFont("default", new FontParameterBuilder().setSize(10).build());

        highScore = ConfigLoader.getInstance().getConfig().getBestScore();

        highScoreText = new Text("High Score : " + highScore);
        highScoreText.setFont(smallFont);
        highScoreText.setMargin(10);

        // Position AFTER all properties are set
        highScoreText.setPosition(Bounds.TopRight);

        testText = new Text("bottom text");
        testText.setMargin(10);
        // Position AFTER all properties are set
        testText.setPosition(Bounds.Bottom);
        testText.setFont(smallFont);
    }

    @Override
    public void update(float delta) {
        System.out.println(timer);
        timer += delta;
        if (timer > .5) {
            timer = 0;
            switch (testText.getPosition()) {
                case TopRight: testText.setPosition(Bounds.Top); break;
                case Top: testText.setPosition(Bounds.TopLeft); break;
                case TopLeft: testText.setPosition(Bounds.Left); break;
                case Left: testText.setPosition(Bounds.BottomLeft); break;
                case BottomLeft: testText.setPosition(Bounds.Bottom); break;
                case Bottom: testText.setPosition(Bounds.BottomRight); break;
                case BottomRight: testText.setPosition(Bounds.Right); break;
                case Right: testText.setPosition(Bounds.TopRight); break;
            }
        };
    }

    @Override
    public void draw(SpriteBatch batch) {
        Arrays.asList(highScoreText, testText).forEach(e -> e.draw(batch));
    }

    @Override
    public void draw(ShapeRenderer shape) {

    }
}

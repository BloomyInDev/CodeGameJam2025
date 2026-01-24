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
    private Text highScoreText;

    @Override
    public void onLoad(AssetManager manager) {

    }

    @Override
    public void start() {
        BitmapFont smallFont = FontLoader.getInstance().getFont("default",
            new FontParameterBuilder().setSize(10).build());

        highScore = ConfigLoader.getInstance().getConfig().getBestScore();

        highScoreText = new Text("High Score : " + highScore);
        highScoreText.setFont(smallFont);
        highScoreText.setMargin(10);

        // Position AFTER all properties are set
        highScoreText.setPosition(Bounds.TopRight);
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void draw(SpriteBatch batch) {
        Arrays.asList(highScoreText).forEach(e -> e.draw(batch));
    }

    @Override
    public void draw(ShapeRenderer shape) {

    }
}

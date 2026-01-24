package fr.bastienluben.cgj2025.screens.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.Entite.Hero;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.Chrono;
import fr.bastienluben.cgj2025.lib.config.ConfigLoader;
import fr.bastienluben.cgj2025.lib.fonts.FontLoader;
import fr.bastienluben.cgj2025.lib.fonts.FontParameterBuilder;
import fr.bastienluben.cgj2025.lib.son.SoundManager;
import fr.bastienluben.cgj2025.lib.ui.Bounds;
import fr.bastienluben.cgj2025.lib.ui.Image;
import fr.bastienluben.cgj2025.lib.ui.Text;
import fr.bastienluben.cgj2025.screens.AbstractGameScreen;
import fr.bastienluben.cgj2025.screens.AbstractScreen;
import fr.bastienluben.cgj2025.screens.mainMenu.MainMenuScreen;

import java.util.List;

public class GameScreen extends AbstractScreen {
    Chrono test;
    BarreDeVieHero vie;
    FeuxDartificeManager feux;
    private int level = 1;
    private FabriqueGame fabrique;
    private AbstractGameScreen currentScreen;
    private Image background;
    private Text levelText;
    private boolean enTransition = false;
    private boolean aDejaRegenLeNiveau = false;
    private float timerTransition = 0f;
    private boolean gameOver = false;
    private Text textDeFin;

    private List<Music> annonceEtape = null;
    private boolean aLuAnnonceEtape = false;

    public GameScreen(Main game, AssetManager assets) {
        super(game, assets);
        fabrique = new FabriqueGame(game, assets);
    }

    @Override
    public void onLoad(AssetManager assets) {
        vie = new BarreDeVieHero(assets);
        background = new Image(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), assets.getTexture("background.png"));
    }

    @Override
    public void start() {
        Hero.getInstance(true);
        currentScreen = fabrique.fabriqueNiveauAleatoire(level, true);
        levelText = new Text("");
        levelText.setPosition(Bounds.Top);
        levelText.setMargin(10);

        textDeFin = new Text("Vous etes mort");
        textDeFin.setPosition(Bounds.Center);
        textDeFin.setFont(FontLoader.getInstance().getFont("default", new FontParameterBuilder().setColor(Color.RED).setSize(65).build()));
    }

    @Override
    public void update(float delta) {
        levelText.setText(String.format("Niveau %d", level));
        if (gameOver) {
            if (Gdx.input.justTouched()) {
                int niveauxReussis = level - 1;
                int ancienMeilleurScore = ConfigLoader.getInstance().getConfig().getBestScore();
                if (niveauxReussis > ancienMeilleurScore) {
                    ConfigLoader.getInstance().getConfig().setBestScore(niveauxReussis);
                }
                this.game.setScreen(new MainMenuScreen(this.game, this.game.getAssets()));
            }
        } else if (!enTransition) {
            vie.update(delta);
            if (currentScreen != null) {
                currentScreen.update(delta);
                if (currentScreen.estTerminee()) {
                    level++;
                    enTransition = true;
                    currentScreen.update(delta);
                    start();
                }
                if (Hero.getInstance().getPointDeVie() <= 0) {
                    currentScreen = null;
                    gameOver = true;
                }
            }
        } else {
            if (annonceEtape == null) {
                if (aLuAnnonceEtape) {
                    game.getSoundManager().augmenterLeVolumeTemporairement();
                    enTransition = false;
                    start();
                } else {
                    SoundManager sm = this.game.getSoundManager();
                    annonceEtape = sm.chargerSonsPourNiveau(level);
                    sm.reduireLeVolumeTemporairement();
                    aLuAnnonceEtape = sm.ecouterSonSuivantQuandLaMusiqueEstTerminee(annonceEtape);
                    if (annonceEtape == null) {
                        aLuAnnonceEtape = true;
                    }
                }
            }
            timerTransition += delta;

        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.begin();
        background.draw(batch);
        if (currentScreen != null) {
            currentScreen.draw(batch);
        }
        levelText.draw(batch);
        if (gameOver) {
            textDeFin.draw(batch);
        } else {
            vie.draw(batch);
        }
        batch.end();
    }

    @Override
    public void draw(ShapeRenderer batch) {
        if (currentScreen != null) {
            currentScreen.draw(batch);
        }
    }
}

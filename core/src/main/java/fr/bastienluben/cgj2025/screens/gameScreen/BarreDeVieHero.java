package fr.bastienluben.cgj2025.screens.gameScreen;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.bastienluben.cgj2025.Entite.Hero;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.IScript;

public class BarreDeVieHero extends BarreDeVie implements IScript {
    private Hero hero;

    public BarreDeVieHero(AssetManager assets) {
        super(Hero.getInstance().getVieMax(), assets);
        hero = Hero.getInstance();
    }

    @Override
    public void onLoad(AssetManager manager) {

    }

    @Override
    public void start() {

    }

    @Override
    public void update(float delta) {
        this.setLife(this.hero.getPointDeVie());
    }

    @Override
    public void draw(ShapeRenderer shape) {
    }
}

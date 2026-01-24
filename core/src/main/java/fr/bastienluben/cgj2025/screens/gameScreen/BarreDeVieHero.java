package fr.bastienluben.cgj2025.screens.gameScreen;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.bastienluben.cgj2025.Entite.Hero;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.IScript;

public class BarreDeVieHero extends BarreDeVie implements IScript {
    public BarreDeVieHero(AssetManager assets) {
        super(Hero.getInstance().getVieMax(), assets);

    }

    @Override
    public void onLoad(AssetManager manager) {

    }

    @Override
    public void start() {

    }

    @Override
    public void update(float delta)
    {
        super.update(delta);
        this.setLife(Hero.getInstance().getPointDeVie());
    }

    @Override
    public void draw(ShapeRenderer shape) {
    }
}

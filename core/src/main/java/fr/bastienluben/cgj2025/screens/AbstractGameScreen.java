package fr.bastienluben.cgj2025.screens;

import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.AssetManager;

public abstract class AbstractGameScreen extends AbstractScreen {

    public AbstractGameScreen(Main game, AssetManager assets) {
        super(game, assets);
    }

    public abstract boolean estTerminee();
}

package fr.bastienluben.cgj2025.screens.gameScreen;

import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.CustomCallable;
import fr.bastienluben.cgj2025.screens.AbstractScreen;
import fr.bastienluben.cgj2025.screens.main.MainKamikazeScreen;
import fr.bastienluben.cgj2025.screens.main.MainTirDeBalleScreen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class FabriqueGame {
    private final Main game;
    private final AssetManager assets;

    public FabriqueGame(Main game, AssetManager assets) {
        this.game = game;
        this.assets = assets;
    }

    public AbstractScreen fabriqueNiveauKamikaze(int niveau) {
        System.out.println("Fabrication Kamikaze");
        int nbBombes = (int) ((Math.floor((double) niveau / 4) + 1) * 2) + 6;
        float probabiliteApparitionBombe = (0.008163265306122f * niveau) + 0.01f;
        System.out.printf("Nombre de bombes : %d\n", nbBombes);
        return new MainKamikazeScreen(game, assets, nbBombes, probabiliteApparitionBombe);
    }

    public AbstractScreen fabriqueNiveauTirDeBalle(int niveau) {
        System.out.println("Fabrication TirDeBalle");
        float vitesseMin = 200f + niveau * 10f;
        float vitesseMax = 500f + niveau * 50f;
        System.out.printf("Vitesses : %f - %f\n", vitesseMin, vitesseMax);
        return new MainTirDeBalleScreen(game, assets, vitesseMin, vitesseMax);
    }

    public AbstractScreen fabriqueNiveauAleatoire(int niveau, boolean appelerStart) {
        List<CustomCallable<AbstractScreen>> fabriques = Arrays.asList(
            () -> fabriqueNiveauKamikaze(niveau),
            () -> fabriqueNiveauTirDeBalle(niveau)
        );
        AbstractScreen screen = fabriques.get(new Random().nextInt(fabriques.size())).call();
        if (appelerStart) screen.start();
        return screen;
    }
}

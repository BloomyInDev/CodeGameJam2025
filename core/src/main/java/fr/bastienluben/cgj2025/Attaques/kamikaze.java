package fr.bastienluben.cgj2025.Attaques;

import fr.bastienluben.cgj2025.Entite.Entite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.bastienluben.cgj2025.Entite.Hero;

public class kamikaze extends Attaque {
    private List<Bombe> bombes;
    private Random random;

    public kamikaze(Entite attaquant) {
        super(1, "kamikaze", 10, 10, attaquant);
        bombes = new ArrayList<>();
        random = new Random();
    }

    @Override
    public void attaque(Entite adversaire) {
        // Créer une nouvelle bombe à une position aléatoire
        int x = random.nextInt(800);
        int y = random.nextInt(600);
        Bombe bombe = new Bombe(100,x,y);
        bombes.add(bombe);

        System.out.println("Bombe posée à la position (" + x + ", " + y + ")");

        for (Bombe b : bombes) {
            b.update();
            if (!b.isEstClique() && b.getTimer() <= 0) {
                getAttaquant().attaquer(adversaire,this);
                bombes.remove(b);
                //gameOver();
            }
        }
    }
    
    public void clickBombe(int x, int y) {
        for (Bombe b : bombes) {
            if (x >= b.getX() && x <= b.getX() + 50 && y >= b.getY() && y <= b.getY() + 50) {
                b.click();
            }
        }
    }

    public void gameOver() {
        // La partie est perdue
        System.out.println("Game Over!");
        System.exit(0);
    }
}

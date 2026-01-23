package fr.bastienluben.cgj2025.Attaques;

import fr.bastienluben.cgj2025.Entite.Bombe;
import fr.bastienluben.cgj2025.Entite.Entite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.bastienluben.cgj2025.Entite.Hero;
import fr.bastienluben.cgj2025.Entite.Personnage;

public class kamikaze extends Attaque {
    private List<Bombe> bombes;
    private Random random;
    private int nbBombes;

    public kamikaze(Entite attaquant, int nbBombes) {
        super(1, "kamikaze", 10, 10);
        bombes = new ArrayList<>();
        random = new Random();
        this.nbBombes = nbBombes;
    }

    public kamikaze(Entite attaquant) {
        this(attaquant, 8);
    }

    @Override
    public void attaquer(Personnage attaquant, Personnage adversaire) {
        // Créer une nouvelle bombe à une position aléatoire
        Random rand = new Random();
        for (int i = 0; i < rand.nextInt(nbBombes) + 1; i++)  {
            int x = random.nextInt(800);
            int y = random.nextInt(600);
            Bombe bombe = new Bombe(60,x,y);
            bombes.add(bombe);

            System.out.println("Bombe posée à la position (" + x + ", " + y + ")");
        }

        for (Bombe b : bombes) {
            b.update();
            if (!b.isEstClique() && b.getTimer() <= 0) {
                super.attaquer(attaquant, adversaire);
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

package fr.bastienluben.cgj2025.Attaques;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.bastienluben.cgj2025.Entite.Bombe;
import fr.bastienluben.cgj2025.Entite.Entite;
import fr.bastienluben.cgj2025.Entite.Hero;
import fr.bastienluben.cgj2025.Entite.Personnage;

public class Kamikaze extends Attaque {
    private List<Bombe> bombes;
    private Random random;
    private int nbBombes;
    private int nbBombesCrees;
    private boolean limiteDeNbBombesSpawnees;
    private int limiteNbBombesSpawnees;

    public Kamikaze(Entite attaquant, int nbBombes) {
        super(10, "kamikaze", 10, 10);
        this.limiteDeNbBombesSpawnees = false;
        bombes = new ArrayList<>();
        random = new Random();
        this.nbBombes = nbBombes;
    }

    public Kamikaze(Entite attaquant, int nbBombes, int limiteNbBombesSpawnees) {
        this(attaquant, nbBombes);
        this.limiteNbBombesSpawnees = limiteNbBombesSpawnees;
        this.limiteDeNbBombesSpawnees = true;
    }

    public Kamikaze(Entite attaquant) {
        this(attaquant, 8);
    }


    @Override
    public void attaquer(Personnage attaquant, Personnage adversaire) {
        // Créer une nouvelle bombe à une position aléatoire
        Random rand = new Random();
        for (int i = 0; i < rand.nextInt(nbBombes) + 1; i++)  {
            int x = random.nextInt(800);
            int y = random.nextInt(600);
            if (limiteDeNbBombesSpawnees && nbBombesCrees <= limiteNbBombesSpawnees) {
                Bombe bombe = new Bombe(100 * attaquant.getDefense().getNbStat(),x,y,0);
                nbBombesCrees++;
                bombes.add(bombe);
            }

            System.out.println("Bombe posée à la position (" + x + ", " + y + ")");
        }

        for (Bombe b : bombes) {
            b.update(0);
            if (!b.isEstClique() && b.getTimer() <= 0) {
                //super.attaquer(attaquant, adversaire);
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

    public boolean estTerminee() {
        return limiteDeNbBombesSpawnees && nbBombesCrees >= limiteNbBombesSpawnees;
    }
}

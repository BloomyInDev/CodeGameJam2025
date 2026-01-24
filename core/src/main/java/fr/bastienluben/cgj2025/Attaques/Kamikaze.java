package fr.bastienluben.cgj2025.Attaques;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import fr.bastienluben.cgj2025.Entite.Bombe;
import fr.bastienluben.cgj2025.Entite.Entite;
import fr.bastienluben.cgj2025.Entite.Personnage;

public class Kamikaze extends Attaque {
    private List<Bombe> bombes;
    private Random random;
    /**
     * Le nombre de bombes a spawner en meme temps max
     */
    private int nbBombes;
    /**
     * Le nombre de bombes crées
     */
    private int nbBombesCrees;
    private boolean aLimiteDeNbBombesSpawnees;
    private int limiteDeBombesSpawnees;
    private float screenWidth;
    private float screenHeight;

    public Kamikaze(Entite attaquant, int nbBombes) {
        super(10, "kamikaze", 10, 10);
        this.aLimiteDeNbBombesSpawnees = false;
        bombes = new ArrayList<>();
        random = new Random();
        this.nbBombes = nbBombes;
        this.screenWidth = Gdx.graphics.getWidth();
        this.screenHeight = Gdx.graphics.getHeight();
    }

    public Kamikaze(Entite attaquant, int nbBombes, int limiteNbBombesSpawnees) {
        this(attaquant, nbBombes);
        this.limiteDeBombesSpawnees = limiteNbBombesSpawnees;
        this.aLimiteDeNbBombesSpawnees = true;
    }

    public Kamikaze(Entite attaquant) {
        this(attaquant, 8);
    }

    /**
     * Vérifie si on peut encore spawner des bombes
     */
    public boolean peutSpawnerBombe() {
        return !aLimiteDeNbBombesSpawnees || nbBombesCrees < limiteDeBombesSpawnees;
    }

    /**
     * Crée une bombe à une position aléatoire et l'ajoute à la liste
     * @param timer le timer de la bombe
     * @return la bombe créée, ou null si la limite est atteinte
     */
    public Bombe spawnBombe(float timer) {
        if (!peutSpawnerBombe()) {
            return null;
        }

        int x = MathUtils.random(0, (int) screenWidth - 50);
        int y = MathUtils.random(150, (int) screenHeight - 50);
        Bombe bombe = new Bombe(timer, x, y, 0);
        bombes.add(bombe);
        nbBombesCrees++;
        System.out.printf("Il y a %d / %d bombes crées\n", nbBombesCrees, limiteDeBombesSpawnees);
        return bombe;
    }

    /**
     * Retire une bombe de la liste
     */
    public void retirerBombe(Bombe bombe) {
        bombes.remove(bombe);
    }

    public List<Bombe> getBombes() {
        return bombes;
    }


    @Override
    public void attaquer(Personnage attaquant, Personnage adversaire) {
        // Créer des bombes aléatoires
        Random rand = new Random();
        int nbBombesACreer = rand.nextInt(nbBombes) + 1;
        for (int i = 0; i < nbBombesACreer; i++) {
            float timer = (float) (100 * attaquant.getDefense().getNbStat());
            Bombe bombe = spawnBombe(timer);
            if (bombe != null) {
                System.out.println("Bombe posée à la position (" + bombe.getX() + ", " + bombe.getY() + ")");
            }
        }

        for (Bombe b : bombes) {
            b.update(0);
            if (!b.isEstClique() && b.getTimer() <= 0) {
                //super.attaquer(attaquant, adversaire);
                soundManager.effectuerEffetSonore("extinction");
                bombes.remove(b);

                //gameOver();
            }
        }
    }

    public void clickBombe(int x, int y) {
        for (Bombe b : bombes) {
            if (x >= b.getX() && x <= b.getX() + 50 && y >= b.getY() && y <= b.getY() + 50) {
                soundManager.effectuerEffetSonore("extinction");
                b.click();
            }
        }
    }

    public void gameOver() {
        // La partie est perdue
        System.out.println("Game Over!");
        System.exit(0);
    }


    public int getLimiteDeBombesSpawnees() {
        return limiteDeBombesSpawnees;
    }

    public int getNbBombesCrees() {
        if (!aLimiteDeNbBombesSpawnees) return -1;
        return nbBombesCrees;
    }


    public boolean estTerminee() {
        return aLimiteDeNbBombesSpawnees && nbBombesCrees >= limiteDeBombesSpawnees && this.bombes.isEmpty();
    }
}

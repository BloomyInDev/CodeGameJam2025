package fr.bastienluben.cgj2025.Attaques;

import fr.bastienluben.cgj2025.Entite.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Gère l'attaque par tir de balles.
 * Cette classe gère la logique des balles (création, mouvement, collision)
 * mais NE gère PAS l'affichage.
 */
public class TirDeBalle extends Attaque {
    private List<Balle> balles;
    private Random random;
    private float tempsDepuisDerniereBalle;
    private static float delaiEntreBalles = 1f;
    private Hero cible;
    private int compteurBallesMortes;
    private boolean stopProduction;
    private boolean estTermine;
    private float vitesseMin;
    private float vitesseMax;

    /**
     * Constructeur pour la gestion des projectiles avec cible.
     * Les balles elles-mêmes sont les attaquants.
     */
    public TirDeBalle(float vitesseMin, float vitesseMax) {
        super(10, "Tir de balle", 10, 4);
        this.balles = new ArrayList<>();
        this.random = new Random();
        this.tempsDepuisDerniereBalle = 0f;
        this.cible = Hero.getInstance();
        this.vitesseMin = vitesseMin;
        this.vitesseMax = vitesseMax;
    }

    // === Méthode héritée de Attaque ===

    @Override
    public void attaquer(Personnage attaquant, Personnage adversaire) {
        if (entiteEstTouche(attaquant, adversaire)) {
            double degats = this.getNbDegatAuHit();

            super.attaquer(attaquant, adversaire);

            // débogage
            System.out.printf("%s a touché %s avec %s et inflige %f points de dégâts ! Vie restante : %f\n", attaquant.getNom(), adversaire.getNom(), this.getNom(), degats, adversaire.getVie().getNbStat());
            adversaire.getVie().retirerStat(this.getNbDegatAuHit());
        } else {
            // debogage utilisateur rate
            System.out.println(
                attaquant.getNom() + " a raté " +
                            adversaire.getNom() + " avec " + this.getNom() + ".");
        }
    }

    /**
     * Effectue une attaque avec une balle spécifique comme attaquant.
     */
    public void attaqueAvecBalle(Balle balle, Hero adversaire) {
        // débogage
        System.out.printf("%s a touché %s avec %s et inflige %f points de dégâts ! Vie restante : %f\n", balle.getNom(), adversaire.getNom(), this.getNom(), this.getNbDegatAuHit(), adversaire.getVie().getNbStat());
        adversaire.getVie().retirerStat(this.getNbDegatAuHit() * (balle.estGrosseBalle() ? 2 : 1));
    }

    private boolean entiteEstTouche(Personnage attaquant, Personnage adversaire) {
        // Positions de l'attaquant et de l'adversaire
        Vector2 positionAttaquant = attaquant.getPosition();
        Vector2 positionAdversaire = adversaire.getPosition();

        // Calcule la distance entre les deux entités
        float distance = positionAttaquant.dst(positionAdversaire);

        // Précisions
        float distanceMaxPourToucher = 500f;
        float precision = 1.5f;

        float probabiliteTouche = Math.max(0f, 1f - (distance / (distanceMaxPourToucher / precision)));

        return Math.random() < probabiliteTouche;
    }

    // === Gestion des projectiles ===

    /**
     * Met à jour toutes les balles : spawn, mouvement et collision.
     *
     * @param delta temps écoulé depuis la dernière frame
     */
    public void mettreAJour(float delta) {
        if (balles.isEmpty() && stopProduction) {
            estTermine = true;
        }
        tempsDepuisDerniereBalle += delta;

        // Créer une nouvelle balle si le délai est écoulé
        if (tempsDepuisDerniereBalle >= TirDeBalle.delaiEntreBalles) {
            if (compteurBallesMortes < 20) {
                ajouterBalle();
            } else if (!stopProduction) {
                ajouterBalleBoss();
                stopProduction = true;
            }
            tempsDepuisDerniereBalle = 0f;
        }

        // Mettre à jour la position des balles
        for (Balle balle : balles) {
            balle.mettreAJour(delta);
        }

        // Vérifier les collisions avec le héros
        // Chaque balle est l'attaquant
        for (Balle balle : balles) {
            if (!balle.estDetruite() && balle.toucheHero(cible.getPosition(), cible.getTaille())) {
                // La balle attaque le héros
                attaqueAvecBalle(balle, cible);
                balle.detruire();
            }
        }

        // Retirer les balles détruites ou sorties de l'écran

        for (Balle balle : balles) {
            if (balle.estDetruite()) {
                compteurBallesMortes++;
            }
        }

        balles.removeIf(balle -> balle.estDetruite() || estHorsEcran(balle));
    }

    private void ajouterBalleBoss() {
        float x = random.nextFloat() * Gdx.graphics.getWidth();
        float y = Gdx.graphics.getHeight();
        balles.add(new BalleBoss(x, y, cible.getPosition()));
    }

    /**
     * Ajoute une balle en haut de l'écran à une position X aléatoire.
     */
    private void ajouterBalle() {
        float x = random.nextFloat() * Gdx.graphics.getWidth();
        float y = Gdx.graphics.getHeight() + 40;
        balles.add(new BalleNormale(x, y, cible.getPosition(), vitesseMin, vitesseMax));
    }

    /**
     * Vérifie si une balle est sortie de l'écran.
     */
    private boolean estHorsEcran(Balle balle) {
        Vector2 pos = balle.getPosition();
        float marge = 50f;
        return pos.x < -marge || pos.x > Gdx.graphics.getWidth() + marge ||
                pos.y < -marge || pos.y > Gdx.graphics.getHeight() + marge;
    }

    /**
     * Détruit une balle si elle est touchée par un clic.
     *
     * @param clickX position X du clic
     * @param clickY position Y du clic
     * @return true si une balle a été détruite
     */
    public boolean gererClic(float clickX, float clickY) {
        for (Balle balle : balles) {
            if (balle.estTouche(clickX, clickY)) {
                balle.retirerPV();
                if (balle.getPointDeVie() <= 0) {
                    balle.detruire();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Retourne la liste des balles pour l'affichage.
     *
     * @return liste des balles actives
     */
    public List<Balle> getBalles() {
        return balles;
    }

    public void setDelaiEntreBalles(float delai) {
        delaiEntreBalles = delai;
    }

    public boolean isEstTermine() {
        return estTermine;
    }

    public float getVitesseMin() {
        return vitesseMin;
    }

    public void setVitesseMin(float vitesseMin) {
        this.vitesseMin = vitesseMin;
    }

    public float getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(float vitesseMax) {
        this.vitesseMax = vitesseMax;
    }
}

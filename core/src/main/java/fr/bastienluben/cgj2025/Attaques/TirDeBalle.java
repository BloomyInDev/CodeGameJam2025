package fr.bastienluben.cgj2025.Attaques;

import fr.bastienluben.cgj2025.Entite.Entite;

import com.badlogic.gdx.math.Vector2;

public class TirDeBalle extends Attaque {

    public TirDeBalle(double nbDegat, Entite attaquant) {
        super(nbDegat, "Tir de balle", 10, 10, attaquant);
    }

    @Override
    public void attaque(Entite adversaire) {
        if (entiteEstTouche(adversaire)) {
            double degats = this.getNbDegatAuHit();

            this.getAttaquant().attaquer(adversaire, this);

            // débogage
            System.out.println(
                this.getAttaquant().getNom() + " a touché " +
                adversaire.getNom() + " avec " + this.getNom() +
                " et inflige " + degats + " points de dégâts !"
            );
        } else {
            // debogage utilisateur rate
            System.out.println(
                this.getAttaquant().getNom() + " a raté " +
                adversaire.getNom() + " avec " + this.getNom() + "."
            );
        }
    }

    private boolean entiteEstTouche(Entite adversaire) {
        // Positions de l'attaquant et de l'adversaire
        Vector2 positionAttaquant = this.getAttaquant().getPosition();
        Vector2 positionAdversaire = adversaire.getPosition();

        // Calcule la distance entre les deux entités
        float distance = positionAttaquant.dst(positionAdversaire);

        // Précisions
        float distanceMaxPourToucher = 500f;
        float precision = 1.5f;

        float probabiliteTouche = Math.max(0f, 1f - (distance / (distanceMaxPourToucher / precision)));

        return Math.random() < probabiliteTouche;
    }
}


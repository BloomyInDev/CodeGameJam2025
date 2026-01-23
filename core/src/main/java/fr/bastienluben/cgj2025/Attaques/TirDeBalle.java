package fr.bastienluben.cgj2025.Attaques;

import fr.bastienluben.cgj2025.Entite.Entite;

public class TirDeBalle extends Attaque {

    public TirDeBalle(double nbDegat, Entite attaquant) {
        super(nbDegat, "Tir de balle", 10, 10, attaquant);
    }

    public void attaquer(Entite adversaire) {
        if (entiteEstTouche(adversaire)) {
            super.getAttaquant().attaquer(adversaire, this);
        }
    }

    private boolean entiteEstTouche(Entite adversaire) {
        throw new RuntimeException();
    }

    @Override
    protected void attaque() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attaque'");
    }
    
}

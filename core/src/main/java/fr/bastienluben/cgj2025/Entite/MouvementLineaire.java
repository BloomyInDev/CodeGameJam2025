package fr.bastienluben.cgj2025.Entite;

import com.badlogic.gdx.math.Vector2;

public class MouvementLineaire implements TypeMouvementBalle {
    @Override
    public void mettreAJour(Balle balle, float delta) {
        // Se déplacer dans la direction de la cible
        Vector2 position = balle.getPosition();
        Vector2 direction = balle.getDirection();
        float vitesse = balle.getVitesse();

        balle.setPosition(
            new Vector2(
                position.x + direction.x * vitesse * delta,
                position.y + direction.y * vitesse * delta
            )
        );

        balle.getHitbox().setPosition(position.x, position.y);
    }
}

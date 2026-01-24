package fr.bastienluben.cgj2025.Entite;

import com.badlogic.gdx.math.Vector2;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MouvementSinusoidal implements TypeMouvementBalle {

    private Map<Balle, Float> tempsEcoule;
    private float amplitude; // Amplitude de l'oscillation en pixels
    private float frequence; // Fréquence de l'oscillation
    private Random random;

    public MouvementSinusoidal() {
        tempsEcoule = new HashMap<>();
        random = new Random();
        amplitude = random.nextFloat(100f, 800f);
        frequence = random.nextFloat(5f, 20f);
    }

    @Override
    public void mettreAJour(Balle balle, float delta) {
        // Récupérer ou initialiser le temps écoulé pour cette balle
        float temps = tempsEcoule.getOrDefault(balle, 0f);
        temps += delta;
        tempsEcoule.put(balle, temps);

        // Récupérer la position, direction et vitesse
        Vector2 position = balle.getPosition();
        Vector2 direction = balle.getDirection();
        float vitesse = balle.getVitesse();

        // Calculer le vecteur perpendiculaire à la direction
        Vector2 perpendiculaire = new Vector2(-direction.y, direction.x);

        // Calculer le décalage sinusoïdal
        float decalageSinusoidal = (float) Math.sin(temps * frequence) * amplitude * delta;

        // Calculer la nouvelle position: mouvement linéaire + oscillation
        // perpendiculaire
        float nouvelleX = position.x + direction.x * vitesse * delta + perpendiculaire.x * decalageSinusoidal;
        float nouvelleY = position.y + direction.y * vitesse * delta + perpendiculaire.y * decalageSinusoidal;

        balle.setPosition(new Vector2(nouvelleX, nouvelleY));
        balle.getHitbox().setPosition(nouvelleX, nouvelleY);
    }
}

package fr.bastienluben.cgj2025.Entite;

import fr.bastienluben.cgj2025.lib.son.SoundManager;

public class Bombe {
    private double timer;
    private boolean estClique;
    private float tempsApparitionBombe;
    private float delaiApparitionBombe;
    private int x;
    private int y;

    private SoundManager soundManager;

    public Bombe(double timer, int x, int y, float delaiApparitionBombe) {
        System.out.println("Une nouvelle bombe est apparue !");
        this.timer = timer;
        this.estClique = false;
        this.x = x;
        this.y = y;
        this.delaiApparitionBombe = (float) (delaiApparitionBombe == 0.0 ?  0.1 : delaiApparitionBombe);
        soundManager = new SoundManager();
        soundManager.effectuerEffetSonore("clock");
    }

    public void update(float delta) {
        tempsApparitionBombe += delta;
        if (timer > 0) {
            if (tempsApparitionBombe > delaiApparitionBombe) {
                tempsApparitionBombe = 0;
                timer--;
            }

        }
    }

    public void click() {
        estClique = true;
    }

    public boolean isEstClique() {
        return estClique;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getTimer() {
        return timer;
    }

    public int getTimerTexte() {
        return (int) timer;
    }
}

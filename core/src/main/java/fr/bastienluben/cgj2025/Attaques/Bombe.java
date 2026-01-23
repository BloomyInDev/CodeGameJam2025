package fr.bastienluben.cgj2025.Attaques;

public class Bombe {
    private double timer;
    private boolean estClique;
    private int x;
    private int y;

    public Bombe(double timer, int x, int y) {
        this.timer = timer;
        this.estClique = false;
        this.x = x;
        this.y = y;

    }

    public void update() {
        if (timer > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timer--;
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
}

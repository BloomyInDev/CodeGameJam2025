package fr.bastienluben.cgj2025.lib.movement;
import com.badlogic.gdx.math.Vector2;

public class Coordonnee {
    private Vector2 position;

    public Coordonnee(){
        this.position = new Vector2();
    }

    public Coordonnee(float x, float y){
        this.position = new Vector2(x,y);
    }

    public Coordonnee(Vector2 vector){
        this.position = new Vector2(vector);
    }

    public Coordonnee(Coordonnee pos){
        this.position = pos.getPosition();
    }


    // Changer les coordonées

    public void moveAt(Vector2 pos){
        this.position = pos;
    }

    public void moveAt(Coordonnee pos){
        moveAt(pos.getPosition());
    }

    public void moveAt(float x, float y){
        moveAt(new Vector2(x,y));
    }

    // Ajouter aux coordonées actuel

    // Renvoie la coordonée X
    public float addX(float x){
        this.position.x += x;
        return this.position.x;
    }

    // Renvoie la coordonée Y
    public float addY(float y){
        this.position.y += y;
        return this.position.y;
    }

    // Renvoie la position mise à jour
    public Vector2 addXY(float x, float y){
        return this.position.add(x,y);
    }

    public Vector2 addVitesse(Vector2 vit){
        return this.position.add(vit);
    }


    // Getters

    public Vector2 getPosition(){
        return this.position;
    }

    public float getX(){
        return this.position.x;
    }

    public float getY(){
        return this.position.y;
    }
}

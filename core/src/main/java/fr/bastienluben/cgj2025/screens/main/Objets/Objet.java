package fr.bastienluben.cgj2025.screens.main.Objets;

public abstract class Objet {
    private String nomObjet;
    private String description;

    

    public Objet(String nomObjet, String description) {
        this.nomObjet = nomObjet;
        this.description = description;
    }
}

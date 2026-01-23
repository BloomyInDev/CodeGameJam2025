package fr.bastienluben.cgj2025.screens.main.Objets;

public abstract class Objet {
    private final String nomObjet;
    private final String description;

    public Objet(String nomObjet, String description) {
        this.nomObjet = nomObjet;
        this.description = description;
    }

    public String getNomObjet(){
        return this.nomObjet;
    }

    public String getDescription(){
        return this.description;
    }
}

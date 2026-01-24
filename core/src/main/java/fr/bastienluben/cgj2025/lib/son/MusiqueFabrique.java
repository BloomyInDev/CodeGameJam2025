package fr.bastienluben.cgj2025.lib.son;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MusiqueFabrique {
    private static MusiqueFabrique INSTANCE;

    private MusiqueFabrique () {

    }

    public static synchronized MusiqueFabrique getInstance() {
        if (INSTANCE == null) {
            return new MusiqueFabrique();
        } else {
            return INSTANCE;
        }
    }

    public HashMap<String,Music> creerMusique() {
        HashMap<String,Music> listeMusique = new HashMap<>();
        listeMusique.put("fondMusicalJeu", Gdx.audio.newMusic(Gdx.files.internal("musique/musiqueDeFond.mp3")));
        listeMusique.put("credit",Gdx.audio.newMusic(Gdx.files.internal("musique/10eCodeGameJam.mp3")));
        return listeMusique;
    }
}

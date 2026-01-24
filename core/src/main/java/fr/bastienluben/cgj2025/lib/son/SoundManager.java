package fr.bastienluben.cgj2025.lib.son;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.audio.Music;

public class SoundManager {

    private HashMap<String, Music> listeMusiqueJeu = MusiqueFabrique.getInstance().creerMusique();
    private Music musiqueEnCours = null;

    public List<String> obtenirListCheminDAccesPourNiveau(int numero) {
        List<String> chemin = new ArrayList<>();

        if (numero == 1000) {
            chemin.add("audionombres/1000.mp3");
            return chemin;
        }

        if (numero == 100) {
            chemin.add("audionombres/100.mp3");
            return chemin;
        }

        if (numero < 100) {
            int dizaines = (numero / 10) * 10;
            int unites = numero % 10;

            if (dizaines >= 20 && dizaines < 100) {
                chemin.add("audionombres/" + dizaines + ".mp3");
            }

            if (unites != 0) {
                chemin.add("audionombres/" + unites + ".mp3");
            }

            if (dizaines == 0 && unites != 0) {
                chemin.add("audionombres/" + unites + ".mp3");
            }

            if (dizaines < 20 && dizaines != 0) {
                chemin.add("audionombres/" + dizaines + ".mp3");
            }

            return chemin;
        }

        if (numero >= 100) {
            int centaines = (numero / 100) * 100;
            int reste = numero % 100;

            chemin.add("audionombres/" + centaines + ".mp3");

            if (reste != 0) {
                chemin.addAll(obtenirListCheminDAccesPourNiveau(reste));
            }

            return chemin;
        }

        return chemin;
    }

    public void play(String nomMusique) {
        musiqueEnCours = listeMusiqueJeu.get(nomMusique);
        musiqueEnCours.setLooping(true);
        musiqueEnCours.play();
        mettreEnPauseAutreMusiqueQue(musiqueEnCours);
    }

    private void mettreEnPauseAutreMusiqueQue(Music musiqueCourante) {
        for (Map.Entry<String, Music> entry : listeMusiqueJeu.entrySet()) {
            Music musique = entry.getValue();
            if (musique != musiqueCourante && musique.isPlaying()) {
                musique.pause();
            }
        }
    }

    public SoundManager getSoundManager() {
        return this;
    }
}
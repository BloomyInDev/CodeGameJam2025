package fr.bastienluben.cgj2025.lib.son;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

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
                if (dizaines == 90) {
                    chemin.add("audionombres/80.mp3");
                    chemin.add("audionombres/10.mp3");
                } else if (dizaines == 70) {
                    chemin.add("audionombres/60.mp3");
                    chemin.add("audionombres/10.mp3");
                } else {
                    chemin.add("audionombres/" + dizaines + ".mp3");
                }
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

    public void reduireLeVolumeTemporairement() {
        musiqueEnCours.setVolume(musiqueEnCours.getVolume()/2);
    }

    public void augmenterLeVolumeTemporairement() {
        musiqueEnCours.setVolume(musiqueEnCours.getVolume()*2);
    }

    private void mettreEnPauseAutreMusiqueQue(Music musiqueCourante) {
        for (Map.Entry<String, Music> entry : listeMusiqueJeu.entrySet()) {
            Music musique = entry.getValue();
            if (musique != musiqueCourante && musique.isPlaying()) {
                musique.pause();
            }
        }
    }

    public List<Music> chargerSonsPourNiveau(int numero) {
        List<Music> sounds = new ArrayList<>();
        for (String chemin : obtenirListCheminDAccesPourNiveau(numero)) {
            sounds.add(Gdx.audio.newMusic(Gdx.files.internal(chemin)));
        }
        return sounds;
    }

    public boolean ecouterSonSuivantQuandLaMusiqueEstTerminee(List<Music> musics) {
        if (musics.isEmpty()) return true;
        else if (musics.get(0).isPlaying()) {
            return false;
        } else {
            musics.get(0).dispose();
            musics.remove(0);
            if (musics.isEmpty()) return true;
            Music music = musics.get(0);
            System.out.printf("Ecoute du son : %s%n", music.toString());
            music.play();
            music.setVolume(10);

            return false;
        }
    }

    public void effectuerEffetSonore(String nomFichier) {
        Music punch = Gdx.audio.newMusic(Gdx.files.internal("soundEffects/" + nomFichier + ".mp3"));
        punch.setVolume(.2f);
        punch.play();
    }

    public SoundManager getSoundManager() {
        return this;
    }
}

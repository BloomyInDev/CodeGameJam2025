package fr.bastienluben.cgj2025.lib.son;

import java.util.ArrayList;
import java.util.List;

public class SoundManager {

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

    public SoundManager getSoundManager() {
        return this;
    }
}
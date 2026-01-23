package fr.bastienluben.cgj2025.lib.config;

import com.google.gson.annotations.Expose;

public class ConfigStructure {
    private ConfigLoader loader;

    @Expose
    private int score;

    public ConfigStructure(ConfigLoader loader) {
        this.loader = loader;
    }

    public void setLoader(ConfigLoader loader) {
        this.loader = loader;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        loader.storeFile();
    }
}

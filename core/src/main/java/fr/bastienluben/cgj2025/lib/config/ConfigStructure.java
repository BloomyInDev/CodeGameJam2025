package fr.bastienluben.cgj2025.lib.config;

import com.google.gson.annotations.Expose;

import java.util.HashMap;
import java.util.Map;

public class ConfigStructure {
    private ConfigLoader loader;

    @Expose
    private int bestScore;

    public ConfigStructure(ConfigLoader loader) {
        this.loader = loader;
    }

    public void setLoader(ConfigLoader loader) {
        this.loader = loader;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
        loader.storeFile();
    }

    @Override
    public String toString() {
        Map<String, Object> map = new HashMap<>();
        map.put("score", bestScore);

        StringBuilder sb = new StringBuilder();
        map.entrySet().stream().map((kv) -> String.format("    %s -> %s;\n", kv.getKey(), kv.getValue())).forEach(sb::append);

        return String.format("ConfigStructure{\n%s}", sb.toString());
    }
}

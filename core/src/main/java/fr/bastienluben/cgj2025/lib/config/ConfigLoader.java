package fr.bastienluben.cgj2025.lib.config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.bastienluben.cgj2025.Main;

public class ConfigLoader {
    private static final String CONFIG_FILE = "config.json";
    private static ConfigLoader instance = null;
    private final Gson gson;
    private ConfigStructure config = null;
    public ConfigLoader() {
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        parseFile();
    }

    public static ConfigLoader getInstance() {
        if (instance == null) instance = new ConfigLoader();
        return instance;
    }

    private boolean canStoreFile() {
        return Gdx.files.isLocalStorageAvailable();
    }

    private FileHandle getFile() {
        return Gdx.files.local(CONFIG_FILE);
    }

    private boolean _parseFile() {
        if (!canStoreFile()) {
            if (Main.DEBUG)
                System.out.println("Je ne peux pas stocker de ficher sur cet appareil");
            return false;
        }
        if (!getFile().exists()) {
            if (Main.DEBUG)
                System.out.println("Je ne trouve pas de fichier de configuration");
            return false;
        }
        String content = Gdx.files.local(CONFIG_FILE).readString();

        if (content.isEmpty()) {
            if (Main.DEBUG)
                System.out.println("Le fichier de configuration est vide");
            return false;
        }

        config = gson.fromJson(content, ConfigStructure.class);
        config.setLoader(this);
        if (Main.DEBUG)
            System.out.printf("J'ai lu le fichier de configuration: %s\n", config.toString());
        return true;
    }

    public void parseFile() {
        if (!_parseFile()) {
            config = new ConfigStructure(this);
            storeFile();
        }
    }

    public void storeFile() {
        if (!canStoreFile()) return;

        String content = gson.toJson(config);
        getFile().writeString(content, false);
        if (Main.DEBUG)
            System.out.printf(
                "Fichier écrit dans le stockage: %s\n", content
            );
    }

    public ConfigStructure getConfig() {
        return config;
    }
}

package fr.bastienluben.cgj2025.lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssetManager {
    private final Map<String, Texture> textures;

    public AssetManager() {
        this.textures = new HashMap<>();
    }

    public void load(String path) {
        getTexture(path);
    }

    public Texture getTexture(String path) {
        if (textures.containsKey(path)) return textures.get(path);
        Texture t =  new Texture(Gdx.files.internal(path));
        textures.put(path, t);
        return t;
    }

    public void dispose(List<String> paths) {
        for (String path : paths) {
            if (textures.containsKey(path)) {
                textures.get(path).dispose();
                textures.remove(path);
            }
        }
    }

    public void dispose() {
        textures.values().forEach(t -> t.dispose());
        textures.clear();
    }
}

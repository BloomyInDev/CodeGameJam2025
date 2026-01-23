package fr.bastienluben.cgj2025.lib.fonts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.HashMap;
import java.util.Map;

public class FontLoader {
    private static FontLoader instance;

    public static FontLoader getInstance() {
        if (instance == null) instance = new FontLoader();
        return instance;
    }

    private Map<String, FreeTypeFontGenerator> fontGenerators;
    private Map<FontIdentifier, BitmapFont> generatedFonts;

    public FontLoader() {
        this.fontGenerators = new HashMap<>();
        this.generatedFonts = new HashMap<>();
    }

    public void dispose() {
        generatedFonts.forEach((k, v) -> v.dispose());
        generatedFonts.clear();
        fontGenerators.forEach((k, v) -> v.dispose());
    }

    public void loadFont(String path, String name) {
        if (fontGenerators.containsKey(name)) {
            System.out.printf("Font \"%s\" was already loaded !!\n", path);
            return;
        }

        fontGenerators.put(name, new FreeTypeFontGenerator(Gdx.files.internal(path)));
    }

    public BitmapFont getFont(String fontName, FreeTypeFontGenerator.FreeTypeFontParameter parameters) {
        FontIdentifier identifier = new FontIdentifier(fontName, parameters);
        if (generatedFonts.containsKey(identifier)) {
            return generatedFonts.get(identifier);
        }

        if (!fontGenerators.containsKey(fontName)) {
            throw new RuntimeException("Font isn't loaded");
        }

        FreeTypeFontGenerator fontGen = fontGenerators.get(fontName);

        generatedFonts.put(identifier, fontGen.generateFont(parameters));

        return generatedFonts.get(identifier);
    }

    public BitmapFont getFont(String fontName, FontParameterBuilder builder) {
        return getFont(fontName, builder.build());
    }

    public BitmapFont getFont(String fontName) {
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        return getFont(fontName, parameter);
    }
}

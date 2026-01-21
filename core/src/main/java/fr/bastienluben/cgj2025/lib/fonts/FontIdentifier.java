package fr.bastienluben.cgj2025.lib.fonts;

import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.Objects;

public class FontIdentifier {
    private String name;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    public FontIdentifier(String name, FreeTypeFontGenerator.FreeTypeFontParameter parameter) {
        this.name = name;
        this.parameter = parameter;
    }

    public String getName() {
        return name;
    }

    public FreeTypeFontGenerator.FreeTypeFontParameter getParameter() {
        return parameter;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FontIdentifier that = (FontIdentifier) o;
        return Objects.equals(name, that.name) && Objects.equals(parameter, that.parameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parameter);
    }
}

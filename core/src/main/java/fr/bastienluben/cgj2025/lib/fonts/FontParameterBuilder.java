package fr.bastienluben.cgj2025.lib.fonts;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PixmapPacker;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FontParameterBuilder {
    private final FreeTypeFontGenerator.FreeTypeFontParameter params;

    public FontParameterBuilder() {
        this.params = new FreeTypeFontGenerator.FreeTypeFontParameter();
    }

    public FontParameterBuilder setSize(int size) {
        params.size = size;
        return this;
    }

    public FontParameterBuilder setColor(Color color) {
        params.color = color;
        return this;
    }

    public FontParameterBuilder setBorderColor(Color color) {
        params.borderColor = color;
        return this;
    }

    public FontParameterBuilder setBorderWidth(float width) {
        params.borderWidth = width;
        return this;
    }

    public FontParameterBuilder setBorderStraight(boolean straight) {
        params.borderStraight = straight;
        return this;
    }

    public FontParameterBuilder setBorderGamma(float gamma) {
        params.borderGamma = gamma;
        return this;
    }

    public FontParameterBuilder setShadowColor(Color color) {
        params.shadowColor = color;
        return this;
    }

    public FontParameterBuilder setShadowOffsetX(int offsetX) {
        params.shadowOffsetX = offsetX;
        return this;
    }

    public FontParameterBuilder setShadowOffsetY(int offsetY) {
        params.shadowOffsetY = offsetY;
        return this;
    }

    public FontParameterBuilder setCharacters(String characters) {
        params.characters = characters;
        return this;
    }

    public FontParameterBuilder setHinting(FreeTypeFontGenerator.Hinting hinting) {
        params.hinting = hinting;
        return this;
    }

    public FontParameterBuilder setMinFilter(Texture.TextureFilter filter) {
        params.minFilter = filter;
        return this;
    }

    public FontParameterBuilder setMagFilter(Texture.TextureFilter filter) {
        params.magFilter = filter;
        return this;
    }

    public FontParameterBuilder setGenMipMaps(boolean genMipMaps) {
        params.genMipMaps = genMipMaps;
        return this;
    }

    public FontParameterBuilder setMono(boolean mono) {
        params.mono = mono;
        return this;
    }

    public FontParameterBuilder setGamma(float gamma) {
        params.gamma = gamma;
        return this;
    }

    public FontParameterBuilder setRenderCount(int renderCount) {
        params.renderCount = renderCount;
        return this;
    }

    public FontParameterBuilder setSpaceX(int spaceX) {
        params.spaceX = spaceX;
        return this;
    }

    public FontParameterBuilder setSpaceY(int spaceY) {
        params.spaceY = spaceY;
        return this;
    }

    public FontParameterBuilder setPadTop(int padTop) {
        params.padTop = padTop;
        return this;
    }

    public FontParameterBuilder setPadLeft(int padLeft) {
        params.padLeft = padLeft;
        return this;
    }

    public FontParameterBuilder setPadBottom(int padBottom) {
        params.padBottom = padBottom;
        return this;
    }

    public FontParameterBuilder setPadRight(int padRight) {
        params.padRight = padRight;
        return this;
    }

    public FontParameterBuilder setKerning(boolean kerning) {
        params.kerning = kerning;
        return this;
    }

    public FontParameterBuilder setFlip(boolean flip) {
        params.flip = flip;
        return this;
    }

    public FontParameterBuilder setPacker(PixmapPacker packer) {
        params.packer = packer;
        return this;
    }

    public FontParameterBuilder setIncremental(boolean incremental) {
        params.incremental = incremental;
        return this;
    }

    public FreeTypeFontGenerator.FreeTypeFontParameter build() {
        FreeTypeFontGenerator.FreeTypeFontParameter copy = new FreeTypeFontGenerator.FreeTypeFontParameter();
        copy.size = params.size;
        copy.color = params.color;
        copy.borderColor = params.borderColor;
        copy.borderWidth = params.borderWidth;
        copy.borderStraight = params.borderStraight;
        copy.borderGamma = params.borderGamma;
        copy.shadowColor = params.shadowColor;
        copy.shadowOffsetX = params.shadowOffsetX;
        copy.shadowOffsetY = params.shadowOffsetY;
        copy.characters = params.characters;
        copy.hinting = params.hinting;
        copy.minFilter = params.minFilter;
        copy.magFilter = params.magFilter;
        copy.genMipMaps = params.genMipMaps;
        copy.mono = params.mono;
        copy.gamma = params.gamma;
        copy.renderCount = params.renderCount;
        copy.spaceX = params.spaceX;
        copy.spaceY = params.spaceY;
        copy.padTop = params.padTop;
        copy.padLeft = params.padLeft;
        copy.padBottom = params.padBottom;
        copy.padRight = params.padRight;
        copy.kerning = params.kerning;
        copy.flip = params.flip;
        copy.packer = params.packer;
        copy.incremental = params.incremental;
        return copy;
    }
}

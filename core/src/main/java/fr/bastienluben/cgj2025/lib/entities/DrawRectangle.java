package fr.bastienluben.cgj2025.lib.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class DrawRectangle {
    private static ShapeRenderer shape = new ShapeRenderer();

    public static void draw(Rectangle rect){

        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.GREEN);
        shape.rect(rect.x, rect.y, rect.width, rect.height);
        shape.end();
    }
}

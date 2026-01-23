package fr.bastienluben.cgj2025.lib.ui;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;
import java.util.List;

public class Button extends Image implements Disposable
{
    private static List<Button> _buttons = new ArrayList<Button>();

    public static void disoseAllButtons()
    {
        _buttons.clear();
    }

    private static boolean previousMouseHold = false;

    public static void updateAllButtons(Vector2 mousePos, boolean isMouseHold)
    {
        for (Button b : _buttons)
        {
            if (b.update(mousePos, isMouseHold))
            {
                previousMouseHold = false;
                return;
            }
        }
        previousMouseHold = isMouseHold;
    }

    public boolean update(Vector2 mousePos, boolean isMouseHold)
    {
        if (rect.contains(mousePos))
        {
            if (isMouseHold)
            {
                super.setColor(restColor);
            }
            else
            {
                super.setColor(selectedColor);
                if (previousMouseHold)
                {
                    action.run();
                    return true; // wtf il se prend pour qui java
                }
            }
        }
        else
        {
            super.setColor(restColor);
        }

        return false;
    }

    Text name;
    Runnable action;
    private Color selectedColor, restColor;

    @Override
    public void setColor(Color value)
    {
        restColor = value;
        selectedColor = new Color(value.r + 0.5f, value.g + 0.5f, value.b + 0.5f, value.a);
    }

    public Button(Runnable action, int width, int height, Color color)
    {
        super(width, height, color);
        setColor(color);
        this.action = action;
        name = new Text("");
        _buttons.add(this);
    }

    public Button(Runnable action, int width, int height, Color color, String text)
    {
        super(width, height, color);
        setColor(color);
        this.action = action;
        name = new Text(text);
        _buttons.add(this);
        name.setParent(this);
        name.setPosition(Bounds.Center);
    }

    public Button(Runnable action, int width, int height, Color color, String text, Color textColor)
    {
        this(action, width, height, color, text);
        name.color = textColor;
    }

    public void dispose()
    {
        _buttons.remove(this);
    }
}

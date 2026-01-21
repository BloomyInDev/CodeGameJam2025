package fr.bastienluben.cgj2025.lib.ui;

public enum Extend
{
    Horizontal(true, false),
    Vertical(false, true),
    Full(true, true),
    None(false, false);

    public final boolean x, y;
    private Extend(boolean x, boolean y)
    {
        this.x = x;
        this.y = y;
    }
}

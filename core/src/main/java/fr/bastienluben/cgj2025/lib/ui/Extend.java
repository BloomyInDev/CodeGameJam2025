package fr.bastienluben.cgj2025.lib.ui;

public enum Extend
{
    Horizontal(true, false),
    Vertical(false, true),
    Full(true, true),
    None(false, false);

    boolean x, y;
    private Extend(boolean x, boolean y)
    {

    }
}

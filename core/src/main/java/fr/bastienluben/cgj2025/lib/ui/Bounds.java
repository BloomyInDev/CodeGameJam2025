package tonpere.tamerecestjava;

public enum Bounds
{
    TopLeft((byte)0, (byte)2), Top((byte)1, (byte)2), TopRight((byte)2, (byte)2),
    Left((byte)0, (byte)1), Center((byte)1, (byte)1), Right((byte)2, (byte)1),
    BottomLeft((byte)0, (byte)0), Bottom((byte)1, (byte)0), BottomRight((byte)2, (byte)0);

    byte x, y;
    private Bounds(byte x, byte y)
    {
        this.x = x;
        this.y = y;
    }
}

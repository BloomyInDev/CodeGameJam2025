package fr.bastienluben.cgj2025.lib;


import com.badlogic.gdx.math.Vector2;

public class Lerps
{
    public static float Linear(float a, float b, float t)
    {
        if (t <= 0) return a;
        if (t >= 1) return b;
        return (a * (1 - t)) + (b * t);
    }
    public static float EaseIn(float a, float b, float t)
    {
        if (t <= 0) return a;
        if (t >= 1) return b;
        float k = t * t;
        return (a * (1 - k)) + (b * k);
    }

    public static float EaseOut(float a, float b, float t)
    {
        if (t <= 0) return a;
        if (t >= 1) return b;
        float k = t * (2 - t);
        return (a * (1 - k)) + (b * k);
    }

    public static float EaseInOut(float a, float b, float t)
    {
        if (t <= 0) return a;
        if (t >= 1) return b;
        float s = (float)Math.sin(((float)Math.PI * t) / 2f);
        float k = s * s;
        return (a * (1 - k)) + (b * k);
    }

    public static float CubeIn(float a, float b, float t, byte exp)
    {
        if (t <= 0) return a;
        if (t >= 1) return b;
        float k = (float)Math.pow(t, exp);
        return (a * (1 - k)) + (b * k);
    }


    public static float CubeOut(float a, float b, float t, byte exp)
    {
        if (t <= 0) return a;
        if (t >= 1) return b;
        float k = 1 - (float)Math.pow(t - 1, exp);
        return (a * (1 - k)) + (b * k);
    }

    public static float BackIn(float a, float b, float t, float k)
    {
        if (t <= 0) return a;
        if (t >= 1) return b;
        float t2 = t * t;
        float t3 = t2 * t;
        float q = -t3 + (2 * t2) + (k * (t3 - t2));
        return (a * (1 - q)) + (b * q);
    }

    public static float BackOut(float a, float b, float t, float k)
    {
        if (t <= 0) return a;
        if (t >= 1) return b;
        float t2 = t * t;
        float t3 = t2 * t;
        float q = t2 - t3 + t + k * (t3 - (2 * t2) + t);
        return (a * (1 - q)) + (b * q);
    }

    public static float BackInOut(float a, float b, float t, float k)
    {
        if (t <= 0) return a;
        if (t >= 1) return b;
        float teta = t * (float)Math.PI;
        float q = (float)Math.pow((float)Math.sin(teta / 2f), 2) -
            (k * (float)Math.sin(teta) * (float)Math.sin(2 * teta));
        return (a * (1 - q)) + (b * q);
    }

    public static float Triangle(float a, float b, float t)
    {
        if (t <= 0) return a;
        if (t >= 1) return a;
        float q = 1 - (2 * (float)Math.abs(t - 0.5f));
        return a * (1 - q) + (b * q);
    }

    public static float Parable(float a, float b, float t)
    {
        if (t <= 0) return a;
        if (t >= 1) return a;
        float q = (float)Math.sin((float)Math.PI * t);
        float q2 = q * q;
        return a * (1 - q2) + (b * q2);
    }

    private static final float sqrt6 = 2.449489742783178f;
    public static float BounceOut(float a, float b, float t, boolean twoBounces)
    {
        if (t <= 0) return a;
        if (t >= 1) return b;
        float q = 0;
        if (twoBounces)
            q = (float)Math.min(4 * t * t, 4 * (float)Math.pow(t - (3f / 4f), 2) + (3f / 4f));
        else
        {
            float sxc = 6 * t * t;
            q = (float)Math.min(
                sxc,
                (float)Math.min(
                    sxc - (3 * sqrt6 * t) + 3,
                    sxc - (2 * t * (sqrt6 + 3)) + (2 * sqrt6) + 1
                ));
        }
        return (a * (1 - q)) + (b * q);
    }
}

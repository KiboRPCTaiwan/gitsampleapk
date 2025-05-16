package jp.jaxa.iss.kibo.rpc.sampleapk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuaternionUtil {

    private static final Random rand = new Random();

    public static List<Float> generateRandomq(int dim) {
        if (dim != 4) {
            throw new IllegalArgumentException("Quaternion must have 4 components.");
        }

        double x = rand.nextGaussian();
        double y = rand.nextGaussian();
        double z = rand.nextGaussian();
        double norm = Math.sqrt(x * x + y * y + z * z);

        x /= norm;
        y /= norm;
        z /= norm;

        double rt = rand.nextDouble() * Math.PI;
        double sinrt = Math.sin(rt);
        double cosrt = Math.cos(rt);

        List<Float> q = new ArrayList<>();
        q.add((float) (x * sinrt));
        q.add((float) (y * sinrt));
        q.add((float) (z * sinrt));
        q.add((float) cosrt);
        return q;
    }
}
package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static void main(String[] args) {
        GuitarString[] array = new GuitarString[37];

        for (int i = 0; i < 37; i++) {
            double frequency = 440 * Math.pow(2, (i - 24) / 12.0);
            array[i] = new GuitarString(frequency);
        }

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int i = keyboard.indexOf(key);
                if (i >= 0) {
                    array[i].pluck();
                }
            }

            double sample = 0;
            for (int j = 0; j < 37; j++) {
                sample += array[j].sample();
                array[j].tic();
            }

            StdAudio.play(sample);
        }
    }
}

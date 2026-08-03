package gh2;

import deque.ArrayDeque;
import deque.Deque;


//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor
    private int capacity;

    /* Buffer for storing sound data. */
    private Deque<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        double doucapacity = SR / frequency;
        double round = Math.round(doucapacity);
        this.capacity = (int) round;

        ArrayDeque<Double> newbuffer = new ArrayDeque<>();

        for (int i = 0; i < round; i++) {
            newbuffer.addLast(0.0);
        }

        buffer = newbuffer;
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        for (int i = 0; i < capacity; i++) {
            buffer.removeLast();
        }

        for (int i = 0; i < capacity; i++) {
            double r =  Math.random() - 0.5;
            buffer.addLast(r);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double newSample = ((buffer.get(0) + buffer.get(1)) / 2) * DECAY;
        buffer.removeFirst();
        buffer.addLast(newSample);

    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.get(0);
    }
}

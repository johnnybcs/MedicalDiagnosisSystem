package model;

public class Disease {
    private int probability;

    public Disease() {
        this.probability = 0;
    }

    public int getProbability() {
        return probability;
    }

    public void updateProbability(int change) {
        this.probability += change;
    }

}

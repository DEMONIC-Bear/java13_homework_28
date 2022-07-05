public enum Quality {
    NORMAL(1.2),
    SPOILED(0.95),
    HALF_SPOILED(0.55),
    ALMOST_GONE(0.25),
    TOTALLY_SPOILED(0.1);

    public double getQuality() {
        return q;
    }
    private final double q;

    Quality(double q) {
        this.q = q;
    }

}

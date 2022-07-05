import java.util.Random;

public enum World {
    ALMATY,
    BISHKEK,
    GUANGZHOU,
    DUSHANBE,
    NEW_DELI,
    NUR_SULTAN;

    public static World getCity() {
        Random r = new Random();
        int rnd = r.nextInt(6);
        return switch (rnd) {
            case 0 -> World.ALMATY;
            case 1 -> World.BISHKEK;
            case 2 -> World.GUANGZHOU;
            case 3 -> World.DUSHANBE;
            case 4 -> World.NEW_DELI;
            default -> World.NUR_SULTAN;
        };
    }


}

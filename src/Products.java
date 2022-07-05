public enum Products {
    MEAT(6),
    DRIED_FRUITS(4),
    GRAIN(3),
    FLOUR(5),
    FABRICS(1),
    PAINT(2);
    private final int price;

    Products(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static Products getProduct(int p) {
        return switch (p) {
            case 0 -> Products.MEAT;
            case 1 -> Products.DRIED_FRUITS;
            case 2 -> Products.GRAIN;
            case 3 -> Products.FLOUR;
            case 4 -> Products.FABRICS;
            default -> Products.PAINT;
        };
    }
}

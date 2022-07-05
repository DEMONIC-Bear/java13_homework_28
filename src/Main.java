public class Main {
    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        dealer.getProductsList();
        System.out.printf("\n | %-12s | %-6s | %-4s\n","Product name","Price","Weight");
        System.out.println("-|--------------|-----------");
        for (Product p : dealer.products) {
            System.out.printf(" | %-12s | %-6s | %-4s\n",p.getProducts(), p.getPrice(), p.getWeight());
        }
        System.out.println("\nDealer bought some product and started to " + World.getCity() + " city, distance: " + dealer.getDistance());
        System.out.println("==========================================");
        dealer.startGame();
    }
}

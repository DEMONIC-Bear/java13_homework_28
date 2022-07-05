import java.util.ArrayList;
import java.util.Random;

public class Dealer {
    private int load_capacity;
    private int speed;
    private int money;
    private int initialAmountMoney;
    private World world;
    private int distance;
    ArrayList<Product> products;
    int days = 1;

    public Dealer() {
        products = new ArrayList<>();
        speed = 3;
        load_capacity = 100;
        money = 150;
        world = World.getCity();
        distance = new Random().nextInt(25) + 75;
        initialAmountMoney = money;
    }

    public int getLoad_capacity() {
        return load_capacity;
    }

    public void setLoad_capacity(int load_capacity) {
        this.load_capacity = load_capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void getProductsList() {
        int count = 0;
        while (count < 10) {
            Product product = new Product(count);
            if (product.getWeight() < load_capacity &&
                    product.getPrice() < money) {
                products.add(product);
                this.setMoney(this.getMoney() - product.getPrice());
                this.setLoad_capacity(this.load_capacity - product.getWeight());
            } else {
                break;
            }
            count++;
        }
    }

    public void startGame() {
        if (distance <= 0) {
            System.out.println("You arrived");
            displayInfo();
        } else {
            int rndState = new Random().nextInt(9) + 1;
            switch (rndState) {
                case 1 -> {
                    System.out.println("Stage - " + days);
                    State.typicalDay(this);
                    days++;
                }
                case 2 -> {
                    System.out.println("Stage - " + days);
                    State.rainyDay(this);
                    days++;
                }
                case 3 -> {
                    System.out.println("Stage - " + days);
                    State.smoothRoad(this);
                    days++;
                }
                case 4 -> {
                    System.out.println("Stage - " + days);
                    State.brokenWheel(this);
                    days++;
                }
                case 5 -> {
                    System.out.println("Stage - " + days);
                    State.river(this);
                    days++;
                }
                case 6 -> {
                    System.out.println("Stage - " + days);
                    State.metLocal(this);
                    days++;
                }
                case 7 -> {
                    System.out.println("Stage - " + days);
                    State.highwayRobbers(this);
                    days++;
                }
                case 8 -> {
                    System.out.println("Stage - " + days);
                    State.roadsideInn(this);
                    days++;
                }
                case 9 -> {
                    System.out.println("Stage - " + days);
                    State.productSpoiled(this);
                    days++;
                }
            }
            if (products.size() > 0) {
                startGame();
            } else {
                System.out.println("You have not a products");
            }

        }
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "load_capacity=" + load_capacity +
                ", speed=" + speed +
                ", money=" + money +
                ", initialAmountMoney=" + initialAmountMoney +
                ", world=" + world +
                ", distance=" + distance +
                ", products=" + products +
                ", days=" + days +
                '}';
    }
    public void displayInfo() {
        if (products.size() == 0) {
            System.out.println("Robbers took all products.");
        } else {
            int finallyMoney = 0;
            for (Product p : products) {
                finallyMoney += p.getPrice() * p.getProducts().getPrice();
            }
            System.out.println("Dealer earned: " + ((finallyMoney + money) - initialAmountMoney));
        }
    }
}

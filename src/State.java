import java.util.Random;

public class State {
    public static void typicalDay(Dealer dealer) {
        dealer.setDistance(dealer.getDistance() - dealer.getSpeed());
        System.out.println("Typical day");
        if (dealer.getDistance() > 0) {
            System.out.println("Left: " + dealer.getDistance());
            System.out.println("------------------------------------------");
        }
    }
    public static void rainyDay(Dealer dealer) {
        dealer.setDistance(dealer.getDistance() - (dealer.getSpeed() - 2));
        System.out.println("Rainy day");
        int rndPercent = new Random().nextInt(100) + 1;
        int rndProduct = new Random().nextInt(6) + 1;
        if (rndPercent <= 30) {
            if (rndProduct == dealer.products.size()) {
                for (int i = 0; i < dealer.products.size(); i++) {
                    dealer.products.get(i).setQuality(Quality.SPOILED);
                }
            }
        } else {
            System.out.println("Nothing");
        }
        if (dealer.getDistance() > 0) {
            System.out.println("Left: " + dealer.getDistance());
            System.out.println("------------------------------------------");
        }
    }

    public static void smoothRoad(Dealer dealer) {
        dealer.setDistance(dealer.getDistance() - (dealer.getSpeed() + 2));
        System.out.println("Smooth road");
        if (dealer.getDistance() > 0) {
            System.out.println("Left: " + dealer.getDistance());
            System.out.println("------------------------------------------");
        }
    }

    public static void brokenWheel(Dealer dealer) {
        System.out.println("Wheel is broken");
        if (dealer.getDistance() > 0) {
            System.out.println("Left: " + dealer.getDistance());
            System.out.println("------------------------------------------");
        }
    }

    public static void river(Dealer dealer) {
        System.out.println("River!");
        if (dealer.getDistance() > 0) {
            System.out.println("Left: " + dealer.getDistance());
            System.out.println("------------------------------------------");
        }
    }

    public static void metLocal(Dealer dealer) {
        System.out.println("Met a local");
        dealer.setDistance(dealer.getDistance() - (new Random().nextInt(3) + 3));
        if (dealer.getDistance() > 0) {
            System.out.println("Left: " + dealer.getDistance());
            System.out.println("------------------------------------------");
        }
    }

    public static void highwayRobbers(Dealer dealer) {
        System.out.println("Robbers");
        if (dealer.getMoney() > 20) {
            int giveSomeMoney = dealer.getMoney() - 20;
            dealer.setMoney(giveSomeMoney);
            System.out.println("You give: " + giveSomeMoney + " money");
        } else {
            int a = 0;
            int b = 0;
            for (int i = 0; i < dealer.products.size(); i++) {
                if (dealer.products.get(i).getPrice() > a) {
                    a = dealer.products.get(i).getPrice();
                    b = i;
                }
            }
            if (dealer.products.size() == 0) {
                System.out.println("The robbers got nothing");
            } else {
                System.out.println("Robbers take away: " + dealer.products.get(b).getProducts());
                dealer.products.remove(b);
            }
        }
        if (dealer.getDistance() > 0) {
            System.out.println("Left: " + dealer.getDistance());
            System.out.println("------------------------------------------");
        }
    }

    public static void roadsideInn(Dealer dealer) {
        Random r = new Random();
        int rnd = r.nextInt(dealer.products.size());
        dealer.setMoney((int) (dealer.getMoney() + dealer.products.get(rnd).getPrice() * dealer.products.get(rnd).getQuality().getQuality()));
        System.out.println("Roadside Inn! Dealer sold: " + dealer.products.get(rnd).getProducts() + "\n" +
                "Money: " + dealer.getMoney());
        if (dealer.getDistance() > 0) {
            System.out.println("Left: " + dealer.getDistance());
            System.out.println("------------------------------------------");
        }
    }

    public static void productSpoiled(Dealer dealer) {
        System.out.println("Product is spoiled");
        int a = new Random().nextInt(dealer.products.size());
        switch (dealer.products.get(a).getQuality()) {
            case NORMAL -> dealer.products.get(a).setQuality(Quality.SPOILED);
            case SPOILED -> dealer.products.get(a).setQuality(Quality.HALF_SPOILED);
            case HALF_SPOILED -> dealer.products.get(a).setQuality(Quality.ALMOST_GONE);
            case ALMOST_GONE, TOTALLY_SPOILED -> dealer.products.get(a).setQuality(Quality.TOTALLY_SPOILED);
        }
        if (dealer.getDistance() > 0) {
            System.out.println("Left: " + dealer.getDistance());
            System.out.println("------------------------------------------");
        }
    }
}


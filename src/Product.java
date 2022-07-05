import java.util.Objects;
import java.util.Random;

public class Product {
    private int weight;
    private Products products;
    private int price;
    private Quality quality;

    public Product(int p) {
        Random r = new Random();
        quality = Quality.NORMAL;
        products = Products.getProduct(p);
        weight = r.nextInt(6) + 5;
        price = products.getPrice() * weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;
        return products == product.products;
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String toString() {
        return "Product{" +
                "weight=" + weight +
                ", products=" + products +
                ", price=" + price +
                ", quality=" + quality +
                '}';
    }
}

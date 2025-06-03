import java.util.*;

class Product {
    private int productId;
    private String productName;
    private String category;
    private double price;

    public Product(int productId, String productName, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    public void setProductName(String productName) { this.productName = productName; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Category: %s | Price: %.2f",
                productId, productName, category, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        Product other = (Product) obj;
        return this.productId == other.productId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(productId);
    }
}

class ProductCatalogue {
    private final Map<Product, Integer> catalogue = new HashMap<>();

    private Product getProductById(int productId) {
        for (Product p : catalogue.keySet()) {
            if (p.getProductId() == productId) return p;
        }
        return null;
    }

    public boolean addProduct(Product product, int quantity) {
        if (getProductById(product.getProductId()) != null) {
            System.out.println("Product with this ID already exists.");
            return false;
        }
        catalogue.put(product, quantity);
        return true;
    }

    public Product getProduct(int productId) {
        return getProductById(productId);
    }

    public boolean updateProduct(int productId, String name, String category, double price, int quantity) {
        Product existing = getProductById(productId);
        if (existing == null) return false;

        existing.setProductName(name);
        existing.setCategory(category);
        existing.setPrice(price);
        catalogue.put(existing, quantity);
        return true;
    }

    public boolean deleteProduct(int productId) {
        Product toRemove = getProductById(productId);
        if (toRemove == null) return false;
        catalogue.remove(toRemove);
        return true;
    }

    public void displayAllProducts() {
        if (catalogue.isEmpty()) {
            System.out.println("Catalogue is empty.");
            return;
        }
        for (Map.Entry<Product, Integer> entry : catalogue.entrySet()) {
            System.out.println(entry.getKey() + " | Quantity: " + entry.getValue());
        }
    }

    public List<Map.Entry<Product, Integer>> getProductsSortedById() {
        List<Map.Entry<Product, Integer>> list = new ArrayList<>(catalogue.entrySet());
        list.sort(Comparator.comparingInt(e -> e.getKey().getProductId()));
        return list;
    }

    public List<Map.Entry<Product, Integer>> getProductsSortedByName() {
        List<Map.Entry<Product, Integer>> list = new ArrayList<>(catalogue.entrySet());
        list.sort(Comparator.comparing(e -> e.getKey().getProductName()));
        return list;
    }
}

public class assJavaCollections {
    public static void main(String[] args) {
        ProductCatalogue catalogue = new ProductCatalogue();

        catalogue.addProduct(new Product(101, "Laptop", "Electronics", 750.00), 10);
        catalogue.addProduct(new Product(102, "Chair", "Furniture", 120.50), 5);
        catalogue.addProduct(new Product(103, "Smartphone", "Electronics", 500.99), 15);

        System.out.println("\nAll Products:");
        catalogue.displayAllProducts();

        System.out.println("\nSorted by Name:");
        for (Map.Entry<Product, Integer> entry : catalogue.getProductsSortedByName()) {
            System.out.println(entry.getKey() + " | Quantity: " + entry.getValue());
        }

        System.out.println("\nSorted by ID:");
        for (Map.Entry<Product, Integer> entry : catalogue.getProductsSortedById()) {
            System.out.println(entry.getKey() + " | Quantity: " + entry.getValue());
        }

        System.out.println("\nUpdating Product 102...");
        catalogue.updateProduct(102, "Office Chair", "Furniture", 135.00, 8);
        System.out.println(catalogue.getProduct(102));

        System.out.println("\nDeleting Product 103...");
        catalogue.deleteProduct(103);

        System.out.println("\nFinal Catalogue:");
        catalogue.displayAllProducts();
    }
}

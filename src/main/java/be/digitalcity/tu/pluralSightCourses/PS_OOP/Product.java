package be.digitalcity.tu.pluralSightCourses.PS_OOP;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Objects;

public class Product {

    private final Category category;
    private final String name;
    private final BigDecimal price;

    public Product(Category category, String name, BigDecimal price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "{category:%s,price: %s $,name: %s}", category, price, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return category == product.category && name.equals(product.name) && price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name, price);
    }
}

package typesPackage;

import java.util.Objects;

public class SportsEquipment {
    private final Text name;
    private final Text category;
    private final double price;
    private final int weightGrams;
    private final int rating;

    public SportsEquipment(String nameStr, String categoryStr, double price, int weightGrams, int rating) {
        this.name = new Text(nameStr);
        this.category = new Text(categoryStr);
        this.price = price;
        this.weightGrams = weightGrams;
        this.rating = rating;
    }

    public Text getName() {
        return name;
    }

    public Text getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getWeightGrams() {
        return weightGrams;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SportsEquipment that = (SportsEquipment) o;
        return Double.compare(that.price, price) == 0
                && weightGrams == that.weightGrams
                && rating == that.rating
                && Objects.equals(name, that.name)
                && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, price, weightGrams, rating);
    }

    @Override
    public String toString() {
        return String.format("SportsEquipment{name='%s', category='%s', price=%.2f, weight=%dg, rating=%d}",
                name, category, price, weightGrams, rating);
    }
}
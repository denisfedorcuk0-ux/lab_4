package typesPackage;

import java.util.Objects;

/**
 * Represents an item of sports equipment containing processed Text properties and technical details.
 */
public class SportsEquipment {
    private final Text name;
    private final Text category;
    private final double price;
    private final int weightGrams;
    private final int rating;

    /**
     * Constructs a SportsEquipment instance with fields parsed into internal Text object structures.
     *
     * @param nameStr     the raw name of the equipment
     * @param categoryStr the raw category/sport type
     * @param price       the monetary value of the equipment
     * @param weightGrams the weight measured in grams
     * @param rating      the product quality rating or preference score
     */
    public SportsEquipment(String nameStr, String categoryStr, double price, int weightGrams, int rating) {
        this.name = new Text(nameStr);
        this.category = new Text(categoryStr);
        this.price = price;
        this.weightGrams = weightGrams;
        this.rating = rating;
    }

    /** @return the structured Text object representing the equipment name */
    public Text getName() {
        return name;
    }

    /** @return the structured Text object representing the equipment category */
    public Text getCategory() {
        return category;
    }

    /** @return the price of the equipment */
    public double getPrice() {
        return price;
    }

    /** @return the weight in grams */
    public int getWeightGrams() {
        return weightGrams;
    }

    /** @return the rating value */
    public int getRating() {
        return rating;
    }

    /**
     * Checks equality between two SportsEquipment instances.
     * Uses Double.compare for the floating-point price field to preserve precision safety.
     */
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

    /**
     * Generates a hash code utilizing all core properties of the entity.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, category, price, weightGrams, rating);
    }

    /**
     * Formats the sports equipment data into a human-readable string.
     */
    @Override
    public String toString() {
        return String.format("SportsEquipment{name='%s', category='%s', price=%.2f, weight=%dg, rating=%d}",
                name, category, price, weightGrams, rating);
    }
}
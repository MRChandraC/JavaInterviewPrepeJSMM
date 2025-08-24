/**
 * Builds a complex object step by step.
 * Avoids telescoping constructors.
 * Builder Example - Pizza
 * 
 * Use Case: Building complex Pizza objects with different toppings, sauces, and sizes.
 */
class Pizza {
    private String size;
    private String cheese;
    private String toppings;

    // Private constructor (only via Builder)
    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.toppings = builder.toppings;
    }

    @Override
    public String toString() {
        return "Pizza [size=" + size + ", cheese=" + cheese + ", toppings=" + toppings + "]";
    }

    // Builder Class
    public static class PizzaBuilder {
        private String size;
        private String cheese;
        private String toppings;

        public PizzaBuilder size(String size) {
            this.size = size;
            return this;
        }

        public PizzaBuilder cheese(String cheese) {
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder toppings(String toppings) {
            this.toppings = toppings;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}

// Main class
public class BuilderExample {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder()
                        .size("Large")
                        .cheese("Mozzarella")
                        .toppings("Olives, Mushrooms")
                        .build();

        System.out.println(pizza);
    }
}

import java.util.Comparator;
import java.util.List;

public class Item {
    private double cost;
    private double weight;

    public Item(double cost, double weight) {
        this.cost = cost;
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public double getWeight() {
        return weight;
    }
    @Override
    public String toString() {
        return "Item{" +
                "Cost='" + cost + '\'' +
                ", weight='" + weight+ '\'' +
                '}';
    }
}



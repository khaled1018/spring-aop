package lab_3.model;

public class Order {
    private final String id;
    private String status;

    public Order(String id, String status) {
        this.id = id;
        this.status = status;
    }

    @Override
    public String toString() { return "Order[" + id + ", " + status + "]"; }
}

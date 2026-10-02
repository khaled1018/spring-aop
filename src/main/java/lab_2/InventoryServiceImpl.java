package lab_2;

public class InventoryServiceImpl implements InventoryService {

    @Override
    public int checkStock(String sku) {
        return 54;
    }

    @Override
    public void reserveStock(String sku, int quantity) throws IllegalArgumentException {
        if(quantity > 100) {
            throw new IllegalArgumentException("Quantity is greater than 100");
        }
        System.out.println("[Target] Reservation successful.");
    }
}

package lab_2;

public interface InventoryService {

    int checkStock(String sku);
    void reserveStock(String sku, int quantity) throws IllegalArgumentException;
}

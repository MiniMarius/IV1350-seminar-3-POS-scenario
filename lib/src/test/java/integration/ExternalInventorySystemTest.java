package integration;

import model.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExternalInventorySystemTest {

    @Test
    void testCheckInventory() {
        ExternalInventorySystem externalInventorySystem = new ExternalInventorySystem();
        Integer itemId = 8;
        Item result = externalInventorySystem.checkInventory(itemId, 1);

        assertNotNull(result);
    }
}
package org.example;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {
    public Item createItem(Item item) throws SQLException;
    public void removeItem(int itemId) throws SQLException;
    public void updateItem(int itemId) throws SQLException;
    public List<Item> getAllItems() throws SQLException;
}

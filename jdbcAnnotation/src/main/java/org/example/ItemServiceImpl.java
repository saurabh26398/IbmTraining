package org.example;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("itemService")
public class ItemServiceImpl implements ItemService {
    private final ItemDAO itemDAO;

    @Autowired
    public ItemServiceImpl(ItemDAO itemDAO)
    {
        this.itemDAO = itemDAO;
    }

    @Override
    public Item createItem(Item item) throws SQLException {
        return itemDAO.createItem(item);

    }

    @Override
    public void removeItem(int itemId) throws SQLException {
        itemDAO.removeItem(itemId);
    }

    @Override
    public void updateItem(int itemId) throws SQLException {
    itemDAO.updateItem(itemId);
    }

    @Override
    public List<Item> getAllItems() throws SQLException {
        return itemDAO.getAllItems();
    }
}

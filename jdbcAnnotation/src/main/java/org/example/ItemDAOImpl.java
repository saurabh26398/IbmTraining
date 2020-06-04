package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("itemDAO")
public class ItemDAOImpl implements ItemDAO {
    private ItemFactory itemFactory;
    private Connection connection;
    Scanner scanner=new Scanner(System.in);

    @Autowired
    public ItemDAOImpl(ItemFactory itemFactory)
    {
        this.itemFactory = itemFactory;
    }

    @Override
    public Item createItem(Item item) throws SQLException {
        connection=itemFactory.getMyConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into item_table(id,name,price) values(?,?,?)");
        preparedStatement.setString(1, item.getItemID());
        preparedStatement.setString(2,item.getItemName());
        preparedStatement.setInt(3,item.getPrice());
        preparedStatement.executeUpdate();
        return item;
    }

    @Override
    public void removeItem(int itemId) throws SQLException {
        PreparedStatement preparedStatement=connection.prepareStatement("delete from item_table where id=?");
        preparedStatement.setString(1, String.valueOf(itemId));
        preparedStatement.executeUpdate();
        System.out.println("removed");

    }

    @Override
    public void updateItem(int itemId) throws SQLException {
        PreparedStatement
                preparedStatement=connection.prepareStatement("select * from item_table where id=?");
        preparedStatement.setString(1, String.valueOf(itemId));
        ResultSet rs=preparedStatement.executeQuery();
        int item=0;
        while(rs.next())
        {
            item++;
        }
        if(item<=0) {
            System.out.println("No Such item with the given id: "+itemId);

        }

        System.out.print(" Name:");

        String name = scanner.next();
        System.out.print("Price :");
        String price = scanner.next();


        preparedStatement=connection.prepareStatement("update item_table set name=?,price=? where id=?");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, price);

        preparedStatement.setString(3, String.valueOf(itemId));
        preparedStatement.executeUpdate();
        System.out.println("updated");
    }

    public List<Item> getAllItems() throws SQLException {
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from item_table");
        List<Item> student= new ArrayList<Item>() ;
        while(resultSet.next())
        {
            student.add(new Item(resultSet.getString("id"),resultSet.getString("name"),resultSet.getInt("price")));
        }
        return student;
    }
}


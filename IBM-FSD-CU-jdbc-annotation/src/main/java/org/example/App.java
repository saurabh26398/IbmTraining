package org.example;

import java.sql.SQLException;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{

    public static void main( String[] args ) throws SQLException {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
           System.out.println(context);
             ItemService itemService = context.getBean("itemService", ItemServiceImpl.class);
           // Item item = itemService.createItem(new Item(UUID.randomUUID().toString(), "TV", 20000));
            //Item item2= itemService.createItem(new Item("1", "LED", 25000));
           // System.out.println("Item saved successfully");

           // itemService.updateItem(1);
            //itemService.removeItem(1);
            itemService.getAllItems();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
}

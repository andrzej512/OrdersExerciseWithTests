package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagerTest {
    public Manager manager;
    public Order firtOrder;
    public Order secondOrder;
    public Order thirdOrder;
    public Order fourthOrder;

    @BeforeEach
    void setUp() {
        manager = new Manager();
        firtOrder = new Order(1, "first order", 1.0);
        secondOrder = new Order(2, "second order", 1.0);
        thirdOrder = new Order(1, "first order", 2.0);
        fourthOrder = new Order(1, "first order", 1.0);

        System.out.println("firstOrderHashCode" + firtOrder.hashCode());
        System.out.println("secondOrderhashCode" + secondOrder.hashCode());
    }

    @Test
    void addFirstOrderToMap() {
        //Given

        //When
        manager.addOrderToMap(firtOrder);

        //Then
        Assertions.assertEquals(1, manager.getMap().size());
    }

    @Test
    void addFirstOrderToMapTwice() {
        //Given

        //When
        manager.addOrderToMap(firtOrder);
        manager.addOrderToMap(firtOrder);

        //Then
        Assertions.assertEquals(1, manager.getMap().size());
        Assertions.assertEquals(2, manager.getMap().get(firtOrder).intValue());
    }

    @Test
    void addTwoOrdersWithDifferentPrice() {
        //Given

        //When
        manager.addOrderToMap(firtOrder);
        manager.addOrderToMap(thirdOrder);

        //Then
        Assertions.assertEquals(2, manager.getMap().size());
    }

    @Test
    void addTwoSameOrders() {
        //Given

        //When
        manager.addOrderToMap(firtOrder);
        manager.addOrderToMap(fourthOrder);

        //Then
        Assertions.assertEquals(1, manager.getMap().size());
        Assertions.assertEquals(2, manager.getMap().get(fourthOrder).intValue());
    }

    @Test
    void removeOrderFromMap() {
        //Given

        //When
        manager.addOrderToMap(firtOrder);
        manager.removeOrderFromMap(firtOrder);

        //Then
        Assertions.assertEquals(0, manager.getMap().size());
        Assertions.assertNull(manager.getMap().get(firtOrder));
    }

    @Test
    void decreaseOrderValue() {
        //Given

        //When
        manager.addOrderToMap(firtOrder);
        manager.addOrderToMap(firtOrder);
        manager.removeOrderFromMap(firtOrder);

        //Then
        Assertions.assertEquals(1, manager.getMap().size());
        Assertions.assertEquals(1, manager.getMap().get(firtOrder).intValue());
    }

    @Test
    void longTest() {

        manager.addOrderToMap(firtOrder);
        manager.addOrderToMap(firtOrder);

        Assertions.assertEquals(1, manager.getMap().size());
        Assertions.assertEquals(2, manager.getMap().get(firtOrder).intValue());

        manager.removeOrderFromMap(firtOrder);

        Assertions.assertEquals(1, manager.getMap().size());
        Assertions.assertEquals(1, manager.getMap().get(firtOrder).intValue());

        manager.removeOrderFromMap(firtOrder);

        Assertions.assertEquals(0, manager.getMap().size());


    }
}
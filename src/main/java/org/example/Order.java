package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class Order {
    private final String id;
    private OrderStatus status;
    private OrderItem[] items;
    private Money totalCost;

    public Order(String id, OrderItem[] items) {
        this.id = id;
        this.status = OrderStatus.NEW;
        setItems(items); // Defensive copy
    }

    // Defensive copy for array
    public void setItems(OrderItem[] items) {
        this.items = (items == null) ? new OrderItem[0] : items.clone();
    }

    public OrderItem[] getItems() {
        return items.clone();
    }

    // Getters/Setters for status and totalCost...
    public void setStatus(OrderStatus status) { this.status = status; }
    public OrderStatus getStatus() { return status; }
    public void setTotalCost(Money totalCost) { this.totalCost = totalCost; }
    public Money getTotalCost() { return totalCost; }
    public String getId() { return id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}

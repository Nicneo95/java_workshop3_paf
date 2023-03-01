package com.example.workshop3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.workshop3.model.Order;
@Repository
public class OrderRepo {

    // Get List of Orders under the same id
    public static final String getOrderSQL = "SELECT * FROM order_details INNER JOIN orders ON orders.id = order_details.order_id WHERE orders.id=?";

    // Get total cost for items (without shipping)
    public static final String getCostPrice = "SELECT SUM(order_details.quantity*order_details.unit_price) FROM order_details WHERE order_id=?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Order getOrder(Integer id) {
        try {
            List<Order> orderList = jdbcTemplate.query(getOrderSQL,
                    BeanPropertyRowMapper.newInstance(Order.class), id);
            // Create new order object to send to controller for display
            Order ord = new Order();
            ord.setOrderId(id);
            // same order date for each list item 
            ord.setOrderDate(orderList.get(0).getOrderDate());
            ord.setCustomerId(orderList.get(0).getCustomerId());
            ord.setCost(getCost(id));
            ord.setTotalCost(getCost(id) + orderList.get(0).getShippingFee());
            return ord;
        } catch (IndexOutOfBoundsException e) {
            // return null object to controller so that error message can be displayed
            // instead of erroring out at this step
            return null;
        }
    }

    public Float getCost(Integer id) {
        Float cost = jdbcTemplate.queryForObject(getCostPrice, Float.class, id);
        return cost;
      }
}

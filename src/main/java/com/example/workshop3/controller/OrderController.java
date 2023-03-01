package com.example.workshop3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.workshop3.model.Order;
import com.example.workshop3.repository.OrderRepo;

@Controller
@RequestMapping(path = "/")
public class OrderController {

  @Autowired
  OrderRepo orderRepo;
  
  @GetMapping(path = "/order/total/{id}")
  public String showOrderDetails(@PathVariable Integer id, Model model){
    Order order = orderRepo.getOrder(id);
    model.addAttribute("order", order);
    return "orderDetails";
  }

}

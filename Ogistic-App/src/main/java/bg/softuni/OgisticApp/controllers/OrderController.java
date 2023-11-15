package bg.softuni.OgisticApp.controllers;

import bg.softuni.OgisticApp.model.entity.Customer;
import bg.softuni.OgisticApp.model.entity.Delivery;
import bg.softuni.OgisticApp.model.entity.Order;
import bg.softuni.OgisticApp.repository.CustomerRepository;
import bg.softuni.OgisticApp.repository.DeliveryRepository;
import bg.softuni.OgisticApp.repository.OrderRepository;
import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private DeliveryRepository deliveryRepository;
    @GetMapping
    public String getAllOrders(Model model){
        List<Order> orders = orderRepository.findAll();
        model.addText("orders");
        return  "order/list";

    }
    @GetMapping("/create")
    public String showOrderForm(Model model) {
        List<Customer> customers = customerRepository.findAll();
        List<Delivery> deliveryMethods = deliveryRepository.findAll();
        model.addText("customers");
        model.addText("deliveryMethods");
        model.addText("order");
        return "order/create";
    }

    @PostMapping("/create")
    public String createOrder(@ModelAttribute Order order) {
        orderRepository.save(order);
        return "redirect:/orders";
    }
}


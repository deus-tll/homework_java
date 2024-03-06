package org.deus.homework_006.controllers;

import org.deus.homework_006.models.Order;
import org.deus.homework_006.models.Pizza;
import org.deus.homework_006.models.Topping;
import org.deus.homework_006.repositories.OrderRepository;
import org.deus.homework_006.repositories.PizzaRepository;
import org.deus.homework_006.repositories.ToppingRepository;
import org.deus.homework_006.requests.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/orders")
public class PizzaOrderController {

    @Autowired
    private final PizzaRepository pizzaRepository;

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final ToppingRepository toppingRepository;

    public PizzaOrderController(PizzaRepository pizzaRepository, OrderRepository orderRepository, ToppingRepository toppingRepository) {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
        this.toppingRepository = toppingRepository;
    }

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest) {
        // Перевірка адреси клієнта
        String deliveryAddress = orderRequest.getDeliveryAddress();
        if (!isInDeliveryZone(deliveryAddress)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("We do not deliver to this address: " + deliveryAddress);
        }

        Pizza pizza = pizzaRepository.findByName(orderRequest.getPizzaName());
        Order order = new Order();
        order.setCustomerName(orderRequest.getCustomerName());
        order.setPhoneNumber(orderRequest.getPhoneNumber());
        order.setEmail(orderRequest.getEmail());
        order.setDeliveryAddress(deliveryAddress);
        order.setPizza(pizza);
        return ResponseEntity.ok(orderRepository.save(order));
    }

    @PostMapping("/createCustomPizza")
    public ResponseEntity<?> createCustomPizza(@RequestParam String pizzaName, @RequestParam Set<Long> toppingIds) {
        Pizza customPizza = new Pizza();
        customPizza.setName(pizzaName);
        Set<Topping> toppings = new HashSet<>();
        for (Long toppingId : toppingIds) {
            Topping topping = toppingRepository.findById(toppingId)
                    .orElseThrow(() -> new RuntimeException("Topping not found"));
            toppings.add(topping);
        }
        customPizza.setToppings(toppings);
        return ResponseEntity.ok(pizzaRepository.save(customPizza));
    }

    private boolean isInDeliveryZone(String address) {
        // Логіка перевірки адреси на належність до зони доставки
        // Зараз вона просто повертає true, щоб показати загальний принцип
        return true;
    }
}

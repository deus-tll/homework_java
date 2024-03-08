package org.deus.homework_008.controllers;

import org.deus.homework_008.models.Shop;
import org.deus.homework_008.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private ShopRepository shopRepository;

    @GetMapping
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    @GetMapping("/{id}")
    public Shop getShopById(@PathVariable Long id) {
        return shopRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shop not found with id: " + id));
    }

    @PostMapping
    public Shop addShop(@RequestBody Shop shop) {
        return shopRepository.save(shop);
    }

    @PutMapping("/{id}")
    public Shop updateShop(@PathVariable Long id, @RequestBody Shop shopDetails) {
        Shop shop = shopRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shop not found with id: " + id));

        shop.setName(shopDetails.getName());
        shop.setAddress(shopDetails.getAddress());
        shop.setPhone(shopDetails.getPhone());
        shop.setEmail(shopDetails.getEmail());
        shop.setWebsite(shopDetails.getWebsite());
        shop.setCategory(shopDetails.getCategory());
        shop.setDescription(shopDetails.getDescription());

        return shopRepository.save(shop);
    }

    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable Long id) {
        shopRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shop not found with id: " + id));
        shopRepository.deleteById(id);
    }

    @GetMapping("/search")
    public List<Shop> searchShops(@RequestParam String query) {
        return shopRepository.findByNameContainingOrCategoryContainingOrAddressContaining(query, query, query);
    }
}

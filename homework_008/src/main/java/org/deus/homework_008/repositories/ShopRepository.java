package org.deus.homework_008.repositories;

import org.deus.homework_008.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findByNameContainingOrCategoryContainingOrAddressContaining(String name, String category, String address);
}

package org.deus.homework_006.repositories;

import org.deus.homework_006.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    Pizza findByName(String name);
}

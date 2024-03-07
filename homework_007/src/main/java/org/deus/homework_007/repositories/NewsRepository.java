package org.deus.homework_007.repositories;

import org.deus.homework_007.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}

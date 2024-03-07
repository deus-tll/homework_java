package org.deus.homework_007.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "news")
@Data
@EqualsAndHashCode(callSuper = true)
public class News extends BaseEntity {
    private String title;
    private String description;
    private String content;
    private String imageUrl;
}

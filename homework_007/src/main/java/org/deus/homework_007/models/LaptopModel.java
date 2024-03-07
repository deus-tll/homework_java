package org.deus.homework_007.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "laptop_models")
@Data
@EqualsAndHashCode(callSuper = true)
public class LaptopModel extends BaseEntity {
    private String name;
    private String description;
    private String imageUrl;
}

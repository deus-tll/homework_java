package org.deus.homework_007.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "manufacturers")
@Data
@EqualsAndHashCode(callSuper = true)
public class Manufacturer extends BaseEntity {
    private String name;
    private String headquarters;
    private String logoUrl;
    private int employeesCount;
    private String info;
}

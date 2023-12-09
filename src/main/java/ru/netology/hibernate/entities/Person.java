package ru.netology.hibernate.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
@Table(name = "PERSONS")
public class Person {
    @EmbeddedId
    private PersonsPK pk;
    private String phoneNumber;
    private String cityOfLiving;
}

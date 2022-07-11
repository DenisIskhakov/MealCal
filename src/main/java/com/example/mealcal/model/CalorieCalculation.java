package com.example.mealcal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalorieCalculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer weight;
    private Integer height;
    private Integer age;

    @Embedded
    private ActivityFactor activityFactor;
    private Integer percentageSurplusOrDeficit; // -10 = худеем | +10 = набираем


}

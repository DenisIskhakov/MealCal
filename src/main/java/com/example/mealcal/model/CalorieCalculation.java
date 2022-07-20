package com.example.mealcal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalorieCalculation extends  BaseEntity{


    private Integer weight;
    private Integer height;
    private Integer age;

    @Embedded
    private ActivityFactor activityFactor;

    @Enumerated(value = EnumType.STRING)
    private PercentageSurplusOrDeficit percentageSurplusOrDeficit; // 0.1 0.15 0.2
    //коэффициент активности
    @Enumerated(value = EnumType.STRING)
    private Activity coefficientActivity;

}

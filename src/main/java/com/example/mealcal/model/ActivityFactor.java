package com.example.mealcal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Data
@NoArgsConstructor
// Образ жизни
public class ActivityFactor {
    // >5 т.ш -не активный образ жизни
    //5-7 nizko
    //7.5-10 srediy
    //<10 activity

    // сколько тренировок в неделю: 3 , 4-5, 7

    private Integer numbers_Of_Activity; // сколько тренировок в неделю
    @Enumerated(value = EnumType.STRING)
    private Activity activity; // какой образ жизни

    public ActivityFactor(Integer numbers_Of_Activity, Activity activity) {
        this.numbers_Of_Activity = numbers_Of_Activity;
        this.activity = activity;
    }
}

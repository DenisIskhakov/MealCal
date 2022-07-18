package com.example.mealcal.model;

import lombok.Getter;

import java.util.stream.Stream;

public enum Activity {
    /*Коэффициенты физической активности:
    Минимальные нагрузки (сидячая работа) - 1,2
    Немного дневной активности и легкие упражнения 1-3 раза в неделю - 1,375
    Тренировки 4-5 раз в неделю (или работа средней тяжести) - 1,4625
    Интенсивные тренировки 4-5 раз в неделю - 1,550
    Ежедневные тренировки - 1,6375
    Ежедневные интенсивные тренировки или тренировки 2 раза в день - 1,725
    Тяжелая физическая работа или интенсивные тренировки 2 раза в день - 1,9

    Фактором активности является образ жизни, а не только время тренировки. */

    MINIMUM_LOADS(1.2),
    SOME_DAILY_ACTIVITY_AND_LIGHT_EXERCISE(1.3),
    WORKOUT_4_5_TIMES_A_WEEK(1.4625),
    INTENSE_WORKOUT(1.550),
    DAILY_WORLOUTS(1.6375),
    DAILY_INTENSIVE_TRAINING_OR_TRAINING_2_TIMES_A_DAY(1.725),
    HARD_PHYSICAL_WORK_OR_INTENSE_TRAINING_2_TIMES_A_DAY(1.9);



    private Double coefficientActivity;

    public Double getActivity() {
        return coefficientActivity;
    }

    Activity(Double activity) {
        this.coefficientActivity = activity;
    }
    public static Activity off(Double activity)  {
        try {
            return Stream.of(Activity.values())
                    .filter(a-> a.getActivity() == activity)
                    .findFirst()
                    .orElseThrow(Exception:: new);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

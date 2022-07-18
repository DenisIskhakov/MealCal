package com.example.mealcal.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class AbstractFormula extends BaseEntity{

    private Double basal_metabolic_rate; // Основной уровень метаболизма
    private Double support; // Поддержка (сохранение веса)
    private Double calorie_deficit; // Дефицит калорий (похудение)
    private Double calorie_surplus; // Профицит калорий (набор веса)

    // По формуле Миффлина-Сан Жеора (более точная):
    public abstract void basalMetabolicRateMifflin(CalorieCalculation calorieCalculation);
    public abstract void supportMifflin(CalorieCalculation calorieCalculation);
    public abstract void calorieDeficitMifflin(CalorieCalculation calorieCalculation);
    public abstract void calorieSurplusMifflin(CalorieCalculation calorieCalculation);

    // По формуле Харриса-Бенедикта (с погрешностью):
    public abstract void basalMetabolicRateBenedict(CalorieCalculation calorieCalculation);
    public abstract void supportBenedict(CalorieCalculation calorieCalculation);
    public abstract void calorieDeficitBenedict(CalorieCalculation calorieCalculation);
    public abstract void calorieSurplusBenedict(CalorieCalculation calorieCalculation);
}

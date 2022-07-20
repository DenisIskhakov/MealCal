package com.example.mealcal.model;

import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class AbstractFormula extends BaseEntity{


    @ManyToOne
    @JoinColumn(name = "calorie_calculation_id")
    protected CalorieCalculation calorieCalculation;

    public AbstractFormula() {
    }

    public AbstractFormula(CalorieCalculation calorieCalculation) {
        this.calorieCalculation = calorieCalculation;
    }

    private Double basalMetabolicRate; // Основной уровень метаболизма
    private Double support; // Поддержка (сохранение веса)
    private Double calorieDeficit; // Дефицит калорий (похудение)
    private Double calorieSurplus; // Профицит калорий (набор веса)

    // По формуле Миффлина-Сан Жеора (более точная):
    public abstract Double getBasalMetabolicRate();
    public abstract Double getSupport();
    public abstract Double getCalorieDeficit();
    public abstract Double getCalorieSurplus();

//    // По формуле Харриса-Бенедикта (с погрешностью):
//    public abstract void basalMetabolicRateBenedict(CalorieCalculation calorieCalculation);
//    public abstract void supportBenedict(CalorieCalculation calorieCalculation);
//    public abstract void calorieDeficitBenedict(CalorieCalculation calorieCalculation);
//    public abstract void calorieSurplusBenedict(CalorieCalculation calorieCalculation);
}

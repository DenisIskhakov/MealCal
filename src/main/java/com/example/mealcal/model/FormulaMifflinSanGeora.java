package com.example.mealcal.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@Builder
@NoArgsConstructor
public class FormulaMifflinSanGeora extends AbstractFormula{

    @Override
    // Основной уровень метаболизма
    public void basalMetabolicRateMifflin(CalorieCalculation calorieCalculation) {
        this.setBasal_metabolic_rate((9.99*calorieCalculation.getWeight())
                +(6.25*calorieCalculation.getHeight())
                -(4.92*calorieCalculation.getAge())-161);

    }
    @Override
    //Поддержка(Сохранение веса)
    public void supportMifflin(CalorieCalculation calorieCalculation){
        if(this.getBasal_metabolic_rate()<1200){
            this.setSupport(1200.0);
        } else {
            this.setSupport(this.getBasal_metabolic_rate() *
                    calorieCalculation.getCoefficientActivity().getActivity());
        }
    }
    @Override
    //Дефицит калорий (похудение)
    //Нужно указать в переменную процент дефецита/профицита(10-15-20)
    public void calorieDeficitMifflin(CalorieCalculation calorieCalculation){
        if((this.getSupport()-0.1*this.getSupport())<=1200){
            this.setCalorie_deficit(1200.0);
        }else {
            this.setCalorie_deficit(this.getSupport()-this.getSupport()*0.1);
        }
    }
    @Override
    //Профицит калорий (набор веса)
    //Нужно указать в переменную процент дефецита/профицита(10-15-20)
    public void calorieSurplusMifflin(CalorieCalculation calorieCalculation){
        this.setCalorie_surplus(this.getSupport()+this.getSupport()*0.1);
    }

}

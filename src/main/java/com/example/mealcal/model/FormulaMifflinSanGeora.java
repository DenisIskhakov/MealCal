package com.example.mealcal.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
//@Builder
@NoArgsConstructor
public class FormulaMifflinSanGeora extends AbstractFormula{
    private Double basalMetabolicRate;
    private Double support;
    private Double calorieDeficit;
    private Double calorieSurplus;

    public FormulaMifflinSanGeora(CalorieCalculation calorieCalculation) {
        super(calorieCalculation);
    }

    @Override
    // Основной уровень метаболизма
    public Double getBasalMetabolicRate() {
        this.setBasalMetabolicRate((9.99*calorieCalculation.getWeight())
                +(6.25*calorieCalculation.getHeight())
                -(4.92*calorieCalculation.getAge())-161);
        return basalMetabolicRate;
    }

    @Override
    //Поддержка(Сохранение веса)
    public Double getSupport(){
        if(this.getBasalMetabolicRate()<1200){
            this.setSupport(1200.0);
        } else {
            this.setSupport(this.getBasalMetabolicRate() *
                    calorieCalculation.getCoefficientActivity().getActivity());
        }
        return support;
    }
    @Override
    //Дефицит калорий (похудение)
    //Нужно указать в переменную процент дефецита/профицита(10-15-20)
    public Double getCalorieDeficit(){
        if((this.getSupport()-0.1*this.getSupport())<=1200){
            this.setCalorieDeficit(1200.0);
        }else {
            this.setCalorieDeficit(this.getSupport()-this.getSupport()*0.1);
        }
        return calorieDeficit;
    }
    @Override
    //Профицит калорий (набор веса)
    //Нужно указать в переменную процент дефецита/профицита(10-15-20)
    public Double getCalorieSurplus(){
        this.setCalorieSurplus(this.getSupport()+this.getSupport()*0.1);
        return calorieSurplus;
    }

    public void setBasalMetabolicRate(Double basalMetabolicRate) {
        this.basalMetabolicRate = basalMetabolicRate;
    }

    public void setSupport(Double support) {
        this.support = support;
    }

    public void setCalorieDeficit(Double calorieDeficit) {
        this.calorieDeficit = calorieDeficit;
    }

    public void setCalorieSurplus(Double calorieSurplus) {
        this.calorieSurplus = calorieSurplus;
    }
}

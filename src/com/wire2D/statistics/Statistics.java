package com.wire2D.statistics;

/**
 * Created by Mazek on 2016-03-18.
 */
public class Statistics {

    public float aHealth;
    public float maxHealth;
    public float aMana;
    public float maxMana;
    public float Strength;
    public float Defense;

    public Statistics(float health,float maxhealth, float mana,float maxMana, float strength, float defense){
        this.aHealth = health;
        this.maxHealth = maxhealth;
        this.aMana = mana;
        this.maxMana = maxMana;
        this.Strength = strength;
        this.Defense = defense;
    }
}

package com.closednotes.proctr.objects;

import com.closednotes.proctr.Difficulty;
import com.closednotes.proctr.objects.tower.Tower;
import com.closednotes.proctr.objects.tower.TowerPicture;

import java.util.LinkedList;


public class Player {
    private String name;
    private int money;
    private Difficulty difficulty;
    private double gpa;
    private LinkedList<TowerPicture> towerList;

    public Player(String name, Difficulty difficulty) {
        this.name = name;
        switch (difficulty) {
        case CLOSED_NOTES:
            money = 500;
            gpa = 2.0;
            break;
        case CHEAT_SHEET:
            money = 400;
            gpa = 3.0;
            break;
        case OPEN_NOTES:
            money = 300;
            gpa = 3.5;
            break;
        default:
            money = 425;
            gpa = 3.25;
            break;
        }
        this.difficulty = difficulty;
        towerList = new LinkedList<>();
    }

    public double getGpa() {
        return gpa;
    }

    public void changeGPA(double amt) {
        gpa += amt;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public Tower purchaseTower(Tower tower) {
        if (tower.getPurchaseCost() <= money) {
            money -= tower.getPurchaseCost();
            return tower;
        } else {
            throw new IllegalArgumentException("Insufficient funds!");
        }
    }

    public void earnMoney(int money) {
        this.money += money;
    }

    public LinkedList<TowerPicture> getTowerList() {
        return towerList;
    }

    public void addToTowerList(TowerPicture tower) {
        towerList.add(tower);
    }
}

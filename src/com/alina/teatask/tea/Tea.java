package com.alina.teatask.tea;

import com.alina.teatask.food.Food;
import com.alina.teatask.food.Nutritious;

import java.util.Objects;

public class Tea extends Food implements Nutritious {

    private Color taste;

    //constructor - to create objects(tea)
    public Tea(Color taste) {
        this.taste = taste;
    }

    public Color getTaste() {
        return taste;
    }

    @Override
    public int calculateCalories() {
        if (taste.equals(Color.BLACK)){
            return 5;
        }

        return 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tea tea = (Tea) o;
        return taste == tea.taste;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), taste);
    }

    @Override
    public String toString() {
        return "Tea with " +
                "taste=" + taste +
                ';';
    }
}

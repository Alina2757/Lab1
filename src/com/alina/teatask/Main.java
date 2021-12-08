package com.alina.teatask;

import com.alina.teatask.food.Food;
import com.alina.teatask.tea.Color;
import com.alina.teatask.tea.Tea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static final List<Food> breakfastFoodList = new ArrayList<Food>() {
        {
            add(new Tea(Color.FRUCT_TEA));
            add(new Tea(Color.BLACK));
        }
    };

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            // -Tea/Green -calories
            //String[] parts = arg.split(" -");
            if (i == 0) {
                String[] parts = args[i].split("/");// divide "tea/all" to two elements of the parts array
                if (parts[0].equals("Tea")) {
                    System.out.println("------------------calculate items in breakfast-------------------");
                    int numberOfTeaInBreakfast = 0;
                    if (parts[1].equalsIgnoreCase("fruit")) {
                        numberOfTeaInBreakfast = countItemFromBreakfast(breakfastFoodList, Color.FRUCT_TEA);
                    } else if (parts[1].equalsIgnoreCase("black")) {
                        numberOfTeaInBreakfast = countItemFromBreakfast(breakfastFoodList, Color.BLACK);
                    } else {
                        numberOfTeaInBreakfast = countItemFromBreakfast(breakfastFoodList, null);
                    }
                    System.out.println("Breakfast contains " + numberOfTeaInBreakfast + " tea items.");
                }
            }
            if (i == 1 && args[1].equals("-calories")) {
                System.out.println("------------------calories calculating----------------");
                System.out.println("Breakfast contains " + calculateCcalForBreakfast(breakfastFoodList) + " calories.");
            }
            if (i == 2 && args[2].equals("-sort")) {
                System.out.println("-------------------sorting-----------------------------");
                // transform list of food to list of tea
                List<Tea> teaList = new ArrayList<>();
                for (Food f: breakfastFoodList) {
                    teaList.add((Tea) f);
                }
                List<Tea> sortedList = sortTeaList(teaList);
                //print elements of the tea list to the console
                for (Tea t: sortedList) {
                    System.out.println(t);
                }
            }

        }
    }

    private static List<Tea> sortTeaList(List<Tea> teaList) {
        ComparatorTea playerComparator = new ComparatorTea();
        Collections.sort(teaList, playerComparator);
        return teaList;
    }

    private static int calculateCcalForBreakfast(List<Food> breakfastFoodList) {
        int ccal = 0;
        for (Food item : breakfastFoodList) {
            ccal += item.calculateCalories();
        }

        return ccal;
    }

    private static int countItemFromBreakfast(List<Food> breakfastFoodList, Color inputColor) {
        int count = 0;
        for (Food item : breakfastFoodList) {
            //compare objects by field and type
            if (item instanceof Tea && (inputColor == null || ((Tea) item).getTaste().equals(inputColor))) {
                count++;
            }
        }

        return count;
    }
}

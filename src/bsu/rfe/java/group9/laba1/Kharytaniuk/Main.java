package bsu.rfe.java.group9.laba1.Kharytaniuk;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Food> breakfast = new ArrayList<>();

        for (String arg : args) {
            String[] parts = arg.split("/");

            switch (parts[0]) {
                case "Eggs" -> {
                    try {
                        if (parts.length > 1) {
                            String[] par = parts[1].split(",");
                            if (par.length == 2) {
                                breakfast.add(new Eggs(par[0], Double.parseDouble(par[1])));
                            } else {
                                breakfast.add(new Eggs(parts[1]));
                            }
                        } else {
                            System.out.println("Ошибка: недостаточно параметров для Eggs");
                            continue;
                        }
                        breakfast.get(breakfast.size() - 1).consume();
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода параметров для Eggs");
                        continue;
                    }
                }
                case "Apple" -> {
                    try {
                        if (parts.length > 1) {
                            String[] par = parts[1].split(",");
                            if (par.length == 2) {
                                breakfast.add(new Apple(par[0], Double.parseDouble(par[1])));
                            } else {
                                breakfast.add(new Apple(parts[1]));
                            }
                        } else {
                            System.out.println("Ошибка: недостаточно параметров для Apple");
                            continue;
                        }
                        breakfast.get(breakfast.size() - 1).consume();
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода параметров для Apple");
                        continue;
                    }
                }
                case "Cheese" -> {
                    try {
                        if (parts.length > 1) {
                            breakfast.add(new Cheese(Double.parseDouble(parts[1])));
                        } else {
                            breakfast.add(new Cheese());
                        }
                        breakfast.get(breakfast.size() - 1).consume();
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода параметров для Cheese");
                        continue;
                    }
                }
                case "-sort" -> {
                    breakfast.sort(new Food_comparator());
                    System.out.println("\nЗАВТРАК ОТСОРТИРОВАН:");
                    for (Food food : breakfast) {
                        System.out.println(food);
                    }
                }
                case "-calories" -> {
                    double sum_calories = 0;
                    for (Food food : breakfast) {
                        if (food instanceof Nutritious) {
                            sum_calories += ((Nutritious) food).calculate_calories();
                        }
                    }
                    System.out.println("\nОБЩАЯ КАЛОРИЙНОСТЬ: " + sum_calories + "\n");
                }
                default -> {
                    System.out.println("Неизвестная команда: " + parts[0]);
                }
            }
        }
    }
}
package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("\nЭто программа простого калькулятора.\n" +
                "Она может считать простые целые числа между собой." +
                "Числа не должны быть больше 10.\n" +
                "Числа и операнды вводятся через пробел.\n");

        while (true){

                System.out.println("Введите операцию:");
                String text = new Scanner(System.in).nextLine();
                System.out.println(calc(text));

        }
    }

    public static String calc(String input) throws Exception {
        String result;
        int oneOperand;
        int twoOperand;


        String[] splittingText = input.split(" ");
        if (splittingText.length != 3){
            throw new Exception("Строка не является математическим выражением или введено не корректное выражение." +
                    "\n Пример: 10 + 5");
        }

        try {
            oneOperand = Integer.parseInt(splittingText[0]);
            twoOperand = Integer.parseInt(splittingText[2]);
        }catch (Exception e){
            throw new Exception("Программа не работает с дробными числами");
        }


        String operator = splittingText[1];

        if (oneOperand > 10 || twoOperand > 10){
            throw new Exception("Один из операндов больше допустимого значения. Числа не могут превышать 10");
        }


        switch (operator){
            case "+" -> result = String.valueOf(oneOperand + twoOperand);
            case "-" -> result = String.valueOf(oneOperand - twoOperand);
            case "*" -> result = String.valueOf(oneOperand * twoOperand);
            case "/" -> result = String.valueOf(oneOperand / twoOperand);
            default -> throw new Exception("Введите допустимы оператор : +, -, /, *");
        }

        return "Выражение равно: " + result + "\n";
    }

}
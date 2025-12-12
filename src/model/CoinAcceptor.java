package model;

import interfaces.PaymentAcceptor;

import java.util.Scanner;

public class CoinAcceptor implements PaymentAcceptor {
    private int amount;

    public Scanner sc = new Scanner(System.in);

    public CoinAcceptor(int amount) {
        this.amount = amount;
    }

    @Override
    public int getBalance() {
        return amount;
    }

    @Override
    public void topUp() {
        print("Введите сумму монет для пополнения: ");
        String sumOfBalance = sc.nextLine().strip();

        try {
            int add = Integer.parseInt(sumOfBalance);
            if (add <= 0) {
                print("Сумма должна быть больше 0.");
                return;
            }
            amount += add;
        } catch (NumberFormatException e) {
            print("Нужно ввести число.");
        }
    }

    @Override
    public boolean charge(int amountToCharge) {
        if (amount >= amountToCharge) {
            amount -= amountToCharge;
            return true;
        }
        return false;
    }

    public void print(String str) {
        System.out.println(str);
    }
}
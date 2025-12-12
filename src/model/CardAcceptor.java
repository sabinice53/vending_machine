package model;

import interfaces.PaymentAcceptor;

import java.util.Scanner;

public class CardAcceptor implements PaymentAcceptor {

    private int balance;
    public Scanner sc = new Scanner(System.in);

    public CardAcceptor(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void topUp() {
            print("Введите номер карты (10 цифр): ");
            String card = sc.nextLine().strip();
            if (card.length() != 10) {
                print("Длина номера карты неверная.");
                return;
            }

        System.out.print("Введите сумму пополнения: ");
        String sumInput = sc.nextLine().strip();

        try {
            int add = Integer.parseInt(sumInput);
            if (add <= 0) {
                print("Сумма должна быть больше 0.");
                return;
            }
            balance += add;
            print("Оплата картой успешна.");
        } catch (NumberFormatException e) {
            print("Нужно ввести число.");
        }
    }

    @Override
    public boolean charge(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    private void print(String msg) {
        System.out.println(msg);
    }
}

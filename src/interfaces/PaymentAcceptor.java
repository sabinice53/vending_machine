package interfaces;

public interface PaymentAcceptor {

    int getBalance();

    void topUp();

    boolean charge(int amount);

}
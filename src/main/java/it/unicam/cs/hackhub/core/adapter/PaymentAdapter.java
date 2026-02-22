package it.unicam.cs.hackhub.core.adapter;

/**
 * Contract for external payment (e.g. prize payout).
 */
public interface PaymentAdapter {

    boolean payoutPrize(String teamId, double amount);
}

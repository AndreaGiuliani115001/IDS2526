package it.unicam.cs.hackhub.core.adapter;

/**
 * Port for payment operations to distribute hackathon prizes.
 */
public interface PaymentAdapter {

    /**
     * Pays out the prize to the winning team.
     *
     * @param teamId id of the winning team
     * @param amount the prize amount to pay
     * @return true if the payout was successful, false otherwise
     */
    boolean payoutPrize(String teamId, double amount);
}
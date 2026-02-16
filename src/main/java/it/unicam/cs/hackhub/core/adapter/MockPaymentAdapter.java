package it.unicam.cs.hackhub.core.adapter;

import java.util.logging.Logger;

/**
 * In-memory mock implementation of PaymentAdapter for testing Iteration 3.
 */
public class MockPaymentAdapter implements PaymentAdapter {
    private static final Logger logger = Logger.getLogger(MockPaymentAdapter.class.getName());

    @Override
    public boolean payoutPrize(String teamId, double amount) {
        logger.info("MOCK PAYMENT: Successfully paid out $" + amount + " to Team ID: " + teamId);
        return true; // Simulate success
    }
}
package it.unicam.cs.hackhub.core.factory;

import it.unicam.cs.hackhub.core.adapter.CalendarAdapter;
import it.unicam.cs.hackhub.core.adapter.MockCalendarAdapter;
import it.unicam.cs.hackhub.core.adapter.MockPaymentAdapter;
import it.unicam.cs.hackhub.core.adapter.PaymentAdapter;

import java.util.EnumMap;
import java.util.Map;

/**
 * Factory that returns the correct adapter for a given family and provider
 * type.
 * Uses Map internally; no if/else chains.
 */
public class ExternalAdapterFactory {

    private final Map<ExternalProviderType, PaymentAdapter> paymentAdapters;
    private final Map<ExternalProviderType, CalendarAdapter> calendarAdapters;

    public ExternalAdapterFactory() {
        this.paymentAdapters = new EnumMap<>(ExternalProviderType.class);
        this.calendarAdapters = new EnumMap<>(ExternalProviderType.class);
        paymentAdapters.put(ExternalProviderType.MOCK, new MockPaymentAdapter());
        calendarAdapters.put(ExternalProviderType.MOCK, new MockCalendarAdapter());
        // Future: paymentAdapters.put(ExternalProviderType.STRIPE, new
        // StripePaymentAdapter());
        // Future: calendarAdapters.put(ExternalProviderType.GOOGLE_CALENDAR, new
        // GoogleCalendarAdapter());
    }

    public PaymentAdapter getPaymentAdapter(ExternalProviderType type) {
        return paymentAdapters.get(type);
    }

    public CalendarAdapter getCalendarAdapter(ExternalProviderType type) {
        return calendarAdapters.get(type);
    }

    /**
     * Returns the adapter for the given family and provider type.
     * Strong typing: call getPaymentAdapter or getCalendarAdapter for typed return.
     */
    public Object getAdapter(ExternalSystemFamily family, ExternalProviderType type) {
        Map<ExternalSystemFamily, Map<ExternalProviderType, ?>> byFamily = Map.of(
                ExternalSystemFamily.PAYMENT, paymentAdapters,
                ExternalSystemFamily.CALENDAR, calendarAdapters);
        return byFamily.get(family).get(type);
    }
}

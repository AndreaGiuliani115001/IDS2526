package it.unicam.cs.hackhub.core.factory;

import it.unicam.cs.hackhub.core.adapter.CalendarAdapter;
import it.unicam.cs.hackhub.core.adapter.MockCalendarAdapter;
import it.unicam.cs.hackhub.core.adapter.MockPaymentAdapter;
import it.unicam.cs.hackhub.core.adapter.PaymentAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.EnumMap;
import java.util.Map;

/**
 * Factory that returns the correct adapter for a given family and provider
 * type.
 * Uses Map internally; no if/else chains.
 * Iteration 3: MOCK provider wired via constructor injection.
 */
@Service
@RequiredArgsConstructor
public class ExternalAdapterFactory {

    private final MockPaymentAdapter mockPaymentAdapter;
    private final MockCalendarAdapter mockCalendarAdapter;

    private Map<ExternalProviderType, PaymentAdapter> paymentAdapters;
    private Map<ExternalProviderType, CalendarAdapter> calendarAdapters;

    @PostConstruct
    void init() {
        this.paymentAdapters = new EnumMap<>(ExternalProviderType.class);
        this.paymentAdapters.put(ExternalProviderType.MOCK, mockPaymentAdapter);
        this.calendarAdapters = new EnumMap<>(ExternalProviderType.class);
        this.calendarAdapters.put(ExternalProviderType.MOCK, mockCalendarAdapter);
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

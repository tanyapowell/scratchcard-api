package com.gamesys.tanya.health;

import com.codahale.metrics.health.HealthCheck;
import com.gamesys.tanya.logic.PurchaseDB;

public class TemplateHealthCheck extends HealthCheck {
    private final String version;

    public TemplateHealthCheck(String version) {
        this.version = version;
    }

    @Override
    protected Result check() throws Exception {
        if (PurchaseDB.getTotalCount() == 0) {
            return Result.unhealthy("No purchases in DB! Version: " +
                    this.version);
        }
        return Result.healthy("OK with version: " + this.version +
                ". Purchases count: " + PurchaseDB.getTotalCount());
    }
}
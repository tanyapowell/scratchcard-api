package com.gamesys.tanya;

import com.gamesys.tanya.health.TemplateHealthCheck;
import com.gamesys.tanya.rescources.PurchaseResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class ScratchcardApp extends Application<ScratchcardConfig> {
    public static void main(String[] args) throws Exception {
        new ScratchcardApp().run(args);
    }

    @Override
    public void run(ScratchcardConfig config,
                    Environment env) {
        final PurchaseResource purchaseResource = new PurchaseResource();
        env.jersey().register(purchaseResource);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(config.getVersion());
        env.healthChecks().register("template", healthCheck);
        env.jersey().register(healthCheck);

    }
}
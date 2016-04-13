package com.gamesys.tanya;

import com.gamesys.tanya.health.TemplateHealthCheck;
import com.gamesys.tanya.logic.GameDAO;
import com.gamesys.tanya.logic.PurchaseDAO;
import com.gamesys.tanya.resources.GameResource;
import com.gamesys.tanya.resources.PurchaseResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

import java.sql.SQLException;

public class ScratchcardApp extends Application<ScratchcardConfig> {
    public static void main(String[] args) throws Exception {
        new ScratchcardApp().run(args);
    }

    @Override
    public void run(ScratchcardConfig config,
                    Environment env) throws ClassNotFoundException, SQLException {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(env, config.getDataSourceFactory(), "h2");
        final PurchaseDAO purchaseTable = jdbi.onDemand(PurchaseDAO.class);
        final GameDAO gameTable = jdbi.onDemand(GameDAO.class);

        final PurchaseResource purchaseResource = new PurchaseResource(purchaseTable);
        env.jersey().register(purchaseResource);

        final GameResource gameResource = new GameResource(gameTable);
        env.jersey().register(gameResource);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(config.getVersion());
        env.healthChecks().register("template", healthCheck);
        env.jersey().register(healthCheck);

    }
}
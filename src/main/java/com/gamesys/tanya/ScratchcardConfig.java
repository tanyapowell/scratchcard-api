package com.gamesys.tanya;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ScratchcardConfig extends Configuration{
    @NotEmpty
    private String version;

    public ScratchcardConfig(){
        this.version = getVersion();
    }

    @JsonProperty
    public String getVersion(){
        return version;
    }

    @JsonProperty
    public void setVersion(String version){
        this.version = version;
    }

    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory factory) {
        this.database = factory;
    }

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}

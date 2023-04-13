package io.geextudio.coffeelab.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties (prefix = "greeting")
public class GreetingInfo {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getCoffee() {
        return coffee;
    }

    public void setCoffee(String coffee) {
        this.coffee = coffee;
    }

    private String coffee;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    private String version;

}

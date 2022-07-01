package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
        "classpath:configuration/browserstackConfig.properties"})

public interface BrowserstackConfig extends Config{

    @Key("browserstack.user")
    String browserstackUser();

    @Key("browserstack.key")
    String browserstackKey();

    @Key("app")
    String app();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("browserstack_url")
    String browserstackURL();

    @Key("browserstack_session_json_url")
    String sessionJsonUrl();

}

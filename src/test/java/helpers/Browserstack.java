package helpers;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

    public static String videoUrl(String sessionId) {
        BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);

        String url = format(browserstackConfig.sessionJsonUrl(), sessionId);

        return given()
                .auth().basic(browserstackConfig.browserstackUser(), browserstackConfig.browserstackKey())
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}

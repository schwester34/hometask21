package tests;
import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;

import static io.qameta.allure.Allure.step;

    public class MobileTest extends TestBase {
        @Test
        void searchTest() {
            step("Type search", () -> {
                $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
                $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("tchaikovsky");
            });
            step("Verify content found", () ->
                    $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                            .shouldHave(CollectionCondition.containExactTextsCaseSensitive("Pyotr Ilyich Tchaikovsky"))
            );
        }
    }

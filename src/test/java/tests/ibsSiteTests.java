package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class ibsSiteTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://ibs.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.timeout = 100000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

    @Test
    @Tag("demoqa")
    @DisplayName("Проверка сайта компании-автора вакансии")
    void titleGeneralPageIbsTest() {
        step("Open form", () -> {
            open("https://ibs.ru/");
            $(".top-slide__desc").shouldHave(text("Ключевой технологический партнер лидеров российского бизнеса"));
        });
    }


    @Test
    @Tag("demoqa")
    @DisplayName("Проверка языка сайта")
    void languageMenuPageIbsTest() {
        step("Open for", () -> {
            open("https://ibs.ru/");
            $("a[href='/eng/']").shouldHave(text("Eng")).click();
            $(".top-slide__desc").shouldHave(text("A key technology partner for Russian business leaders"));

        });
    }

    @Test
    @Tag("demoqa")
    @DisplayName("Проверка адреса одного из филиалов компании")
    void contactPageIbsTest() {
        step("Open for", () -> {
            open("https://ibs.ru/");
            $("a[href='/contacts/']").click();
            $(".top--short").shouldHave(text("Офисы группы компаний IBS"));
            $("#bx_651765591_5834").click();
            $(".global").shouldHave(text("Россия, 644046, Омск, ул. Маяковского, 74А\n" +
                    "Телефон: +7 (381) 233-23-08\n" +
                    "\n" +
                    "Подробнее об офисе IBS в Омске"));
        });
    }

    @Test
    @Tag("demoqa")
    @DisplayName("Проверка меню сайта")
    void burgerMenuPageIbsTest() {
        step("Open for", () -> {
            open("https://ibs.ru/");
            $(".header-burger").click();
            $(".navigation-sections").shouldHave(text("Решения и услуги"));
            $(".navigation-sections").shouldHave(text("Отраслевые решения"));
            $(".navigation-sections").shouldHave(text("Проекты"));
            $(".navigation-sections").shouldHave(text("Создано в IBS"));
            $(".navigation-sections").shouldHave(text("Медиацентр"));
            $(".navigation-sections").shouldHave(text("О компании"));

        });
    }

    @Test
    @Tag("demoqa")
    @DisplayName("Проверка наличия строки поиска")
    void searchStringPageIbsTest() {
        step("Open for", () -> {
            open("https://ibs.ru/");
            $(".search-form").$("[placeholder='Поиск по сайту']");

        });
    }

    @Test
    @Tag("demoqa")
    @DisplayName("Проверка наличия адресов социальных сетей")
    void socialContactsPageIbsTest() {
        step("Open for", () -> {
            open("https://ibs.ru/");
            $(".footer-socials").$("a[href='https://vk.com/ru_ibs']");
            $(".footer-socials").$("a[href='https://habr.com/ru/company/ibs/blog/']");
            $(".footer-socials").$("a[href='https://vc.ru/ibs']");
            $(".footer-socials").$("a[href='https://hh.ru/employer/139']");
            $(".footer-socials").$("a[href='https://t.me/ibs_ru']");
            $(".footer-socials").$("a[href='https://www.youtube.com/@ibsru']");

        });
    }

}

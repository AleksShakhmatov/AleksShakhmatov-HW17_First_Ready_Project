package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;
import static io.qameta.allure.Allure.step;

public class HhVacancyTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://omsk.hh.ru";
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
    @DisplayName("Проверка страницы нужной вакансии")
    void checkVacancyHeaderTest() {
        open("/vacancy/94270561");
        $(".bloko-notification__close").click();
        $(".vacancy-title").shouldHave(text("Автотестировщик (Java)"));
        $(".block-employer--jHuyqacEkkrEkSl3Yg3M").shouldHave(text("IBS"));
        //$(".bloko-columns-row").$("data-qa=vacancy-response-link-top");
    }

    @Test
    @Tag("demoqa")
    @DisplayName("Проверка перехода кнопки добавления в избранное")
    void checkVacancyFavouriteButtonTest() {
        open("/vacancy/94270561");
        $(".bloko-notification__close").click();
        $("span .bloko-icon-dynamic").click();
        $(".account-login-tile-content").shouldHave(text("Укажите ваши данные"));
        $(".account-login-tile-subheader").shouldHave(text("Автотестировщик (Java)"));
        $(".bloko-input-text-wrapper").$("placeholder=Электронная почта или телефон");
        $(".account-login-actions").$("type=submit").shouldHave(text("Продолжить"));
    }


    @Test
    @Tag("demoqa")
    @DisplayName("Проверка кнопки Откликнуться")
    void checkVacancyReplayButtonTest() {
        open("/vacancy/94270561");
        $(".bloko-notification__close").click();
        $("data-qa=vacancy-response-link-top").shouldHave(text("Откликнуться")).click();
    }

    @Test
    @Tag("demoqa")
    @DisplayName("Негативная проверка поля обратной связи")
    void checkVacancyReplayFormButtonTest() {
        open("/vacancy/94270561");
        $(".bloko-notification__close").click();
        $("data-qa=vacancy-response-link-top").click();
        $(".bloko-input-text-wrapper").$("placeholder=Номер телефона");
        $("button-wrapper--ScU51CqKyS1jphdiA3Or").$("type=submit").shouldHave(text("Продолжить")).click();
        $(".input-wrapper--v8vH1BYeiyZMN0s4UxlF").shouldHave(text("Поле обязательно для заполнения"));

    }

    @Test
    @Tag("demoqa")
    @DisplayName("Проверка перехода на страницу о компании")
    void checkVacancyCompanyRedirectTest() {
        open("/vacancy/94270561");
        $(".bloko-notification__close").click();
        $(".vacancy-company-details").click();
        $(".tmpl_hh_hero").shouldHave(text("ЗДЕСЬ ТЫ ИМЕЕШЬ ЗНАЧЕНИЕ"));
    }

    @Test
    @Tag("demoqa")
    @DisplayName("Проверка наполнения вакансии по блокам")
    void checkVacancyContentTest() {
        open("/vacancy/94270561");
        $(".bloko-notification__close").click();
        $(".vacancy-branded-user-content").shouldHave(text("Проведение тестирования Web-приложений"));
        $(".vacancy-branded-user-content").shouldHave(text("Разработка тестовой модели (составление и актуализация тест-планов и тест-кейсов)"));
        $(".vacancy-branded-user-content").shouldHave(text("Обнаружение, заведение и отслеживание дефектов в Jira"));
        $(".vacancy-branded-user-content").shouldHave(text("Взаимодействие с разработчиками, аналитиками"));
        $(".vacancy-branded-user-content").shouldHave(text("Автоматизация некоторых тест кейсов"));

        $(".vacancy-branded-user-content").shouldHave(text("Опыт от 1 года в тестировании в целом (последние полгода погружение в афт)"));
        $(".vacancy-branded-user-content").shouldHave(text("Опыт от 6 мес в автоматизации ( Java)"));
        $(".vacancy-branded-user-content").shouldHave(text("Опыт полностью самостоятельной автоматизации тест кейсов на Java"));
        $(".vacancy-branded-user-content").shouldHave(text("Знание REST, опыт тестирования API"));
        $(".vacancy-branded-user-content").shouldHave(text("Знание основ SQL ( уровень простых запросов)"));
        $(".vacancy-branded-user-content").shouldHave(text("Знание и опыт использования xml, json, postman, написание тест-моделей"));
        $(".vacancy-branded-user-content").shouldHave(text("Опыт работы с системами учета дефектов (Jira или аналогами)"));
        $(".vacancy-branded-user-content").shouldHave(text("Опыт от 1 года в тестировании"));

        $(".vacancy-branded-user-content").shouldHave(text("Работа в аккредитованной IT-компании"));
        $(".vacancy-branded-user-content").shouldHave(text("Удаленный формат работы из любого города"));
        $(".vacancy-branded-user-content").shouldHave(text("Стабильный доход на уровне рынка"));
        $(".vacancy-branded-user-content").shouldHave(text("Сильная команда экспертов"));
        $(".vacancy-branded-user-content").shouldHave(text("Личный наставник, помогающий погрузиться в проект"));
        $(".vacancy-branded-user-content").shouldHave(text("Самый передовой стек технологий"));
        $(".vacancy-branded-user-content").shouldHave(text("Обеспечиваем техникой (ноутбук, второй экран, гарнитура)"));
        $(".vacancy-branded-user-content").shouldHave(text("Ежегодная аттестация, по итогам которой формируется индивидуальный карьерный план развития"));
        $(".vacancy-branded-user-content").shouldHave(text("Развитая корпоративная культура: неформальные мероприятия, интеллектуальные игры, собственная Киберлига, возможность заниматься волонтерской деятельностью и благотворительностью, творческие вечера"));

        $(".bloko-columns-row").shouldHave(text("Ключевые навыки"));
        $(".bloko-tag-list").shouldHave(text("Тестирование"));
        $(".bloko-tag-list").shouldHave(text("Java"));
        $(".bloko-tag-list").shouldHave(text("REST API"));
        $(".bloko-tag-list").shouldHave(text("Postman"));

        $(".hUjgTbj___value").shouldHave(text("хорошо"));
    }

    @Test
    @Tag("demoqa")
    @DisplayName("Проверка рейтинга в отзыве")
    void checkVacancyFeebackTest() {
        open("/vacancy/94270561");
        $(".bloko-notification__close").click();
        $(".S6Nu6AV___card").click();
        $(".qoCcUnY___top-line").shouldHave(text("4,7"));
        $(".bloko-modal-close-button").click();
    }

}

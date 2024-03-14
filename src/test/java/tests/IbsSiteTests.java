package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class IbsSiteTests extends TestBase {

     @Test
    @Tag("demo")
    @DisplayName("Проверка сайта компании-автора вакансии")
    void titleGeneralPageIbsTest() {
        step("Открываем сайт", () ->
                open("https://ibs.ru/"));
        step("Проверяем текст на главной странице", () ->
                $(".top-slide__desc")
                        .shouldHave(text("Ключевой технологический партнер лидеров российского бизнеса")));
    }

    @Test
    @Tag("demo")
    @DisplayName("Проверка языка сайта")
    void languageMenuPageIbsTest() {
        step("Открываем сайт", () -> open("https://ibs.ru/"));
        step("Меняем язык сайта", () -> $("a[href='/eng/']").shouldHave(text("Eng")).click());
        step("Проверяем текст на главной странице на аглийском языке", () -> $(".top-slide__desc")
                .shouldHave(text("A key technology partner for Russian business leaders")));
    }

    @Test
    @Tag("demo")
    @DisplayName("Проверка адреса одного из филиалов компании")
    void contactPageIbsTest() {
        step("Открываем сайт", () -> open("https://ibs.ru/"));
        step("Кликаем на контакты", () -> $("a[href='/contacts/']").click());
        step("Проверяем переход на страницу контактов", () -> $(".top--short")
                .shouldHave(text("Офисы группы компаний IBS")));
        step("Кликаем на нужный город (Омск)", () -> $("#bx_651765591_5834").click());
        step("Проверяем контакты выбранного города (Омск)", () ->
                $(".global").shouldHave(text("Россия, 644046, Омск, ул. Маяковского, 74А\n" +
                    "Телефон: +7 (381) 233-23-08\n" +
                    "\n" +
                    "Подробнее об офисе IBS в Омске")));
    }

    @Test
    @Tag("demo")
    @DisplayName("Проверка гамбургер-меню сайта")
    void burgerMenuPageIbsTest() {
        step("Открываем сайт", () -> open("https://ibs.ru/"));
        step("Кликаем на гамбургер-меню", () -> $(".header-burger").click());
        step("Проверяем наличие 'Решения и услуги'", () -> $(".navigation-sections")
                .shouldHave(text("Решения и услуги")));
        step("Проверяем наличие 'Отраслевые решения'", () -> $(".navigation-sections")
                .shouldHave(text("Отраслевые решения")));
        step("Проверяем наличие 'Проекты'", () -> $(".navigation-sections")
                .shouldHave(text("Проекты")));
        step("Проверяем наличие 'Создано в IBS'", () -> $(".navigation-sections")
                .shouldHave(text("Создано в IBS")));
        step("Проверяем наличие 'Медиацентр'", () -> $(".navigation-sections")
                .shouldHave(text("Медиацентр")));
        step("Проверяем наличие 'О компании'", () -> $(".navigation-sections")
                .shouldHave(text("О компании")));
    }

    @Test
    @Tag("demo")
    @DisplayName("Проверка наличия строки поиска")
    void searchStringPageIbsTest() {
        step("Открываем сайт", () -> open("https://ibs.ru/"));
        step("Проверяем наличие поля ввода для поиска", () ->$(".search-form")
                .$("[placeholder='Поиск по сайту']"));
    }

    @Test
    @Tag("demo")
    @DisplayName("Проверка наличия адресов социальных сетей")
    void socialContactsPageIbsTest() {
        step("Открываем сайт", () -> open("https://ibs.ru/"));
        step("Проверяем иконку со ссылкой на Вконтакте", () -> $(".footer-socials")
                .$("a[href='https://vk.com/ru_ibs']"));
        step("Проверяем иконку со ссылкой на Хабр", () -> $(".footer-socials")
                .$("a[href='https://habr.com/ru/company/ibs/blog/']"));
        step("Проверяем иконку со ссылкой на vc", () -> $(".footer-socials")
                .$("a[href='https://vc.ru/ibs']"));
        step("Проверяем иконку со ссылкой на hh", () -> $(".footer-socials")
                .$("a[href='https://hh.ru/employer/139']"));
        step("Проверяем иконку со ссылкой на Telegram", () -> $(".footer-socials")
                .$("a[href='https://t.me/ibs_ru']"));
        step("Проверяем иконку со ссылкой на Youtube", () -> $(".footer-socials")
                .$("a[href='https://www.youtube.com/@ibsru']"));
    }
}

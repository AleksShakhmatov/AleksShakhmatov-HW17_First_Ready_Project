# Проект по автоматизации тестовых сценариев для сайта компании IBS
## Содержание:

- [Используемый стек технологий и инструментов](#-используемый-стек-технологий-и-инструментов)
- [Реализованные проверки](#-реализованные-проверки)
- [Запуск автотестов](#-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

## Используемый стек технологий и инструментов

| Java                                                   | IntelliJ  <br>  Idea                                           | GitHub                                                   | JUnit 5                                                  | Gradle                                                   | Selenide                                                   | Selenoid                                                                        | Allure<br/>Report                                               | Allure <br> TestOps                                              | Jenkins                                                   | Jira                                                   |                                                    Telegram |
|:-------------------------------------------------------|----------------------------------------------------------------|----------------------------------------------------------|----------------------------------------------------------|----------------------------------------------------------|------------------------------------------------------------|---------------------------------------------------------------------------------|-----------------------------------------------------------------|------------------------------------------------------------------|-----------------------------------------------------------|--------------------------------------------------------|------------------------------------------------------------:|
| <img src="media/logo/Java.svg" width="50" height="50"> | <img src="media/logo/Intelij_IDEA.svg" width="50" height="50"> | <img src="media/logo/GitHub.svg" width="50" height="50"> | <img src="media/logo/Junit5.svg" width="50" height="50"> | <img src="media/logo/Gradle.svg" width="50" height="50"> | <img src="media/logo/Selenide.svg" width="50" height="50"> | <img src="media/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a> | <img src="media/logo/Allure_Report.svg" width="50" height="50"> | <img src="media\logo\Allure_TestOps.svg" width="50" height="50"> | <img src="media/logo/Jenkins.svg" width="50" height="50"> | <img src="media/logo/Jira.svg" width="50" height="50"> |  <img src="media\logo\Telegram.svg" width="50" height="50"> |



## Реализованные проверки:
- Проверка открытия нужного сайта
- Проверка языка сайта
- Проверка контактов одного из филиалов компании
- Проверка гамбургер-меню сайта
- Проверка наличия строки поиска
- Проверка наличия адресов социальных сетей


##  Запуск автотестов


### Запуск тестов из терминала локально:
```
gradle clean ibs_test 
```
### Запуск тестов из терминала удаленно (Selenoid): 
```      
gradle clean test -Denv=main
```
### Запуск тестов c параметрами по умолчанию в Jenkins:  
```
clean main ibs_test
```
### Запуск тестов c задаными параметрами в Jenkins:   
```   
clean main ibs_test
-Denvironment=${ENVIRONMENT}
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserBaseUrl=${BASE_URL}
-DbrowserRemoteUrl=${REMOTE_URL}
```
#### Обозначение ключей параметров:
- ENVIRONMENT - окружение, на котором будут запускаться тесты. По умолчанию - prod.     
- BROWSER - браузер, в котором будут запускаться тесты. По умолчанию - Google chrome.          
- BROWSER_VERSION - версия браузера, в котором будут запускаться тесты. По умолчанию - 100.0.
- BROWSER_SIZE - размер окна барузера, в котором будут запускаться тесты. По умолчанию - 1920x1080.    
- BASE_URL - адрес проверяемого ресурса, на котором будут запускаться тесты. По умолчанию - https://ibs.ru/. 
- REMOTE_URL - адрес удаленного сервера, на котором будет запускаться браузер и тесты проверямого ресурса. По умолчанию - https://user1:1234@selenoid.autotests.cloud/wd/hub. 





## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> Сборка в Jenkins

Для запуска сборки необходимо перейти в раздел <code>Собрать с параметрами</code> и нажать кнопку <code>Собрать</code>.
<p align="center">
<img title="Jenkins Build" src="media/screens/jenkins.png">
</p>
После выполнения сборки, в блоке <code>История сборок</code> напротив номера сборки появятся значки <code>Allure Report</code> и <code>Allure TestOps</code>, при клике на которые откроется страница с сформированным отчетом и тестовой документацией соответственно.

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure_Report.svg"> Пример Allure-отчета
### Overview

<p align="center">
<img title="Allure Overview" src="media/screens/allure.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/logo/AllureTestOps.svg"> Интеграция с Allure TestOps

На *Dashboard* в <code>Allure TestOps</code> видна статистика количества тестов: сколько из них добавлены и проходятся вручную, сколько автоматизированы. Новые тесты, а так же результаты прогона приходят по интеграции при каждом запуске сборки.

<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/AllureTestOps.png">
</p>

### Результат выполнения автотеста

<p align="center">
<img title="Test Results in Alure TestOps" src="media/screens/allurResults.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Jira" src="media/logo/Jira.svg"> Интеграция с Jira

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается, какие тест-кейсы были написаны в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="media/screens/Jira.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screens/Bot.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logo/Selenoid.svg"> Видео примера запуска тестов в Selenoid

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста
<p align="center">
  <img title="Selenoid Video" src="media/screens/Video.gif">
</p>
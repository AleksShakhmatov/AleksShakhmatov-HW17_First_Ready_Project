# Проект по автоматизации тестовых сценариев для сайта компании IBS
## Содержание:

- <a href="#stech">Используемый стек технологий и инструментов</a>
- [Реализованные проверки](#cheks)
- [Запуск автотестов](#engine)
- [Сборка в Jenkins](#build)
- [Интеграция с Allure](#report)
- [Интеграция с Allure TestOps](#testops)
- [Интеграция с Jira](#jira)
- [Уведомления в Telegram через бота](#telegram)
- [Видео отчет запуска тестов (Selenoid)](#video)

<a id="stech"></a>
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

Для запуска сборки необходимо перейти в раздел **"Build with Parameters"** и нажать кнопку **"Build"**.
<p align="center">
<img title="Jenkins Build" src="media/screenshots/JenkinsBuild.png"> 
</p>

После выполнения сборки, в блоке **Build History** напротив номера сборки появятся значки <img src="media\logo\Allure_TestOps.svg" width="15" height="15">
и <img src="media\logo\Allure_Report.svg" width="15" height="15"> , при клике на которые откроются соовтетсвтвующие
артефакты.  

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure_Report.svg"> Интеграция с Allure

### Allure отчет

<p align="center">   
<img title="Jenkins Build" src="media/screenshots/Allure Report1.png">    
</p>

### Подробнее   
<p align="center">     
<img title="Jenkins Build" src="media/screenshots/Allure Report2.png">    
</p>       

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/logo/Allure_TestOps.svg"> Интеграция с Allure TestOps

### Allure TestOps отчет

#### Overview

<p align="center">    
<img title="Allure TestOps Overview" src="media/screenshots/Allure_TestOps1.png">
</p>

#### DashBoards
<p align="center">
<img title="Allure TestOps DashBoards" src="media/screenshots/Allure_TestOps3.png">
</p>

#### Подробнее

<p align="center">
<img title="Test Results in Alure TestOps" src="media/screenshots/Allure_TestOps2.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Jira" src="media/logo/Jira.svg"> Интеграция с Jira


<p align="center">
<img title="Jira Task" src="media/screenshots/Jira.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram через бота


<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screenshots/Notifications.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logo/Selenoid.svg"> Видео отчет запуска тестов (Selenoid)

<p align="center">
  <img title="Selenoid Video" src="media/gifs/IBS.gif">
</p>
## `Статус сборки` [![Build status](https://ci.appveyor.com/api/projects/status/bkl5js79rwv53r5s?svg=true)](https://ci.appveyor.com/project/Lognestix/aqa-exercise-1-2-postman-echo)
## В build.gradle добавленна поддержка JUnit-Jupiter и Rest-Assured.
```gradle
plugins {
    id 'java'
}

group 'ru.netology'
version '1.0-SNAPSHOT'

sourceCompatibility = 11

repositories {
    mavenCentral()
}

dependencies {
    testImplementation 'io.rest-assured:rest-assured:4.4.0'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.8.2'
}

test {
    useJUnitPlatform()
}
```
## Авто-тесты находящиеся в этом репозитории.
```Java
package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PostmanEchoApiTest {
    @Test
    void shouldReturnDemoAccounts() {
      //Given - When - Then
      //Предусловия
      given()
          .baseUri("https://postman-echo.com")
              .contentType("text/plain; charset=UTF-8")
              .body("Сейчас я повешу трубку, " + //отправка данных (заголовки и query можно выставлять аналогично)
                      "и потом покажу людям то, что вы хотели скрыть, покажу им мир... " +
                      "без вас, мир без диктата и запретов, мир без границ...")
      //Выполняемые действия
      .when()
          .post("/post")
      //Проверки
      .then()
          .statusCode(200)
              .body("data", equalTo("Сейчас я повешу трубку, " +
                      "и потом покажу людям то, что вы хотели скрыть, покажу им мир... " +
                      "без вас, мир без диктата и запретов, мир без границ..."));
    }
}
```
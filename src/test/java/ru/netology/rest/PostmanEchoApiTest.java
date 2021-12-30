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
              .body("data.value", equalTo("Сейчас я повешу трубку, " +
                      "и потом покажу людям то, что вы хотели скрыть, покажу им мир... " +
                      "без вас, мир без диктата и запретов, мир без границ..."));
    }
}
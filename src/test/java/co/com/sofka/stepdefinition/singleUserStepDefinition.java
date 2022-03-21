package co.com.sofka.stepdefinition;

import co.com.sofka.setUP.singleUserSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;


public class singleUserStepDefinition extends singleUserSetUp {

    public static final Logger LOGGER = Logger.getLogger(singleUserStepDefinition.class);
    private Response response;


    @Given("me encuentro en la pagina web y deseo saber la informacion de un usuario")
    public void me_encuentro_en_la_pagina_web_y_deseo_saber_la_informacion_del_usuario() {
        try {
            generalSetUp();

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }


    }

    @When("solicito el consumo de dicha opcion")
    public void solicito_el_consumo_de_dicha_opcion() {

        try {
            response = when()
                    .get(SINGLE_SOURCE);

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }

    @Then("el sistema debe mostrar un codigo de respuesta exitoso")
    public void el_sistema_debe_mostrar_un_codigo_de_respuesta_exitoso() {
        try {
            response.then()
                    .statusCode(HttpStatus.SC_OK)
                    .body("data.id", equalTo(2));

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }
}

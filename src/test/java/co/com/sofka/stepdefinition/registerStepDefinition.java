package co.com.sofka.stepdefinition;

import co.com.sofka.setUP.registerSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class registerStepDefinition extends registerSetUp {

    public static final Logger LOGER = Logger.getLogger(registerStepDefinition.class);
    private Response response;
    private RequestSpecification resquest;

    @Given("me encuentro en la pagina web e ingreso el correo {string} y la contrasena {string}")
    public void me_encuentro_en_la_pagina_web_e_ingreso_el_correo_y_la_contrasena_pistol(String email, String contrasena) {

        try {
            generalSetUp();
            resquest = given()
                    .contentType(ContentType.JSON)
                    .body(body(email, contrasena));

        }catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }
    @When("el usuario realiza la peticion de registro")
    public void el_usuario_realiza_la_peticion_de_registro() {
        try{
            response = resquest.when()
                    .post(REGISTER_SOURCE);
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Then("el usuario debe ver un codigo de respuesta exitoso")
    public void el_usuario_debe_ver_un_codigo_de_respuesta_exitoso() {

        try{
            response.then()
                    .statusCode(HttpStatus.SC_OK)
                    .body("token", notNullValue());
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }


    }

    private String body(String email, String password){
        return "{\n" +
                "    \"email\": \"" + email + "\",\n" +
                "    \"password\": \"" + password + "\"\n" +
                "}";
    }


}

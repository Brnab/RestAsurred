Feature: Registro de usuario
  yo como posible usuario
  quiero poder registrarme en la pagina web
  para poder realizar transacciones


  Scenario: Registro exitoso en la pagina web
    Given me encuentro en la pagina web e ingreso el correo "eve.holt@reqres.in" y la contrasena "pistol"
    When el usuario realiza la peticion de registro
    Then el usuario debe ver un codigo de respuesta exitoso


Feature: Consulta exitosa de un usuario
  Yo como consumidor de la pagina
  quiero poder consultar la informacion de un usuario
  para podeer verificar su informacion

  Scenario: Consulta exitosa de un usuario
    Given me encuentro en la pagina web y deseo saber la informacion de un usuario
    When solicito el consumo de dicha opcion
    Then el sistema debe mostrar un codigo de respuesta exitoso

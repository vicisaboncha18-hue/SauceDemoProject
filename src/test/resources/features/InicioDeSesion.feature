/*Descripcion: En esta seccion se detallan los escenarios de pruebas que se van a ejecutar*/

@regression @e2e
Feature: 1. Inicio de sesion de usuario
  Background:
  Given El usuario se encuentra en la pagina de login
    @regression
    Scenario: Login exitoso con credenciales validas
  When El usuario ingresa las credenciales correctas
  Then La pagina debe mostrar un mensaje de bienvenida

@regression @e2e
Scenario Outline: 2. Intento de login con credenciales invalidas
  When El usuario ingresa con credenciales invalidas "<username>" y "<password>"
  Then La pagina debe mostrar el mensaje de error "<errorMessage>"

  Examples:
  |username|password|errorMessage|
  |standard_User|wrong_password|Epic sadface: Username and password do not match any user in this service|
  |locked_out_user  |secret_sauce  |Epic sadface: Sorry, this user has been locked out.|


  @regression
  Scenario: 3. El usuario añade un producto al carrito
  Given El usuario ingresa las credenciales correctas
    When El usuario selecciona el producto "Sauce Labs Backpack" y El usuario Agrega el producto al carrito
    Then El producto "Sauce Labs Backpack" debe mostrarse en la pantalla sel carrito.


  @regression @e2e
  Scenario: 4. El usuario finaliza la compra con un producto en el carrito.
    Given El usuario ingresa las credenciales correctas y El usuario Agrega el producto "Sauce Labs Backpack" al carrito
    When El usuario procede a realizar el checkout e ingresa los datos
    Then La compra debe ser confirmada exitosamente

    @regression
  Scenario: 5. El usuario añade varios productos al carrito, elimina uno y procede a la compra
    Given El usuario ingresa las credenciales correctas
    When El usuario selecciona y agrega los siguientes productos al carrito:
      |Sauce Labs Backpack|
      |Sauce Labs Bike Light|
      |Sauce Labs Bolt T-Shirt|
      |Sauce Labs Onesie      |
    And El usuario elimina el producto "Sauce Labs Backpack" del carrito
    And El usuario procede a realizar el checkout e ingresa los datos
    Then La compra debe ser confirmada exitosamente


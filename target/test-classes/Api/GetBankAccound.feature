Feature: Banka Hesaplarını Getirme
  @GmiBankAccounds
  Scenario: Banka Hesaplarını Getirme
    When Set the URL-accounds
    And Type code to send request -accounds
    And  Do Assertion-accounds
Feature: Banka Hesapları

  @GetAccound
  Scenario: Banka Hesaplarını Getirme (Get)
    When Set the URL
    And Type code to send request -accound
    And  Do Assertion-accound

  Scenario: Banka Hesaplarını Degistirme (Get)
    When Set the URL
    And Type code to send request -accound
    And  Do Assertion-accound

    @registerAccount
  Scenario: Sisteme Kayıt OLma (Post)
    When Set the URL-register
    And Type code to send request -register
    And  Do Assertion-register
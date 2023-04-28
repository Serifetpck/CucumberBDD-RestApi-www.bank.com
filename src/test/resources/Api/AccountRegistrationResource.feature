Feature: Hesap Kayıtları
  @GetAccountRegistration
  Scenario: Hesap Kayıt islemleri -Get
    When Set the URL -resource
    And Type code to send request -resource
    And  Do Assertion-resource

  @PostAccountRegistration
  Scenario: Hesap Kayıt Olusturma(post)
    When Set the URL -post
    And Type code to send request -post
    And  Do Assertion-post

  @PutAccountRegistration
  Scenario: Hesap Kayıdını Güncelleme(put)
    When Set the URL -GetAccountPut
    And Type code to send request -GetAccountPut
    And  Do Assertion-GetAccountPut

  @GetAccountRegistrationsFind/{ssn}
  Scenario: Hesap Kayıdını ssn Numarası ile Bulma
    When Set the URL -AccountRegistrationsFind/{ssn}
    And Type code to send request -AccountRegistrationsFind/{ssn}
    And  Do Assertion-AccountRegistrationsFind/{ssn}

Feature: Duruma Göre Hayvanları Listeleme
  @sold
  Scenario: Satılmıs Olan Hayvanları Listeleme
    When Set the URL-sold
    And Type code to send request
    And  Do Assertion

  @pending
  Scenario: Satışta Olan Hayvanları Listeleme
    Given Set the URL-pending
     When Type code to send request-pending
      And Do Assertion-pending

  @available
  Scenario: Sistemde Mevcut Olan Hayvanları Listeleme
    Given Set the URL-available
    When Type code to send request-available
    And Do Assertion-available

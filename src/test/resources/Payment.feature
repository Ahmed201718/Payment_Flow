Feature: Payment_Flow
  Scenario Outline: As a user i want to proceed with the payment process
    Given user open the payment web, user change currency to BHD
    When user change scope to Authenticated Token
    Then user fills card number <card number>
    And user fills card expiry date 01/39
    And user fills card cvv 100
    Then user click on create token button
    And user click on submit
    When user click on response button
    Then print the response
    Examples:
    | card number |
    | 5123450000000008 |
    | 4508750015741019 |
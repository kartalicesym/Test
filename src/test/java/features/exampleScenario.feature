Feature: login

  Scenario Outline: positive logIn test
    Given go to link
    And type username "<username>"
    And type password "<password>"
    When click on the submit button
    Then check the link
    And check the expected message"<expectedMessage>"
    Examples:
      | username | password    | expectedMessage        |
      | student  | Password123 | Logged In Successfully |


  Scenario Outline: negative logIn test
    Given go to link
    And type username "<username>"
    And type password "<password>"
    When click on the submit button
    Then check the error message "<errorMessage>"
    Examples:
      | username      |  | password          |  | errorMessage              |
      | incorrectUser |  | Password123       |  | Your username is invalid! |
      | student       |  | incorrectPassword |  | Your password is invalid! |




@Login
Feature: verifying adactin login details

  Scenario Outline: verifying adactin login with valid Credentials
    Given User is on the adactin page
    When user should login "<userName>","<password>"
    Then User should verify after login success message "Hello navi2707!"

    Examples: 
      | userName | password  |
      | navi2707 | @Navi2707 |

  Scenario Outline: verifying adactin login with valid Credentials
    Given User is on the adactin page
    When user should login "<userName>","<password>" with Enter key
    Then User should verify after login success message "Hello navi2707!"

    Examples: 
      | userName | password  |
      | navi2707 | @Navi2707 |

  Scenario Outline: verifying adactin login with invalid Credentials
    Given User is on the adactin page
    When user should login "<userName>","<password>"
    Then User should verify after login with invalid credentials error message contains "Invalid Login details or Your Password might have expired"

    Examples: 
      | userName | password |
      | new2121  | hgdteus  |

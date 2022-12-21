@SelectHotel
Feature: verifying Adactin Hotel Select hotel

  Scenario Outline: verifying adactin login, search hotel by selecting all fields and select hotel
    Given User is on the adactin page
    When user should login "<userName>","<password>"
    Then User should verify after login success message "Hello navi2707!"
    When User should search hotel "<location>","<hotels>","<roomType>","<roomNumber>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childPerRoom>"
    Then User should verify after click search success message "Select Hotel"
    When User should select a option then click continue button
    Then User should verify after clicking continue success message "Book A Hotel"

    Examples: 
      | userName | password  | location | hotels      | roomType | roomNumber | checkInDate | checkOutDate | adultsPerRoom | childPerRoom |
      | navi2707 | @Navi2707 | Sydney   | Hotel Creek | Double   | 1 - One    | 13/12/2022  | 14/12/2022   | 1 - One       | 1 - One      |

  Scenario Outline: verifying adactin login, search hotel by selecting all fields and select hotel by without clicking any option
    Given User is on the adactin page
    When user should login "<userName>","<password>"
    Then User should verify after login success message "Hello navi2707!"
    When User should search hotel "<location>","<hotels>","<roomType>","<roomNumber>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childPerRoom>"
    Then User should verify after click search success message "Select Hotel"
    When User should click continue button without selecting any option
    Then User should verify after clicking continue error message "Please Select a Hotel"

    Examples: 
      | userName | password  | location | hotels      | roomType | roomNumber | checkInDate | checkOutDate | adultsPerRoom | childPerRoom |
      | navi2707 | @Navi2707 | Sydney   | Hotel Creek | Double   | 1 - One    | 13/12/2022  | 14/12/2022   | 1 - One       | 1 - One      |

@SearchHotel
Feature: verifying Adactin Hotel search hotels

  Scenario Outline: verifying adactin login and search hotel by selecting all fields
    Given User is on the adactin page
    When user should login "<userName>","<password>"
    Then User should verify after login success message "Hello navi2707!"
    When User should search hotel "<location>","<hotels>","<roomType>","<noOfRoom>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childPerRoom>"
    Then User should verify after click search success message "Select Hotel"

    Examples: 
      | userName | password  | location | hotels      | roomType | noOfRoom | checkInDate | checkOutDate | adultsPerRoom | childPerRoom |
      | navi2707 | @Navi2707 | Sydney   | Hotel Creek | Double   | 1 - One  | 13/12/2022  | 14/12/2022   | 1 - One       | 1 - One      |
@abil
  Scenario Outline: verifying adactin login and search hotel by entering only mandatory fields
    Given User is on the adactin page
    When user should login "<userName>","<password>"
    Then User should verify after login success message "Hello navi2707!"
    When User should enter only mandatory fields "<location>","<noOfRoom>","<checkInDate>","<checkOutDate>" and "<adultsPerRoom>"
    Then User should verify after click search success message "Select Hotel"

    Examples: 
      | userName | password  | location | noOfRoom | checkInDate | checkOutDate | adultsPerRoom |
      | navi2707 | @Navi2707 | Sydney   | 1 - One  | 13/12/2022  | 14/12/2022   | 1 - One       |

  Scenario Outline: verifying adactin login and search hotel by invalid checkindate and checkoutdate
    Given User is on the adactin page
    When user should login "<userName>","<password>"
    Then User should verify after login success message "Hello navi2707!"
    When User should search hotel "<location>","<hotels>","<roomType>","<noOfRoom>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childPerRoom>"
    Then User should verify after clicking search button date  error message "Check-In Date shall be before than Check-Out Date" , "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName | password  | location | hotels      | roomType | noOfRoom | checkInDate | checkOutDate | adultsPerRoom | childPerRoom |
      | navi2707 | @Navi2707 | Sydney   | Hotel Creek | Double   | 1 - One  | 13/12/2022  | 14/12/2019   | 1 - One       | 1 - One      |

  Scenario Outline: verifying adactin login and search hotel without entering any fields
    Given User is on the adactin page
    When user should login "<userName>","<password>"
    Then User should verify after login success message "Hello navi2707!"
    When User should not enter any fields
    Then User should verify after click search error message "Please Select a Location"

    Examples: 
      | userName | password  |
      | navi2707 | @Navi2707 |

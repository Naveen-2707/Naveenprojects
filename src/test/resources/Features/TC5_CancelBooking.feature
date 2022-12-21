@CancelBooking
Feature: verifying Adactin Hotel Cancel booking

  Scenario Outline: verifying adactin login, search hotel by selecting all fields, select hotel, book hotel by entering details and cancel generated order Id
    Given User is on the adactin page
    When user should login "<userName>","<password>"
    Then User should verify after login success message "Hello navi2707!"
    When User should search hotel "<location>","<hotels>","<roomType>","<roomNumber>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childPerRoom>"
    Then User should verify after click search success message "Select Hotel"
    When User should select a option then click continue button
    Then User should verify after clicking continue success message "Book A Hotel"
    When User should book hotel "<firstName>","<lastName>" and "<billingAddress>"
      | cardNum          | cardType         | cardMonth | cardYear | cvvNum |
      | 8798765342678465 | VISA             | March     |     2022 |    231 |
      | 9543765342678465 | American Express | July      |     2019 |    341 |
      | 7654765342678465 | Master Card      | August    |     2021 |    331 |
      | 6785765342678465 | VISA             | April     |     2022 |    231 |
    Then User should verify after booking hotel success message "Booking Confirmation" and save the generated order Id
    When User should cancel the generated order Id
    Then User should verify after cancelling order Id success message "The booking has been cancelled."

    Examples: 
      | userName | password  | location | hotels      | roomType | roomNumber | checkInDate | checkOutDate | adultsPerRoom | childPerRoom | firstName | lastName | billingAddress |
      | navi2707 | @Navi2707 | Sydney   | Hotel Creek | Double   | 1 - One    | 13/12/2022  | 14/12/2022   | 1 - One       | 1 - One      | Naveen    | kumar    | Chennai        |

  Scenario Outline: verifying adactin login and cancel the existing order Id
    Given User is on the adactin page
    When user should login "<userName>","<password>"
    Then User should verify after login success message "Hello navi2707!"
    When User should cancel the existing order Id "<orderId>"
    Then User should verify after cancelling order Id success message "The booking has been cancelled."

    Examples: 
      | userName | password  | orderId    |
      | navi2707 | @Navi2707 | PYW6J8R5EX |

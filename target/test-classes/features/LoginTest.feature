@Sprint56
Feature: login

  @joe1030
  Scenario: valid admin login
    When user is logged in with valid admin credentials
    Then admin user is successfully logged in
    Then user verifies the dashboard options available on the page
    |Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|

  Scenario: valid ess login

    When user is logged in with valid ess credentials
    Then ess user is successfully logged in

  @smoke52 @regression46 @smoke767
  Scenario: valid username but invalid password
    When user is logged in with valid login but invalid password
    Then user sees invalid credentials page on login page

   Scenario: valid username and invalid password2
    When user is logged in with valid login but invalid password2
      | userName | password    | errorMessage             |
      | Admin    | Hum@n       | Invalid credentials      |
      | Admin1   | Hum@nhrm123 | Invalid credentials      |
   #   | Admin    |             | Password cannot be empty |
   #   |          | Hum@nhrm123 | Loginbhj                 |

@trojan
  Scenario Outline: valid username and invalid password3
    When user is logged in with valid login "<userName>" but invalid "<password>" passwordgfh "<errorMessage>"
    Examples:
      | userName | password    | errorMessage             |
      | Admin    | Hum@n       | Invalid credentials      |
      | Admin1   | Hum@nhrm123 | Invalid credentials      |
      | Admin    |             | Password cannot be empty |
      |          | Hum@nhrm123 | Username cannot be empty                 |


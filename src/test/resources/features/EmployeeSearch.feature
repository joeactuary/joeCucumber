Feature: Search employee

  @RunJoe
  Scenario: search employee by id

    When user is logged in with valid admin credentials
    And user navigates to employee list page
    And user enters valid employee id
    And click on search button
    Then user sees employee information is displayed

  @Fdf
  Scenario: search employee by name

    When user is logged in with valid admin credentials
    And user navigates to employee list page
    And user enters valid employee name
    And click on search button
    Then user sees employee information is displayed

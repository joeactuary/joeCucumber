@10/27
Feature: Add Employee

  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on Add Employee button


  Scenario: first scenario of adding the employee
    And user enters firstname middlename and lastname
    And user clicks on save button
    Then employee added successfully
    Then employee is deleted


  Scenario: second scenario of adding the employee
    And user enters firstname middlename and lastname
    And user deletes employee id
    And user clicks on save button
    Then employee added successfully
    Then employee is deleted


  Scenario: third scenario of adding the employee
    And user enters firstname middlename and lastname
    And user supplies picture
    And user selects checkbox
    And user enters username password and confirmpassword
    And user clicks on save button
    Then employee added successfully
    Then employee is deleted

@dbQuery
  Scenario: adding an employee from feature file
   //  And user enters "Clint" "A." and "Hawkeye"
   //  And user clicks on save button
   //  Then employee added successfully
     Then query HRMS database "Clint" "A." and "Hawkeye"
    ## Then employee is deleted


  Scenario Outline: adding an employee from feature file2
    And user enters "<firstName>" "<middleName>" and "<lastName>"
    And user clicks on save button
    Then employee added successfully
    Then employee is deleted
    Examples:
      | firstName | middleName | lastName  |
      | Stephen   | A.        | Slotzky   |
      | Alex      | A.         | Klumonsky |
      | Paul      | A.         | Plotzky   |

  @runJoe
    Scenario: adding employees using data table
      When user adds multiple employees and verifies added successfully
        | FirstName | MiddleName | LastName  |
        | Stephen   | A.        | Slotzky   |
        | Alex      | A.         | Klumonsky |
        | Paul      | A.         | Plotzky   |

    @qw1030
    Scenario: adding an employee from excel file
  When user adds employees from "EmployeeData" excelsheet

  @tryThis
  Scenario: Adding employee and validating in DataBase
    When user looks at all job titles
    And verify job titles are matched in ui and d








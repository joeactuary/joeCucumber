@apijoe
Feature: Syntax HRM API Workflow

  Background:
   Given token is generated

  Scenario: Creating an employee
    Given a request is prepared for creating an employee "Abel", "Kputz", "Shlemkin", "M", "2072-12-06", "Employee", "API Tester"
    ##Given a request is prepared for creating an employee
    When a POST call is made to create an employee
    Then the status code is 201
    And the employee created contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable to be used for other calls

    Scenario: Retrieving created employee

      Given a request is prepared for getting an employee
      When a Get call is made to retrieve an employee
      Then the status code is 200
      And the retrieved employee ID "employee.employee_id" matches the stored employee id
      And the retrieved data at "employee" object matches the data used to create an employee with employee id "employee.employee_id"
        |emp_firstname|emp_lastname|emp_middle_name|emp_birthday|emp_gender|emp_job_title|emp_status|
        |Abel   |Kputz      |Shlemkin      |2072-12-06  |Male         |API Tester   |Employee  |


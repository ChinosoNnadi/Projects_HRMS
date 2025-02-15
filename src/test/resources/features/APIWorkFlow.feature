Feature: Syntax API workflow feature

  Background:
    Given a JWT is generated

  @api
  Scenario: create an employee via API
    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for this request is 201
    And the employee id "Employee.employee_id" is stored as global variable for other request

  @api
  Scenario: get the created employee
    Given a request is prepared to get the created employee
    When a GET call is made to get the employee
    Then the status code for this employee is 200
    And the global employee id must match with "employee.employee_id" key
    And the retrieved data at "employee" object matches the data used to create employee
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
      |Chinoso      |Nnadi       |Modestus      |Male      |1991-05-11  |active    |QA           |

  @json
  Scenario: Creating the employee using json paylaod
    Given a request is prepared for creating an employee via json payload
    When a POST call is made to create an employee
    Then the status code for this request is 201
    And the employee id "Employee.employee_id" is stored as global variable for other request
    And the response body contains "Message" key and value "Employee Created"

  @jsondynamic  @update1
  Scenario: Creating the employee using json paylaod
    Given a request is prepared for creating an employee with dynamic data "Chinoso" , "Nnadi" , "Modestus" , "M" , "1991-05-11" , "active" , "QA"
    When a POST call is made to create an employee
    Then the status code for this request is 201
    And the employee id "Employee.employee_id" is stored as global variable for other request
    And the response body contains "Message" key and value "Employee Created"

  @jobTitle
  Scenario: Get all job titles
    Given a request is prepared for getting all job titles
      When a GET call is made to get all the job titles
      Then the status code for the request is 200
      And the job ID "Jobs.id" and jobs "Jobs.job" is stored for other job titles

  @update
  Scenario:Updating the employee
    Given a request is prepared to update an employee in HRMS system
    When a PUT call is made to update the employee
    Then the status code for updating the employee is 200


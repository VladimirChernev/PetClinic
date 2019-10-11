Feature: PetClinic app test case feature


  Background: I am at PetClinic Home page

  Scenario: Find all owners
    Given I get to PetClinic Find owners page
    When I click button Find Owner
    Then List of all owners appear

  Scenario: Add new owner
    Given I get to PetClinic Find owners page
    When I click button Add Owner
    And Fill all fields with valid info
    And Click button Add Owner
    Then The new owner is created
    And Info for the owner is displayed

  Scenario Outline: Find an owner "name"
    Given I get to PetClinic Find owners page
    When I type last "<name>" of owner in the field and click button Find owner
    Then New page with the correct owner's info is diplayed
    Examples:
      | name  |
      | Davis |
      | Black |

  Scenario: Add new pet to an owner
    Given I get to PetClinic Find owners page
    And I type last "name" of owner in the field and click button Find owner
    When I click button Add New Pet
    And Fill out all the required fields with valid info and click button Add Pet
    Then New pet should be added to the owner
    And Pet's info page is displayed

  Scenario: Edit owner's info
    Given I get to PetClinic Find owners page
    And Click on button Find Owner
    And Click on owner's "name"
    And Click on button edit owner
    When I change info in a field with valid data and click update owner button
    Then New page is displayed with the changed owner's info

  Scenario: Edit owner's pet info
    Given I get to PetClinic Find owners page
    And Click on button Find Owner
    And Click on owner's "name"
    And Click on the link Edit Pet under the Pets and Visits section
    When I change info in a field with valid data and click update pet button
    Then New page is displayed with the changed pet's info

  Scenario: Add new visit for a pet
    Given I get to PetClinic Find owners page
    And Click on button Find Owner
    And Click on owner's "name"
    And Click on the link Add Visit under the Pets and Visits section
    When I add valid data to all fields and click add visit button
    Then New page is displayed with the added visit

  Scenario: Find the list with all Veterinarians
    When I click on the Veterinarians button
    Then New page is displayed where name and specialty for all Veterinarians is shown

  Scenario: Validation of the field First Name in add new owner page for unfilled data
    Given I get to PetClinic Find owners page
    And Click on Add Owner button
    When I fill all fields except First Name and click Add owner
    Then New page is displayed where under the unfilled field a message should appear 'must not be empty'

  Scenario: Validation of the field Last Name in add new owner page for unfilled data
    Given I get to PetClinic Find owners page
    And Click on Add Owner button
    When I fill all fields except Last Name and click Add owner
    Then New page is displayed where under the unfilled field a message should appear 'must not be empty'

  Scenario: Validation of the field Address in add new owner page for unfilled data
    Given I get to PetClinic Find owners page
    And Click on Add Owner button
    When I fill all fields except Address and click Add owner
    Then New page is displayed where under the unfilled field a message should appear 'must not be empty'

  Scenario: Validation of the field City in add new owner page for unfilled data
    Given I get to PetClinic Find owners page
    And Click on Add Owner button
    When I fill all fields except City and click Add owner
    Then New page is displayed where under the unfilled field a message should appear 'must not be empty'

  Scenario: Validation of the field Telephone in add new owner page for unfilled data
    Given I get to PetClinic Find owners page
    And Click on Add Owner button
    When I fill all fields except Telephone and click Add owner
    Then New page is displayed where under the unfilled field a message should appear 'must not be empty'

  Scenario: Validation of the field First Name in add new owner page for invalid data
    Given I get to PetClinic Find owners page
    And Click on Add Owner button
    When I fill only field First Name with "invalid data"and click Add owner
    Then New page is displayed where under the field an error message should appear

  Scenario: Validation of the field Last Name in add new owner page for invalid data
    Given I get to PetClinic Find owners page
    And Click on Add Owner button
    When I fill only field Last Name with "invalid data"and click Add owner
    Then New page is displayed where under the field an error message should appear

  Scenario: Validation of the field Address in add new owner page for invalid data
    Given I get to PetClinic Find owners page
    And Click on Add Owner button
    When I fill only field Address with "invalid data"and click Add owner
    Then New page is displayed where under the field an error message should appear

  Scenario: Validation of the field City in add new owner page for invalid data
    Given I get to PetClinic Find owners page
    And Click on Add Owner button
    When I fill only field City with "invalid data"and click Add owner
    Then New page is displayed where under the field an error message should appear

  Scenario Outline: Validation of the field Telephone in add new owner page for invalid data
    Given I get to PetClinic Find owners page
    And Click on Add Owner button
    When I fill only field Telephone with "<invalid data>"and click Add owner
    Then New page is displayed where under the field an error message 'numeric value out of bounds' should appear
    Examples:
      |invalid data|
      |ehdut|
      |>%()|

  Scenario: Can return to Home page successfully
    Given I am at Veterinarians page
    When I click on button Home in the breadcrumb
    Then Home page of PetClinic app is displayed

#Author: Rakesh S

@ft
Feature: Functional Test feature

  @positive
  Scenario: Create a transaction
    Given API is ready
    When  I send a POST request to API with source account number as <source> , destination account number as <dest> and amount as <amount>
    Then verify the Status as <status>

 Examples: 
 
 			| source | dest   | amount | status  |
      | 1001   | 1002   |   10.0 | success |
      | 1001   | 1002   |  190.0 | error   |
      | 1001   | 1008   |   10.0 | error   |
      | 1008   | 1002   |   10.0 | error   |
      | 1001   | 1001   |   10.0 | error   |
      | 1001   | 1002   |  -10.0 | error   |

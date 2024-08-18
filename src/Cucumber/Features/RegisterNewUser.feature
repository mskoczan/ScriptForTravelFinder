Feature: Register new user

  Scenario Outline: Register new user with valid data

    Given Browser opened Main Page https://www.wakacyjnipiraci.pl/
    When User clicked button Profile
    And User Clicked button 'Zarejestruj sie' in pop-up
    And User filled out valid <email> and <password>
    And Screenshot is taken
    And User confirmed registration (if applicable)
    Then User account is successfully created
    And Browser is closed

    Examples:
      | email                   | password                                    |
      | john.smith@email.com    | !p@SSw0rd2022 (valid password)              |
      | invalid_email@          | !p@SSw0rd2022 (invalid email format)        |
      | john.smith@email.com | !p@SSw0rd2022 (existing email)              |
      | short_password          | abc123 (password too short)                 |
#      password requires 8 characters, including a special character, number, uppercase letter and lowercase letter
  Scenario Outline: Register new user with invalid password

    Given Browser opened Main Page https://www.wakacyjnipiraci.pl/
    When User clicked button Profile
    And User Clicked button Zarejestruj sie in pop-up
    And User filled out valid <email> and <invalid_password>
    Then An error message is displayed regarding password complexity
    And User account is not created
    And Browser is closed

    Examples:
      | email                    | invalid_password                            |
      | john.smith@email.com     | password123 (missing special character)     |
      | john.smith@email.com     | password!@# (missing uppercase letter)      |
#      password requires 8 characters, including a special character, number, uppercase letter and lowercase letter

# First version
#  Feature: Register new user

 #   Scenario Outline: Register new user account on https://www.wakacyjnipiraci.pl
    
  #    Given Browser opened Main Page https://www.wakacyjnipiraci.pl/
  #    When User clicked button Profile
  #   And User Clicked button Zarejestruj sie in pop-up
  #   And User filled out valid <email> and <password>
  #    And Screenshot is taken
  #    And User confirmed via clicked button Zarejestruj się
  #   Then Browser is closed
  #    Examples:
  #      |email              |password      |
  #      |john.smith@email.com |!p@SSw0rd2022 |

  #      password requires 8 characters, including a special character, number, uppercase letter and lowercase letter

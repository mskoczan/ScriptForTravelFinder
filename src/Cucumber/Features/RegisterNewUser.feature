  Feature: Register new user

    Scenario Outline: Register new user account on https://www.wakacyjnipiraci.pl
      Given Browser opened Main Page https://www.wakacyjnipiraci.pl/
      When User clicked button Profile
      And User Clicked button Zarejestruj sie in pop-up
      And User filled out valid <email> and <password>
      And Screenshot is taken
#      And User confirmed via clicked button Zarejestruj się
      Then Browser is closed
      Examples:
        |email              |password      |
        |john.smith@email.com |!p@SSw0rd2022 |

#      password requires 8 characters, including a special character, number, uppercase letter and lowercase letter
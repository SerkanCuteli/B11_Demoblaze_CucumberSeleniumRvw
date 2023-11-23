Feature: LoginTest
  #Agile story : As a user, I should be able to login with valid credentials
  Background:
    Given The user navigates to web site

  Scenario: Positive Login Test 1 without parameter
    When The user cliks login button and enters valid credentials
    Then The user verifies welcome message


  Scenario: Positive Login Test 2 with parameter
    When The user cliks on login button and enters "salih" and "qayxsw159753" credentials
    Then The user verfies welcome "salih" message


  Scenario Outline: Positive Login Test 3 with scenario outline
    When The user cliks on login button and enters "<username>" and "<password>" credentials
    Then The user verfies welcome "<username>" message
    Examples:
      | username | password     |
      | salih    | qayxsw159753 |


  Scenario Outline: Positive Login Test 4 with scenario outline and data Table
    When The user cliks on the login button and enters following credentials
      | username | <user_username> |
      | password | <user_password> |
    Then The user verfies welcome "<user_username>" message
    Examples:
      | user_username | user_password |
      | salih         | qayxsw159753  |
    #nagative login test

  Scenario Outline: Negative Login Test 5 with scenario outline and data Table
    When The user cliks on the login button and enters following credentials
      | username | <user_username> |
      | password | <user_password> |
    Then The user verifies "<user_message>" message
    Examples:
      | user_username | user_password  | user_message    |
      | sali          | qayxsw159753   | Wrong password. |
      | salih         | qayxsw15975345 | Wrong password. |

     #nagative login test with Fatih Hoca

  Scenario Outline: Negative Login Test 5 with scenario outline
    When The user cliks on login button and enters "<invalidusername>" and "<invalidpassword>" credentials
    Then The user verifies invalid access message "<message>"
    Examples:
      | invalidusername | invalidpassword  | message |
      | salih           | qayxsw15975345-- | Wrong password. |
      | salih           |                  | Please fill out Username and Password. |
      | salih--         | qayxsw15975345   | User does not exist. |
      |                 | qayxsw15975345   | Please fill out Username and Password. |
      |                 |                  | Please fill out Username and Password. |





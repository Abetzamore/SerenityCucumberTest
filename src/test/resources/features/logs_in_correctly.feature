Feature: LogIn
    Background: Test Log In

    Scenario Outline: User can Log In correctly
      Given Ariadna open my store site
      When she go to my account section
      Then she wait for login to be loaded

      When she logs in with user "<username>" and password "<password>"
      Then she should see log in status correctly

      Examples:
      | username             | password  |
      | abetzamore@gmail.com | amoreno09 |

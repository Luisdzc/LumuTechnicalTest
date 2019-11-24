Feature: Count characters in a given text

  Scenario: Count characters in a text without white spaces
    Given the user is in the word count page
    When the user writes the text "123456789101112"
    Then the right side panel of the page should display "15" characters
   
  Scenario: Count character in a text with white spaces
    Given the user is in the word count page
    When the user writes the text "123 456 789"
    Then the right side panel of the page should display "11" characters

  Scenario: Count character in a text with only white spaces
    Given the user is in the word count page
    When the user writes the text "     "
    Then the right side panel of the page should display "5" characters


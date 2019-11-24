Feature: Count words in a given text

  Scenario: Text without special characters
    Given the user is in the word count page
    When the user writes the text "This is just and example for word counter page"
    Then the right side panel of the page should display "9" words

  Scenario: Text with only special characters that not represent a word
    Given the user is in the word count page
    When the user writes the text "$%!$ $!#$$!#$! %%/$"
    Then the right side panel of the page should display "0" words

  Scenario: Text with only special characters that should not represent a word
    Given the user is in the word count page
    When the user writes the text "&& & & &&& &"
    Then the right side panel of the page should display "0" words

  Scenario: Text with simple text and special characters
    Given the user is in the word count page
    When the user writes the text "!#$hola o! $#%R#%"
    Then the right side panel of the page should display "3" words
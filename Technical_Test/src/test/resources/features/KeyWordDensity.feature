Feature: Keyword density in a given text
  
  Scenario: Identify the 3 most repeated words in a given text
    Given the user is in the word count page
    When the user writes the text "test house car house car dog car dog car house"
    Then the keyword density panel should have in the first three positions the words "car", "house","dog"

  Scenario: Keyword density in a text without words
    Given the user is in the word count page
    When the user writes the text "to to at at on in on in to"
    Then the keyword density panel should be empty

  Scenario: Identify the 3 most repeated words in a given text with majority of prepositions
    Given the user is in the word count page
    When the user writes the text "test to house to car on house in in in car dog car to dog car house to"
    Then the keyword density panel should have in the first three positions the words "car", "house","dog"
Feature: Test LibraryItem Class

  Scenario: Book is Harry Potter
    Given Harry Potter is the book title
    When I check if the book is Harry Potter
    Then The title should be "correct"

  Scenario: Book is not Harry Potter
    Given Lord of the rings is the book title
    When I check if the book is Harry Potter
    Then The title should be "incorrect"
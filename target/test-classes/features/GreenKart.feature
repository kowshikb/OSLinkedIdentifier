Feature: Automate Search option in GreenKart

  @tag1
  Scenario Outline: search item in greenkart and top deals<Name>
    Given User is on greenkart landing page
    When search product with short name <Name> and extract actual name
    Then search with short name <Name> in offer page to check product exist

    Examples: 
      | Name |
      | c    |
      | b    |
      
      

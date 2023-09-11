Feature: Validate dataHub homepage

  @smoke
  Scenario: Verify header is the landingPage
    Given User is on dataHub LandingPage and accept cookies
    When Following elements are there in landingpage
      | API Dashboard |
      | Download      |
      | Docs          |
      | Support       |
      | Pricing       |
    Then click on each element

  @smoke
  Scenario: verify specific items/objects are loaded onto the page.
    Given User is on dataHub LandingPage and accept cookies
    When User clicks on API Dashboard
    Then User lands on Api Dashboard page and validate any element in this page

  @smoke
  Scenario: verify specific items/objects are loaded onto the page.
    Given User is on dataHub LandingPage and accept cookies
    When User clicks on Download
    Then User lands on Download page and validate any element in this page

  @smoke
  Scenario: verify specific items/objects are loaded onto the page.
    Given User is on dataHub LandingPage and accept cookies
    When User clicks on Docs
    Then User lands on Docs page and print all element in the side panel

  @smoke
  Scenario: verify specific items/objects are loaded onto the page.
    Given User is on dataHub LandingPage and accept cookies
    When User clicks on SupportPrice
    Then User lands on supportPrice page and validate any element in this page

  @smoke
  Scenario: verify specific items/objects are loaded onto the page.
    Given User is on dataHub LandingPage and accept cookies
    When User clicks on pricing
    Then User lands on pricing page and validate any element in this page

  @smoke
  Scenario: verify the links shown when you expand the listed sections OS Downloads API
    Given User is on dataHub LandingPage and accept cookies
    When User clicks on Docs
    And click on OS Downloads API
    Then verify links shown after expanding OS Downloads API

  @smoke
  Scenario: verify the links shown when you expand the listed sections OS Features API
    Given User is on dataHub LandingPage and accept cookies
    When User clicks on Docs
    And click on OS Features API
    Then verify links shown after expanding OS Features API

  @smoke
  Scenario: verify the links shown when you expand the listed sections OS Linked Identifiers API
    Given User is on dataHub LandingPage and accept cookies
    When User clicks on Docs
    And click on OS Linked Identifiers API
    Then verify links shown after expanding OS Linked Identifiers API

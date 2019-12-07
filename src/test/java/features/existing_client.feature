@client
Feature: Existing clients

  Scenario: 'Articles to read block' displayed correctly and every section has correct number of articles
    Given login page is opened
    And log in to application with authentication token
    When existing client page is opened
    Then Article to read block has correct sections
    And click on Advertisers section in Articles to read block
    And Advertisers section has 2 articles in Articles to read block
    And click on Publishers section in Articles to read block
    And Publishers section has 2 articles in Articles to read block
    And click on Top level clients section in Articles to read block
    And Top level clients section has 10 articles in Articles to read block

  Scenario: Move to saved
    Given login page is opened
    And log in to application with authentication token
    When click on Advertisers section in Articles to read block
    And click on Adidas article
    And Adidas card is opened
    And 'Move to saved' button is disabled
    And scroll down in text area
    And 'Move to saved' button is enabled
    And click on Move to saved button
    Then Saved articles block has Advertisers section
    And Advertisers section has 1 articles in Articles to read block
    And check that cookies saved has value Adidas
    And click on Advertisers section in Saved articles block
    And Advertisers section has 1 articles in Saved articles block

  Scenario: Remove from saved
    Given login page is opened
    And log in to application with authentication token
    And click on Publishers section in Articles to read block
    And click on Youtube article
    And Youtube card is opened
    And scroll down in text area
    And click on Move to saved button
    And Saved articles block has Publishers section
    And Publishers section has 1 articles in Articles to read block
    And check that cookies saved has value Youtube
    And click on Publishers section in Saved articles block
    And Publishers section has 1 articles in Saved articles block
    And click on Removed from saved button
    Then Publishers section has 2 articles in Articles to read block
    And Saved articles block disappeared
    And check that cookies saved has been removed

  Scenario: Change image size by slider
    Given login page is opened
    And log in to application with authentication token
    When click on Publishers section in Articles to read block
    And click on Youtube article
    And Youtube card is opened
    And check image is resized with slider

  Scenario: Download text description
    Given login page is opened
    And log in to application with authentication token
    When click on Advertisers section in Articles to read block
    And click on Adidas article
    And Adidas card is opened
    And click on Download info button
    Then description is downloaded
    And file contains correct text

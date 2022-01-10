@Search
  Feature: As user I want to search an article

    Scenario: Search an article on the site
      Given user is on home page
      When user do a research on the article
      Then he should be on the result page matching with research
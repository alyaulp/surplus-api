@Surplus
Feature: Feature Surplus
    Scenario: Post create new
      Given Post create new with request body
      When  Send Post create new
      Then Status code should be 201 Created
      And Validate resource json schema

    Scenario Outline: Post create with body invalid data
      Given Post create with body title "<title>" body "<body>" userID <userID>
      When Send Post create new
      Then Status code should be 400 Bad Request
      Examples:
        | title                                                                                                                         | body       | userID |
        |                                                                                                                               | motorcycle | 12     |
        | recommendation                                                                                                                |            | 12     |
        | recommendation                                                                                                                | motorcycle | 0      |
        | long Nameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee titleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee | motorcycle | 12     |
        | a                                                                                                                             | motorcycle | 12     |
        | recommendation                                                                                                                | a          | 12     |
        | N@S1 B4K4R*$#                                                                                                                 | motorcycle | 12     |

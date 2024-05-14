@Contoh
Feature: Feature Contoh
    Scenario: Post create new contoh
      Given Post create new with request body contoh
      When  Send Post create new contoh
      Then Status code should be Created contoh
      And Validate resource json schema contoh

#    Scenario Outline: Post create with body invalid data
#      Given Post create with body title "<title>" body "<body>" userID <userID>
#      When Send Post create new
#      Then Status code should be 400 Bad Request
#      Examples:
#        | title                                                                                                                         | body       | userID |
#        |                                                                                                                               | motorcycle | 12     |
#        | recommendation                                                                                                                |            | 12     |
#        | recommendation                                                                                                                | motorcycle | 0      |
#        | long Nameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee titleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee | motorcycle | 12     |
#        | a                                                                                                                             | motorcycle | 12     |
#        | recommendation                                                                                                                | a          | 12     |
#        | N@S1 B4K4R*$#                                                                                                                 | motorcycle | 12     |

@Surplus
Feature: Feature Surplus
   Scenario: Get List All
     Given Get list all
     When Send get list all
     Then Status code should be 200 OK
     And Validate Response Json Schema

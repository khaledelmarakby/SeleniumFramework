Feature: user registration 
I want to check that the user can register in our E-commerce website.

Scenario Outline: user registration 

Given the user in the home page 

When I click on the register link 
And  I enter "<firstname>" , "<lastname>" , "<email>" , "<password>"
Then The registration page is displayed successfully 
 
 Examples:
 
 | firstname | lastname | email |password |
 | khaled | mohamed | khaled111@test.com | 12345678 |
 | ahmed | user | ahmed111@user.com | 1234567 |
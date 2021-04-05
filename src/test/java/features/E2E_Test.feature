Feature: Automated end to end test 
 Purpose: to test end to end integration test 

Scenario Outline:  the user can choose an item and make an online order for this item 

Given The home page is opened 
When  the user search for "<productname>"
And add the product to cart  
And enters all the required details on checkout page and make an order 
Then the user can see invoice and download it 

Examples:
 | productname |
 | mac |
@tag
Feature: User Requests

  @User_Create_user
  Scenario Outline: Add user with all fields and valid values
    Given Admin creates POST request with all fields for "<testcase>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 201 Created Status with response body

    Examples: 
      | testcase |
      | Valid    |
#
  #@User_Get_all_users
  #Scenario: Check if admin able to retrieve all Users with valid endpoint
  #Given Admin creates GET Request
  #When Admin sends HTTPS Request with valid endpoint
  #Then Admin receives 200 OK Status with response body
  #@User_Get_User_byUserId
  #Scenario: Check if admin able to retrieve a User with valid User ID
    #Given Admin creates GET Request with valid UserId
    #When Admin sends HTTPS Request with a valid endpoint
    #Then Admin receives 200 OK Status with response body
#
  #@User_Update_User_byUserId
  #Scenario Outline: Check if admin able to Update a User with valid User ID
    #Given Admin creates PUT Request with valid UserId for "<testcase>"
    #When Admin sends PUT Request with a valid endpoint
    #Then Admin receives 200 OK Status with response body
#
    #Examples: 
      #| testcase    |
      #| Updatevalid |
#
  #@User_Delete_User_byUserId
  #Scenario: Check if admin able to delete a User with valid User ID
    #Given Admin creates Delete Request with valid UserId
    #When Admin sends DELETE Request with a valid endpoint
    #Then Admin receives 200 OK Status with response body
#
  #@User_CreateUser_SplchrFname
  #Scenario Outline: Check If admin able to create user with splchr in firstname
    #Given Admin creates POST request for "<testcase>"
    #When Admin sends HTTPS Request with endpoint
    #Then Admin receives 400 Bad Request with response body
#
    #Examples: 
      #| testcase     |
      #| Splchr Fname |
#
  #@User_CreateUser_ExistContact
  #Scenario Outline: Check If admin able to create user with with Existing contact
    #Given Admin creates POST request for "<testcase>"
    #When Admin sends HTTPS Request with endpoint
    #Then Admin receives 409 Conflict with response body
#
    #Examples: 
      #| testcase        |
      #| Existingcontact |
#
  #@User_Create_user
  #Scenario Outline: Add user with all fields and valid values
    #Given Admin creates POST request with all fields for "<testcase>"
    #When Admin sends HTTPS Request with endpoint
    #Then Admin receives 201 Created Status with response body
#
    #Examples: 
      #| testcase |
      #| Valid    |
#
  #@User_UpdateUser_Invaliddata
  #Scenario Outline: Check If admin able to update user with Invalid data
    #Given Admin creates PUT Request with valid UserId for "<testcase>"
    #When Admin sends PUT Request with a valid endpoint
    #Then Admin receives 400 Bad Request with response body
#
    #Examples: 
      #| testcase      |
      #| UpdateInvalid |
#
      #
    #@User_UpdateUser_Existingemail
  #Scenario Outline: Check If admin able to update user with Existing email
    #Given Admin creates PUT Request with valid UserId for "<testcase>"
    #When Admin sends PUT Request with a valid endpoint
    #Then Admin receives 409 Conflict with response body
#
    #Examples: 
      #| testcase      |
      #| UpdateExistingEmail |
      
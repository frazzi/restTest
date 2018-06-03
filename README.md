# restTest

This is a springboot app with an embedded H2 database.
The DB is cleared down and rebuilt with test data on startup.

These are the endpoint that are being services.  

Tested using POSTMAN browser extension alons with Integration and unit test.

1) To get all the accounts in the DB
Issue HTTP verb GET request to -> http://localhost:8080/account-project/rest/account/json
You should get back an array of three user account.

2) To add a new account 
Issue a POST request to -> http://localhost:8080/account-project/rest/account/json 
The body of the payload should look like below, and will be ecoded as Json type
{
	"accountNumber": "12347",
	"firstName": "testOne",
	"secondName": "testTwo"
}

The response from a successfull account insertion will be as below
{
    "message": "account has been successfully added"
}

3) To delete an account
Issue the HTTP verb DELETE to -> http://localhost:8080/account-project/rest/account/json/1
where 1 is the id of the account you wish to delete
The response will be a json object with the structure as below.
{
    "message": "account successfully deleted"
}

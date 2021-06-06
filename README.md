# transfer-service-api
This service has an endpoint /xfer/send/ and takes Source, destination account numbers and amount as input and returns response with updated balances.

Available as Docker image: Refer Dockerfile or run /mvnw.cmd spring-boot:build-image <br />

One REST Endpoints are implemented

* **URL**

  _/xfer_

"send" Creates a transaction


* **Method:**
  
  _/send_

  `POST` 
  
*  **URL Params**

   _No URL Parameters required_
   
* **Data Params**
 **Content:**  `
        { 
          sourceNumber : "1001", 
          destNumber: "1002", 
          amount : 10.0
        } `
* **Success Response:**
  
  _HTTP 201 with Details after transaction commit_

  * **Code:** 201 <br />
    **Content:** `{
  "message": "Transaction successfully created",
  "code": 201,` <br />
  `"txn": {
    "id": 2,
    "sourceNumber": "1003",
    "destNumber": "1004",
    "amount": 20.0
  }, `<br />
 ` "source": {
    "id": 3,
    "number": "1003",
    "balance": 80.0
  }, `<br />
  `"dest": {
    "id": 4,
    "number": "1004",
    "balance": 120.0
  }
}`<br />
    
    
 * **Failure Responses:**
    _HTTP 400 with Error details in the response body_
    * **Code:** 400 <br />
    **Content:** `{
  "message": "Failed to create transaction",
  "code": 400,
  "details": "Source and Destination Account numbers should not be same"
}`<br />
    _Other possible errors_
      * Source and Destination Account numbers should not be same
      * Source Account number is invalid
      * Source Account doesn't have sufficient funds
      * Amount to be transferred should be positive
      * Destination Account number is invalid
     <br/> 
   
   _HTTP 500 For any server errors_
    * **Code:** 500 <br />
    **Content:** `{
  "message": "Failed to create transaction",
  "code": 400,
  "details": "Unexpected error has occured: <<Error Message here>>",
  "txn": null,
  "source": null,
  "dest": null
}`<br />

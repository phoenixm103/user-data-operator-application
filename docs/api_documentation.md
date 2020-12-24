# user-data-operator-application API Documantation

### `Version`: 1.0.0
### `Date`: 2020-12-24
user-data-operator-application will expose several APIs.
The endpoints are:

`### 1. /parent`

#### 1. When triggered it returns List of parents already stored in Database.
`method` : 
            GET
            
`Content-Type`:
            application/json
            
`Demo Response` : 
```
[
	    {
        	"civilId": "457",
                "firstname": "golam",
                "lastname": "mohammed",
                "address": {
                        "street": "2",
                        "city": "CTG",
                        "state": "CTG",
                        "zip": "4321"
                }
        },
        {
                "civilId": "789",
                "firstname": "golam",
                "lastname": "mohammed",
                "address": {
                        "street": "2",
                        "city": "CTG",
                        "state": "CTG",
                        "zip": "4321"
                    }
       },
       {
               "civilId": "790",
               "firstname": "golam",
               "lastname": "mohammed",
               "address": {
       	                "street": "2",
                        "city": "CTG",
                        "state": "CTG",
                        "zip": "4321"
              }
       }
]
```
#### 2. When triggered with a Request Body of Parent Object it stores parent in parent collection
`method`: POST

`Content-Type`:
            application/json

`Request-body`:
```            
{
    "civilId": "462",
    "firstname": "golam",
    "lastname": "mohammed",
    "address": {
            "street": "2",  
            "city": "MOGDAI",
            "state": "CTG",
            "zip": "4321"
            }
}
```
If added successfully,

`Demo Response` :
            `PARENT IS ADDED SUCCESSFULLY`
            
If already exists,
 
`Demo Response` :
            `PARENT ALREADY EXISTS`

If one or more input values are null

`Demo Response` :
            `INVALID INPUT : ONE OR MORE INPUT FIELDS ARE NULL`
            
`### 2. /parent/{civilId}`           
#### 1. When triggered it deletes the parent with given civilId from Database.
`method` : 
            DELETE

If there is no parent with given civilId            

`Demo Response` : 
                `PARENT ID : 458 IS INVALID`

If civilId is valid

`Demo Response` : `PARENT ID : 457 REMOVED SUCCESSFULLY`
               
#### 2. When triggered with a Request Body of Parent Object it updates parent in parent collection 

`method`: PUT

`Content-Type`:
            application/json

`Request-body`:
```            
{
    "civilId": "462",
    "firstname": "golam",
    "lastname": "mohammed",
    "address": {
            "street": "2",  
            "city": "MOGDAI",
            "state": "CTG",
            "zip": "4321"
            }
}
```
If the given id is invalid

`Demo Response`: `NO PARENT FOUND WITH CIVIL ID : 462`

If the given id is valid

`Demo Response`: `PARENT WITH CIVIL_ID : 462 IS UPDATED SUCCESSFULLY`

`### 3. /child`

#### 1. When triggered it returns List of childs already stored in Database.
`method` : 
            GET
            
`Content-Type`:
            application/json
            
`Demo Response` : 
```
[
    {
        "civilId": "152",
        "firstname": "sayma",
        "lastname": "nur",
        "parent": {
            "civilId": "789",
            "firstname": "golam",
            "lastname": "mohammed",
            "address": {
                "street": "2",
                "city": "CTG",
                "state": "CTG",
                "zip": "4321"
            }
        }
    },
    {
        "civilId": "159",
        "firstname": "salma",
        "lastname": "nur",
        "parent": {
            "civilId": "789",
            "firstname": "golam",
            "lastname": "mohammed",
            "address": {
                "street": "2",
                "city": "CTG",
                "state": "CTG",
                "zip": "4321"
            }
        }
    },
    {
        "civilId": "160",
        "firstname": "salma",
        "lastname": "nur",
        "parent": {
            "civilId": "790",
            "firstname": "golam",
            "lastname": "mohammed",
            "address": {
                "street": "2",
                "city": "CTG",
                "state": "CTG",
                "zip": "4321"
            }
        }
    }
]
```
#### 2. When triggered with a Request Body of Child Object it stores child in child collection
`method`: POST

`Content-Type`:
            application/json

`Request-body`:
```            
{
	    "civilId":"127",
	    "firstname":"sayma",
	    "lastname":"nur",
	            "parent":{
		        "civilId":"784",
		        "firstname":"nilufar",
		        "lastname":"mohammed",
		            "address" : {
			        "street":"2",
			        "city":"CTG",
			        "state":"CTG",
			        "zip":"4321"
		        }
	    }
}
```
If added successfully,

`Demo Response` :
            `CHILD IS ADDED SUCCESSFULLY`
            
If already exists,
 
`Demo Response` :
            `CHILD ALREADY EXISTS`

If one or more input values are null

`Demo Response` :
            `INVALID INPUT : ONE OR MORE INPUT FIELDS ARE NULL`
            
`### 4. /child/{civilId}`           
#### 1. When triggered it deletes the child with given civilId from Database.
`method` : 
            DELETE

If there is no child with given civilId            

`Demo Response` : 
                `CHILD ID : 127 IS INVALID`

If civilId is valid

`Demo Response` : `CHILD : 127 REMOVED SUCCESSFULLY`
               
#### 2. When triggered with a Request Body of Child Object it updates child in child collection, updates or adds parent in parent collection 

`method`: PUT

`Content-Type`:
            application/json

`Request-body`:
```            
{
	    "civilId":"128",
	    "firstname":"sayma",
	    "lastname":"nur",
	    "parent":{
		        "civilId":"784",
		        "firstname":"nilufar",
		        "lastname":"mohammed",
		        "address" : {
		        	    "street":"2",
			            "city":"CTG",
			            "state":"CTG",
			            "zip":"4321"
		        }   
	    }
}
```
If the given id is invalid

`Demo Response`: `NO CHILD FOUND WITH CIVIL ID : 128`

If the given id is valid

`Demo Response`: `CHILD WITH CIVIL_ID : 128 IS UPDATED SUCCESSFULLY`
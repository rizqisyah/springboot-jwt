# Spring Boot + JWT And Postgressql

Create Jwt with spring boot and postgressql

## Getting Started

I Use Java 8 And PostgresSql 9

### Create User

For Create User

```
CREATE User Sign UP
URL = http://localhost:8080/api/auth/signup
JSON 
{
	"name" : "Riz",
	"username": "rizqisyah2",
	"email" : "rizqisyah5@gmail.com",
	 "role": [
	 	"pm"
	 	],
	 "password" : "admin123"
}
```
### Get Token User

Get Token From User

```
Get Token From User
URL = http://localhost:8080/api/auth/signin
JSON 
{
	"username" : "rizqisyah2",
	"password" : "admin123"
}
```

```
Test Token
URL = http://localhost:8080/api/test/user
```

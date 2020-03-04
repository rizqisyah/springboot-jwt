# springboot-jwt

CREATE User Sign UP

1.URL = http://localhost:8080/api/auth/signup
2.JSON 
{
	"name" : "Riz",
	"username": "rizqisyah2",
	"email" : "rizqisyah5@gmail.com",
	 "role": [
	 	"pm"
	 	],
	 "password" : "admin123"
}

Get Token 
1.URL =  http://localhost:8080/api/auth/signin
2.JSON
{
	"username" : "rizqisyah2",
	"password" : "admin123"
}

Test Application
1.URL = http://localhost:8080/api/test/user

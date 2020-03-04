# Spring Boot + JWT And Postgresql

Saya Disini Membuat Spring Boot Dan Jwt

## Getting Started

Saya Menggunakan Java 8 Dan Postgre9

### Create User

Untuk Pendaftaran User

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

Untuk Mengambil Token Dari User

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

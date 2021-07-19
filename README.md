# ApiRestSpringBoot
Api Rest com crud básico de usuário 

# COLLECTION POSTMAN
https://documenter.getpostman.com/view/14182993/TzmCiZbn

# POST (novo usuário)
	http://localhost:8080/api/register
	
# Requests

	{
    "name": "Gabriel Ricarte",
    "login": "bielricarte",
    "password" : "123456",
    "github" : "gabriel-ricarte",
    "email" : "bielricarte@gmail.com"
  	}
	or
	  {
	      "name": "Vedant Jajoo",
	      "login": "coderjojo",
	      "password" : "123456",
	      "github" : "coderjojo",
	      "email" : "coderjojo@coderjojo.com"
	  }
# POST (login)
	http://localhost:8080/login
# Requests

	--form 'username="bielricarte"' \
	--form 'password="123456"'	

# GET
	http://localhost:8080/users

# GET By ID
	http://localhost:8080/users/1
  
 # GET com pagination
	http://localhost:8080/users/pagination

# PUT
	http://localhost:8080/users

# DELETE
	http://localhost:8080/users



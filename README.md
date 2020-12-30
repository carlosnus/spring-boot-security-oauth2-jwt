# Secure a Spring Boot REST API with JSON Web Token and Oauth2

## Running and Testing the Application

First, you will need the following basic pieces of information:

* client: testjwtclientid
* secret: XY7kmzoNzl100
* Non-admin username and password: john.doe and jwtpass
* Admin user: admin.admin and jwtpass
* Example of resource accessible to all authenticated users: http://localhost:8081/cities
* Example of resource accessible to only an admin user: http://localhost:8081/users

## Step 1: Generate an access token

Use the following generic command to generate an access token:
```bash 
$ curl client:secret@localhost:8080/oauth/token -d grant_type=password -d username=user -d password=pwd
```

For this specific application, to generate an access token for the non-admin user john.doe, run: 
```bash
$ curl testjwtclientid:XY7kmzoNzl100@localhost:8080/oauth/token -d grant_type=password -d username=john.doe -d password=jwtpass
```

## Step 2: Use the token to access resources through your RESTful API

Use the token to access resources through your RESTful API
To access content available to all authenticated users:
Use the generated token as the value of the Bearer in the Authorization header as follows:
```bash 
$ curl http://localhost:8081/cities -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4uYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNDk0NDU0MjgyLCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIiwiQURNSU5fVVNFUiJdLCJqdGkiOiIwYmQ4ZTQ1MC03ZjVjLTQ5ZjMtOTFmMC01Nzc1YjdiY2MwMGYiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.rvEAa4dIz8hT8uxzfjkEJKG982Ree5PdUW17KtFyeec"
```

The response will be: 
```json
[ { "id": 1, "name": "Bamako" }, { "id": 2, "name": "Nonkon" }, { "id": 3, "name": "Houston" }, { "id": 4, "name": "Toronto" }, { "id": 5, "name": "New York" }, { "id": 6, "name": "Mopti" }, { "id": 7, "name": "Koulikoro" }, { "id": 8, "name": "Moscow" } ]
```

To access content available only to an admin user:

As with the previous example, first, generate an access token for the admin user with the credentials provided above then run
```bash 
$ curl http://localhost:8081/users -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4uYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNDk0NDU0OTIzLCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIiwiQURNSU5fVVNFUiJdLCJqdGkiOiIyMTAzMjRmMS05MTE0LTQ1NGEtODRmMy1hZjUzZmUxNzdjNzIiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.OuprVlyNnKuLkoQmP8shP38G3Hje91GBhu4E0HD2Fes"
```

The result will be: 
```json
[ { "id": 1, "username": "john.doe", "firstName": "John", "lastName": "Doe", "roles": [ { "id": 1, "roleName": "STANDARD_USER", "description": "Standard User - Has no admin rights" } ] }, { "id": 2, "username": "admin.admin", "firstName": "Admin", "lastName": "Admin", "roles": [ { "id": 1, "roleName": "STANDARD_USER", "description": "Standard User - Has no admin rights" }, { "id": 2, "roleName": "ADMIN_USER", "description": "Admin User - Has permission to perform admin tasks" } ] } ]
```

## Example based on
[Secure a Spring Boot REST API with JSON Web Token](https://medium.com/better-programming/secure-a-spring-boot-rest-api-with-json-web-token-reference-to-angular-integration-e57a25806c50)


"# spring-boot-security-oauth2-jwt" 

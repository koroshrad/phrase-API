1. Once the application is compiled successfully, 
2. run the following command to start the application: java -jar target/<project_name>.jar 
3. The application will start running on the default port 8080. 
4. You can then test the API endpoints using a tool like Postman or by sending HTTP requests via the command line. 
5. Note that the /login endpoint will return a token that you need to include in the Authorization header of subsequent requests to the other endpoints.


#########curl to call API
#Login with username and password to get the token
curl -X POST \
http://localhost:8080/login \
-H 'Content-Type: application/json' \
-d '{
"username": "your-username",
"password": "your-password"
}'

#Get projects with the token retrieved from step 1
curl -X GET \
http://localhost:8080/projects \
-H 'Authorization: Bearer your-token'


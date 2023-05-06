We will be using google.com as an example URL to be encoded and decoded

INSTRUCTIONS:
Start the web application on localhost:8080 by running the SpringApplication.run() method called in main() inside of demo/src/main/java/com/example/demo/ DemoApplication.java
After the tomcat server has been initialized, go to localhost:8080/encode?url=google.com
This will use the encode endpoint and a json with the shortened url should be returned.
To use the decode endpoint, go to localhost:8080/decode?shortenedUrl=<shortened_url>, where shortened_url is the url found in the json returned by the encode endpoint. 
The url for google.com should be returned in a json

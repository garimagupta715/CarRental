1. download and extract file.
2. open in intellij
3. run main file as sprint boot application. it will run server at 8080 port
4. downnload postman for request of rest api
5. add a cab by admin: http://localhost:8080/api/saveCarsInfo
I/O: 
{
 "id": "1",
 "name": "i20",
 "location": 1,
 "availableFrom" : "2020-12-12",
 "requests": null
}
O/p:
{
    "id": "1",
    "location": 1,
    "availableFrom": "2020-12-12T00:00:00.000+00:00",
    "requestsServed": []
}

5. Get a cab by it's id : http://localhost:8080/api/getCarsInfo/1
{
    "id": "1",
    "location": 1,
    "availableFrom": "2020-12-12T00:00:00.000+00:00",
    "requestsServed": []
}


6. Get all Cab Info : http://localhost:8080/api/getAllCarsInfo
o/p:
[
    {
        "id": "1",
        "location": 1,
        "availableFrom": "2020-12-12T00:00:00.000+00:00",
        "requestsServed": []
    }
]

like that you can get others info also by hitting rest end point:


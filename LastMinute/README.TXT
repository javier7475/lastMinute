I have implemented a rest service to provide the solution. The service can be invoked like this.

http://localhost:8080/LastMinute/rest/flightSearch/search?origin=BCN&destination=FRA&infants=1&adults=1&departureDate=01/01/2018&children=2

The data is hardcoded in a Database class. A database should be used and a tool like hibernate too but I used memory for simplicity since the scope is unknown.


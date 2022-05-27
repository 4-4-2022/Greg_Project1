Suite's Available Management Platform
==============================

This API is set up to handle the creation and management of
----------------------------------------------------------
**-Suites**
    
    -id
    -suite
    -price
    -description
**-Weeks**
   
    -week
    -date
    -opponent
    
    
Suites Functionality
=======================

**Save New Suite**

-url: http://localhost:5050/displaysuites/postSuites

-RequestBody:

    {
        "id": 5,
        "suite": "Poolside Suite",
        "price": 14000.0,
        "description": "Suite made for large getherings with an infinity pool overlooking the field."
    }
    
**Find Suite by Suite ID**

-url: http://localhost:5050/suitedisplay/get/?

-Request Parameter: Suite ID (Integer)
    
**Find all Suites**

-url: http://localhost:5050/suitedisplay/getall
    
**Update Suite by Suite ID**

-url: http://localhost:5050/suitedisplay/update/?

-Request Parameter: Suite ID (Integer)

-RequestBody:

    {
        "id": 3,
        "suite": "Player's Suite",
        "price": 8000.0,
        "description": "Suite made for other players"
    }
                  
**Delete Suite by Suite ID**

-url: http://localhost:5050/displaysuites/suites?id=?

-Request Parameter: Suite ID (Integer)
   
   
Weeks Functionality
======================

**Find Week by week number**

-url: http://localhost:5050/weekdisplay/get/?
-Request Parameter: Week number (Integer)

**Find All Weeks**

-url: http://localhost:5050/weekdisplay/getall
    
**Save Week**

-url: http://localhost:5050/displayweeks/postWeeks

-RequestBody:

    {
        "week": 18,
        "date": "January 9th",
        "opponent": "Washington Commanders"
    }
                   
**Delete Week by Week number**

-url: http://localhost:5050/displayweeks/weeks?week=?

-Request Parameter: Week ID (Integer)
     
 **Update Week**
 
 -url: http://localhost:5050/weekdisplay/update/?
 
 -RequestBody:
 
    {
        "week": 18,
        "date": "January 10th",
        "opponent": "Scooby Doobers"
    }

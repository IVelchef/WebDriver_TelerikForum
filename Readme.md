
I used the framework provided by the academy in the task and updated all

 dependencies to ensure it works without errors. 

In the tests for liking and unliking, I use a common structure for clicking the buttons.
  
The only thing I had to do was introduce artificial delays because the buttons
   
    are extremely dynamic and wouldn't register the click otherwise. 
    
I assert the like's tests by validating the change in the button's status after it's clicked.

I didn't dare move the logout logic to @AfterEach.


The prerequisites are in the enums/ folder and ForumTestData

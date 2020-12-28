# InterviewTask

Libraries : Use both Selenium, RestAssuired.

Language used : Java 1.8

Testing Framework :  TestNG 6.14.3


o	Navigate to webpage https://www.google.com/. 


o	Click the “I am Feeling Lucky” button. 


o	Read the text of the first doodle thumbnail. 


o	Visit the sample APIs page (http://dummy.restapiexample.com/) 


o	Create an employee using create API from above page with the text found in Step 3. 


o	Validate that the employee is present 


Issues Observed:

When we run, getting below issue:

It looks testng version compatability issue (by 28/12/2020 - 07:06AM IST)

java.lang.NoSuchMethodError: org.testng.TestRunner.addListener(Ljava/lang/Object;)V
	at org.testng.remote.support.RemoteTestNG6_9_10$1.newTestRunner(RemoteTestNG6_9_10.java:32)

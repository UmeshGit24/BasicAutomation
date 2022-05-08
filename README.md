# MakeMyTripBasicAutomation

Purpose :- Perform Automation testing for HomePage,Login,Flight Search on MakeMyTrip WebSite.

Tech Stack Used in this Automation FrameWork:-
Programming Language:-Java
Automation Framework:- Selenium WebDriver
Automation Tool to exceute TestCases:- TestNG
Project Management Tool:-Maven groupId=org.example ,artifactId=MakeMyTrip


Project Structure

Drivers Floder:-Contains different executable for different browser and OS Type.

src/test/java/com/test/makemytrip folder Consist:-

Constants:-Contains static data and test data

PageObject:-Contains different Page class which stores WebElement on Page and different method to perform actions.(Page Object Design Pattern)

Utilities:- Contiains Web Utilities ,Genenric Utilities,Properties Utilities and Test Environment Setup Utilities

TestScript Folder consist:-

BaseTest:-Parent class of all the TestCases which is used for driver setup and driver quit actions

TestClass:-Conatins TestClass for Login,HomePage,Flight Search which contains automated testCase @Test using TestNG

Xml:-Contains a pom.xml file to exceute automated testcase @Test.

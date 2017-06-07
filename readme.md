# SpringBootWithJerseyApp #
## Disclaimer ##
This is not a commercial tool. It was development for test purpose only so doesn't have any warranty.

Feel free to test, use and/or modify.

For more details see the LICENSE file.

## Description ##
I had a requirement to create a Spring Boot Application with Jersey rest end-points. Researching on Internet about how to overwrite the SB configuration I founded that it solves with only one dependency!

So, here is a little example about how to configure and test (with Mockito and EasyMock) a Jersey end-point in a Spring Boot Application.
 
## Features/Tips ##
* Adds the Spring Boot starter dependency for Jersey
* Replaces the default Spring Boot annotations with Jersey annotations for the rest end-points
* Includes the configuration bean to include the Jersey's Controller (classes or packages)
* Includes Unit Tests using:
	* Mockito for Spring Boot 1.4 or higer
	* Mockito for Spring Boot 1.3.8 or lower
	* EasyMock 3.4
* Tested with Spring Boot versions:
	* 1.5.3.RELEASE
	* 1.4.2.RELEASE
	* 1.3.8.RELEASE (without ServletInitiliazer class)

## End-points ##
###GET end-point:
http://localhost:8080/resources/get/test

## GitHub repository: ##
### https://github.com/Gabotto/SpringBootWithJerseyApp ###
## Contact ##
Let me know if you have any problem, comment or new ideas:
#### Wordpress: http://gabelopment.wordpress.com/ ####
####Email: gabelopment@gmail.com ####

Edited on: 7th June 2017
 

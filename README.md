# jdk9-features

This project mainly focuses on testing features of JDK 9.
The Main objective of the project is to add test cases for as much as use cases possible for Java 9 features. 

Before using any new feature many use to write a simple ad-hoc proof of concept program in a main method, this small ad-hoc program does not always remain managable to refer it at a later point of time. so having it as test cases could help anyone to refer back again and again and if anything is missed out, one can add a new test case and enrich the resource. This form the idea behind this project.

Similar to <a href="http://www.oracle.com/technetwork/java/javase/tech/index.html">Technology Classification</a> this projects classifies various features of JDK 9 into categories and separate them into maven modules.

The following modules are currently present in jdk9-features project.
1. <B>api:</B> 
Test cases for any JDK 9 general API other than core language API can be added in this module.
2. <B>concepts:</B>
Test cases for programming concepts like functional programming or reactive programming etc., can be added with appropriate use cases and iwiki page in this module.
3. <B>lang:</B>
Test cases for core language constructs and API can be added in this module.
4. <B>tooling:</B>
Test cases for tools such as java, javac, jshell can be added in this module.

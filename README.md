# razr-coding-exercise
Razr Coding Exercise for Software Engineer Recruitment

# Purpose
This repository contains the code to accomplish the recruitment realted coding exercise from Razr

# Table of Contents  
- [Assumptions](#assumptions)  
- [Running](#running)
- [Client](#client)
- [Lacking](#lacking)

# Assumptions
1. You are a Software Engineer who has experience with ReSTful APIs, Java, Maven, Swagger and Spring
1. You have Java 8 and Maven installed, with https://repo.maven.apache.org accessible over your network
1. You have enough available disk & memory space on your machine (~500MB each) 
1. You don't have any processes running on port 8080

# Running
1. Clone this repository
1. `mvn spring-boot:run`
1. Go to <http://localhost:8080/swagger-ui.html>

# Client
Use the Swagger client located at <http://localhost:8080/swagger-ui.html>

# Lacking
Given that this solution is nowhere near production ready and was created simply to demonstrate a little bit of my coding, it is obviously lacking several things including (but not limited to):
1. Environment specific configurations
1. Tests (all types - unit [some exist], integration)
1. Security
1. Validation
1. Logging - both system (to log files) and audit (to Splunk/Elk, etc. for the purposes of monitoring/reporting)
1. Versioning
1. JavaDocs (I don't put many more comments than JavaDocs because I believe what Uncle Bob says - _If you have to put comments in your code describing methods/fields in detail, you have room for improvement in naming them better._)
1. Caching (to reduce hits to the persistence layer)

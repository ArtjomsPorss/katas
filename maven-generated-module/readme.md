# challenge
Create a Spring Boot project with a REST endpoint and a test for it

# acceptance criteria
1. has parent pom and submodule
2. parent pom in root of the project
3. parent pom references spring-boot-dependencies bom as it's parent
4. submodule has a spring boot application class
5. submodule has a web controller (needs spring-boot-starter-web) with a REST endpoint returning some static text
6. submodule has a SpringBootTest of REST endpoint verifying static text returns when calling REST endpoint

# tips
1. junit 5, mockito and spring-test are part of spring-boot-test dependency
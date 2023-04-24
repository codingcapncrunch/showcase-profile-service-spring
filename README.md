## About the 'showcase-profile-service-spring' project

The purpose of this project is to showcase some of my github repository work with Spring Boot by developing a simple customer profile service.

Some of the goals I hope to accomplish with this project include:

1. Demonstrate a service oriented pattern and key capabilities commonplace in real-world Spring Boot projects
2. Offer a working example of all the below stated concepts and capabilities working side-by-side
3. Push past my imposter syndrome and practice what I know

Intended concepts and key capabilities showcased:
* ___Spring Boot___ application organized around API and domain level packages (API vs service oriented backend within a single deployable)
* API and domain model objects (POJOs / DTOs) with an abstract ___Translator___ approach (toApiModel & toDomainModel methods)
* POJO ___Javax validation___ (@Pattern, @Size, @NotNull, @Valid, etc.)
* ___RestController___ classes with basic CRUD APIs (@GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @RestController, @RequestMapping, etc.)
* ___Interface___ & concrete class pattern for defined domain services ProfileService & AddressValidatorService (@Service)
* ___Multiple implementations___ for a given interface (profile in-memory vs database impls)
* Defined ___JpaRepository___ (@Repository) for profile and address related data
* ___Entity___ definitions for profile and address objects (@Entity, @Table, @Column, @Enumerated, etc.) 
* ___Native query___ usage on address related datastores (@Query)
* Boilerplate POJO methods (getters & setters, etc.) with ___Lombok___ (@Data)
* ___Flyway___ for managing database migrations / versions
* ___Jasypt___ encryption for sensitive property file entries (db credentials)
* Uniform ___exception handling___ & ___error messaging___ with GlobalExceptionHandler class (@ControllerAdvice, @ExceptionHandler)
* Basic ___unit tests___ for profile and address javax validation (@SpringBootTest, @Test, etc.)
* ... more to come!

Note the ./documents/project_backlog.txt file capturing future todo items.

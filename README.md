## 'showcase-service' - About The Project

The purpose of this project is to finally make public some of my github repository work.  I'm hoping to accomplish a few goals including:

1. Demonstrate usage of a service oriented backend pattern and key working capabilities expected in real-world Spring Boot projects (at least in my experience)
2. Offer a working example of all the below stated concepts and capabilities working side-by-side
3. Push past my imposter syndrome and practice what I know

Intended concepts and key capabilities created/included:
* Spring Boot application organized around API and domain level packages (API vs service oriented backend within a single deployable)
* API and domain model objects (POJOs / DTOs) with an abstract Translator approach (toApiModel & toDomainModel methods)
* POJO Javax validation (@Pattern, @Size, @NotNull, @Valid, etc.)
* RestController classes with basic CRUD APIs (@GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @RestController, @RequestMapping, etc.)
* Interface & concrete class pattern for defined domain services ProfileService & AddressValidatorService (@Service)
* Multiple implementations for a given interface (profile in-memory vs database impls)
* Defined JpaRepository (@Repository) for profile and address related data
* Entity definitions for profile and address objects (@Entity, @Table, @Column, @Enumerated, etc.) 
* Native query usage on address related datastores (@Query)
* Boilerplate POJO methods (getters & setters, etc.) with Lombok (@Data)
* Flyway for managing database migrations / versions
* Jasypt encryption for sensitive property file entries (db credentials)
* Uniform exception handling & error messaging with GlobalExceptionHandler class (@ControllerAdvice, @ExceptionHandler)
* Basic unit tests for profile and address javax validation (@SpringBootTest, @Test, etc.)
* ... more to come!

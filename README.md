## 📚 Concepts Covered

This project demonstrates how to use **Aspect-Oriented Programming (AOP)**, the **Decorator Pattern**, and **Controller Advice** in a Spring Boot application to achieve cross-cutting concerns such as logging, authentication, and exception handling.

- **AOP**: Separates cross-cutting concerns like logging, metrics, and security from business logic.
- **Decorator Pattern**: Dynamically adds behavior to objects without modifying their code.
- **Controller Advice**: Centralizes exception handling and response customization for REST APIs.

For more detailed explanations and improvement suggestions for this project, check the recommendations below.

---

## 💡 Suggestions / Improvements

For anyone interested in refining this project further, here are some improvement suggestions:

| Area                     | Suggestion                                                                                  | Reason / Benefit                                                                                   |
|--------------------------|----------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------|
| **Exception hierarchy** | Use specific custom exceptions (e.g. `RateLimitExceededException`, `AuthenticationFailedException`) instead of generic `RuntimeException`. | Makes exception handling more precise and intent-revealing.                                       |
| **@AfterThrowing / exception aspect** | Add an aspect with `@AfterThrowing` advice to centrally log exceptions, before they reach the controller advice. | Uniform logging of unexpected errors, stack traces, and context.                                  |
| **Audit aspect**        | Introduce an `@AfterReturning` or `@Before` aspect that records user / operation details (timestamp, user, parameters, result). | Useful for traceability, especially for financial operations.                                    |
| **Selective pointcuts** | Rather than blanket `execution(* tz.co.werelay.aop_decorator.service..*(..))`, narrow aspects by custom annotations (e.g. `@Auditable`) or method naming. | Prevents over-logging and unwanted overhead.                                                      |
| **Testing**             | Add integration tests (with `@SpringBootTest`) to assert that aspects trigger and exception responses are correct. | Ensures AOP + decorator chains are not broken as code evolves.                                    |
| **Metrics / performance** | Optionally, send execution times to a metrics system (Micrometer, Prometheus) rather than just logging. | For real systems, you want actionable metrics.                                                   |
| **Documentation / README** | Add usage instructions: how to run, how to test, what decorators are in place, sample requests/responses. | Helps others (and future you) quickly understand and use the project.                            |

---

🔗 [Check full recommendations and concepts on GitHub](https://github.com/amelyec/aop-decorator)

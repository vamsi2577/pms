# Patient Management System

This repository contains a Spring Boot–based microservice architecture for a Patient Management System (PMS). Each service focuses on a specific domain and communicates through standard REST or gRPC interfaces.

## Services

- **api-gateway** – Routes external requests to the underlying services.
- **auth-service** – Provides authentication and authorization using Spring Security and JWT.
- **billing-service** – Manages patient billing and payments.
- **patient-service** – Handles patient records and related operations.
- **analytics-service** – Processes and reports analytical data.

## Development

Each microservice is an independent Maven project. Use the included Maven wrapper to build and test services.

```bash
cd <service-name>
./mvnw test
```

Tests are run per service; ensure they all pass before committing changes.

## Documentation

Additional documentation is available in the [`docs/`](docs/) directory.


# Architecture Overview

The Patient Management System is composed of several Spring Boot microservices. Each service is designed to be self-contained and focused on a specific area of the domain.

## Services

- **api-gateway**: Central entry point for clients. It forwards HTTP requests to the appropriate backend service.
- **auth-service**: Manages user authentication and authorization, issuing and validating JWT tokens.
- **billing-service**: Tracks invoices and processes payments for patient treatments.
- **patient-service**: Stores and serves patient profiles and related data.
- **analytics-service**: Aggregates information from other services to provide reporting and insights.

## Development Notes

- Each service includes a Maven wrapper (`mvnw`) for consistent builds.
- Services communicate primarily through REST; `grpc-requests` contains sample gRPC interactions.
- To build or test a service:

```bash
cd <service-name>
./mvnw test
```


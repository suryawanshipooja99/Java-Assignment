# hotel-reservation-system


## Objective

Develop a Java system for handling hotel room reservations.

## Entities

### Guest

- Fields: `id`, `name`, `email`
- Relationships: OneToMany with `Reservation`

### Reservation

- Fields: `id`, `startDate`, `endDate`, `guest` (ManyToOne relationship with `Guest`)

## API Endpoints

1. **Create a new reservation:**

    - Endpoint: `POST /reservations`
    - Request Body:
        ```json
        {
          "guestId": 1,
          "startDate": "2023-01-01",
          "endDate": "2023-01-10"
        }
        ```
    - Response:
        ```json
        {
          "id": 1,
          "startDate": "2023-01-01",
          "endDate": "2023-01-10",
          "guest": {
            "id": 1,
            "name": "John Doe",
            "email": "john@example.com"
          }
        }
        ```

2. **Update reservation dates:**

    - Endpoint: `PUT /reservations/{reservationId}`
    - Request Body:
        ```json
        {
          "startDate": "2023-02-01",
          "endDate": "2023-02-10"
        }
        ```
    - Response:
        ```json
        {
          "id": 1,
          "startDate": "2023-02-01",
          "endDate": "2023-02-10",
          "guest": {
            "id": 1,
            "name": "John Doe",
            "email": "john@example.com"
          }
        }
        ```

3. **Cancel reservation:**

    - Endpoint: `DELETE /reservations/{reservationId}`
    - Response:
        ```json
        {
          "message": "Reservation canceled successfully."
        }
        ```

4. **List all reservations made by a guest:**

    - Endpoint: `GET /guests/{guestId}/reservations`
    - Response:
        ```json
        [
          {
            "id": 1,
            "startDate": "2023-02-01",
            "endDate": "2023-02-10",
            "guest": {
              "id": 1,
              "name": "John Doe",
              "email": "john@example.com"
            }
          },
          {
            "id": 2,
            "startDate": "2023-03-01",
            "endDate": "2023-03-10",
            "guest": {
              "id": 1,
              "name": "John Doe",
              "email": "john@example.com"
            }
          }
        ]
        ```

## Setup

1. **Dependencies:**
    - List any dependencies and how to install them.

2. **Project Structure:**
    - Briefly explain the project structure.

## How to Run

Provide instructions on how to run the application locally.

## API Documentation

For detailed API documentation, refer to [API_DOCUMENTATION.md](API_DOCUMENTATION.md).

## Postman Collection

Test the API using the provided [Postman Collection](link-to-postman-collection).

Feel free to reach out if you have any questions or issues!


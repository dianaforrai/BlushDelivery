

# Delivery Platform

This project is a comprehensive delivery platform that includes a Spring Boot API, a frontend interface for couriers, and a client application for tracking deliveries using AWB (Air Waybill) numbers.

## Features

- **Spring Boot API**: Provides RESTful services for managing deliveries, couriers, and clients.

- **Courier Frontend**: A user-friendly interface for couriers to manage their deliveries including features like SMTP integration for delivering packages.

- **Client Application**: Allows clients to track their deliveries in real-time using AWB numbers.

## Technologies Used

- **Backend**: Spring Boot, Java

- **Frontend**: Vue.js, JavaScript, HTML, CSS

- **Database**: MySQL

## Prerequisites

- **Java**: JDK 1.8 or higher

- **Maven**: Version 3.x

## Getting Started

1. **Clone the repository**:

   ```bash
   git clone https://github.com/dianaforrai/delivery-platform.git
   ```

2. **Navigate to the backend directory**:

   ```bash
   cd delivery-platform/backend
   ```

   > NOTE: You should create an .env file with your `SMTP` password, and also modify the necessary data in the `MailConfig` class.

3. **Build the backend application**:

   ```bash
   mvn clean package
   ```

4. **Run the backend application**:

   ```bash
   java -jar target/scdproiect-0.0.1-SNAPSHOT.jar
   ```

   The backend service will start on `http://localhost:5173`.

5. **Navigate to the frontend directory**:

   ```bash
   cd ../frontend
   ```

6. **Install frontend dependencies**:

   ```bash
   npm install
   ```

7. **Run the frontend application**:

   ```bash
   npm run serve
   ```

8. **Navigate to the client directory**:

   ```bash
   cd ../frontend
   ```

9. **Install client dependencies**:

   ```bash
   npm install
   ```

10. **Run the client application**:

   ```bash
   npm run serve
   ```

   The client application will be accessible at `http://localhost:5174`.

## Contributing

Contributions are welcome!

Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License.

See the [LICENSE](LICENSE) file for more details.

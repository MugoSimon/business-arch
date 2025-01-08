# Business Arch Microservices 🚀

This repository hosts a microservices-based architecture for a **Business Arch** system. Each microservice performs a well-defined role, and together they form a cohesive, scalable, and resilient system. This architecture leverages Spring Cloud components, containerization with Docker, and distributed tracing using Zipkin.

Repository URL: [https://github.com/MugoSimon/business-arch/](https://github.com/MugoSimon/business-arch/)

---

## Microservices Overview 🏗️

### 1. **Config Server**  
The **Config Server** provides a centralized and externalized configuration management system for all microservices in the architecture. This allows microservices to fetch their configuration properties dynamically, making it easier to maintain consistent configurations across different environments (e.g., dev, staging, production).

- **Tech:** Spring Cloud Config  
- **Key Benefits:**  
  - Centralized management of configuration properties.  
  - Supports dynamic updates with Spring Cloud’s `@RefreshScope`.

### 2. **API Gateway**  
The **API Gateway** acts as the single entry point for all incoming requests to the system. It routes requests to the appropriate microservices while also providing cross-cutting concerns like security, logging, rate-limiting, and load balancing.

- **Tech:** Spring Cloud Gateway  
- **Key Benefits:**  
  - Simplified client interaction with backend services.  
  - Centralized control of routing rules and authentication.  
  - Helps in load balancing and monitoring.

### 3. **Service Registry**  
The **Service Registry** enables service discovery, allowing microservices to locate each other without hardcoding their network locations. This is especially useful in dynamic cloud environments where instances of services can be created or destroyed frequently.

- **Tech:** Spring Cloud Netflix Eureka  
- **Key Benefits:**  
  - Microservices can register themselves dynamically.  
  - Provides fault tolerance by enabling clients to discover healthy instances.  
  - Reduces the need for hardcoded service endpoints.

### 4. **Employee Service**  
The **Employee Service** is a low-level microservice responsible for managing employee-related data. It provides CRUD operations for employees and exposes APIs for retrieving employee details.

- **Key Features:**  
  - Handles employee details like names, age, positions, and associated departments.  
  - Communicates with other services (like Department Service) via REST APIs.

### 5. **Department Service**  
The **Department Service** handles department-related data. It provides APIs to manage departments and retrieve information such as department names and IDs. It also integrates with the **Employee Service** to fetch employees under specific departments.

- **Key Features:**  
  - Manages department data and exposes department-specific endpoints.  
  - Supports interaction with Employee Service for department-wise employee details.

### 6. **Zipkin for Distributed Tracing**  
**Zipkin** is integrated into the architecture to provide distributed tracing capabilities. It helps visualize request traces across microservices, making it easier to identify bottlenecks and troubleshoot performance issues.

- **Tech:** Zipkin (pulled via Docker)  
- **Setup Instructions:**  
  To run Zipkin locally, use the following command:  
  ```bash
  docker run -d -p 9411:9411 openzipkin/zipkin
  ```  
  Once started, the Zipkin UI can be accessed at [http://localhost:9411/](http://localhost:9411/).

- **Key Benefits:**  
  - Provides insights into request flows across microservices.  
  - Helps in pinpointing performance bottlenecks and failed requests.  
  - Facilitates end-to-end latency monitoring.

---

## Tech Stack 🛠️

- **Java 17**  
- **Spring Boot**  
- **Spring Cloud**  
- **Maven**  
- **Docker**  
- **Zipkin** for distributed tracing  
- **Eureka** for service discovery  
- **Spring Cloud Gateway** for request routing

---

## Getting Started 🏁

### Prerequisites  
Ensure you have the following installed on your local machine:

- **Java 17**  
- **Maven**  
- **Docker**

### Running the Services  

1. **Clone the repository**:  
   ```bash
   git clone https://github.com/MugoSimon/business-arch.git
   cd business-arch
   ```

2. **Start the Config Server**:  
   ```bash
   cd config-server
   mvn spring-boot:run
   ```

3. **Start the Service Registry**:  
   ```bash
   cd service-registry
   mvn spring-boot:run
   ```

4. **Start the API Gateway**:  
   ```bash
   cd api-gateway
   mvn spring-boot:run
   ```

5. **Start the Low-Level Microservices**:  
   - **Employee Service**:  
     ```bash
     cd employee-service
     mvn spring-boot:run
     ```
   - **Department Service**:  
     ```bash
     cd department-service
     mvn spring-boot:run
     ```

6. **Start Zipkin for Distributed Tracing**:  
   Pull and run the official Zipkin Docker image in detached mode:  
   ```bash
   docker run -d -p 9411:9411 openzipkin/zipkin
   ```  
   Once started, the Zipkin UI will be accessible at:  
   [http://localhost:9411/](http://localhost:9411/)

---

## Contributing 🤝

Contributions are welcome! Feel free to fork the repository, create a new branch, and submit a pull request. If you have any ideas or suggestions for improvements, don’t hesitate to reach out.

For inquiries, contact:  
**Email**: [mugolastbon@gmail.com](mailto:mugolastbon@gmail.com)

---

## License 📜

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for more details.

---

## Final Note 📝

If microservices were superheroes, this repo would be an awkward superhero team with no clear leader. But hey, they get the job done (eventually). 😄

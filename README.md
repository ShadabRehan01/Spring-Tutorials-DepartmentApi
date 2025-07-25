# 📘 DepartmentApi

> **This project belongs to Spring Boot Tutorials.**

A simple and well-structured **RESTful Department Management API** built using **Spring Boot**, **Spring Data JPA**, and **MySQL**. It performs full **CRUD operations**, with added features like **global exception handling** and **custom API response formatting**.

---

## 🚀 Tech Stack Used

* **Java 17**
* **Spring Boot**
* **Spring Data JPA**
* **MySQL**
* **Hibernate**
* **Jakarta Validation**
* **Maven**
* **IntelliJ IDEA**
* **Postman**

---

## 📁 Project Structure

```
src/
└── main/
    ├── java/
    │   └── com.DepartmentManagementSystem.DepartmentApi/
    │       ├── advices/             → Global exception & response handlers
    │       ├── annotations/         → (Reserved for custom annotations)
    │       ├── configs/             → Spring configurations (ModelMapper, etc.)
    │       ├── controllers/         → REST API endpoints
    │       ├── dto/                 → DepartmentDto (input/output layer)
    │       ├── entity/              → Department entity (JPA mapping)
    │       ├── exceptions/          → Custom exception classes
    │       ├── repositories/        → JPA repository interfaces
    │       └── services/            → Business logic layer
    └── resources/
        └── application.properties   → DB & Spring Boot configuration
```

---

## 🧠 Features

✅ Create a new department
✅ Fetch all departments
✅ Fetch a department by ID
✅ Update department (PUT)
✅ Partially update department (PATCH)
✅ Delete department by ID
✅ Global exception handling
✅ Standardized API response structure

---

## 🔌 REST API Endpoints

| Method   | Endpoint           | Description             |
| -------- | ------------------ | ----------------------- |
| `GET`    | `/department`      | Fetch all departments   |
| `GET`    | `/department/{id}` | Fetch department by ID  |
| `POST`   | `/department`      | Create a new department |
| `PUT`    | `/department/{id}` | Full update by ID       |
| `PATCH`  | `/department/{id}` | Partial update by ID    |
| `DELETE` | `/department/{id}` | Delete department       |

---

## ⚙️ Configuration

Update your `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/departmentdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080
```

---

## 🙋‍♂️ Author

**Shadab Rehan**
LinkedIn - https://www.linkedin.com/in/shadabrehan

---

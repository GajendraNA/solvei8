# Training Center Management System

## 📌 Overview

This is a **Spring Boot** application that manages training centers, their details, and validation constraints. The project follows **Spring Boot Microservices architecture**, using **Spring Data JPA, Hibernate, and PostgreSQL** for persistence. It ensures data integrity with unique constraints and proper exception handling.

## ⚙️ Tech Stack

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA (Hibernate)**
- **PostgreSQL**
- **Lombok**
- **Validation API**
- 
## 🚀 Features

- Create Training Centers with **Validation Constraints**
- Ensures `centerCode` is **unique** before inserting
- Proper **Exception Handling** with custom messages
- Uses **DTOs** for cleaner API responses
- Global **Exception Handling** for better error reporting

---

## 🏗️ Project Setup

### 1️⃣ Clone the Repository

```sh
git clone https://github.com/GajendraNA/solvei8.git
cd solvei8
```

### 2️⃣ Configure PostgreSQL Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/solvei8_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3️⃣ Build and Run the Application

```sh
./gradlew clean build
./gradlew bootRun
```

---

## 📡 API Endpoints

### 1️⃣ **Create Training Center**

**Endpoint:** `POST /api/v1/training-centers`

```json
{
    "centerName": "Traini8 Center",
    "centerCode": "TRAINI812355",
    "address": {
        "detailedAddress": "123 Main St",
        "state": "Maharashtra",
        "pincode": "400001"
    },
    "studentCapacity": 100,
    "coursesOffered": ["Java", "Spring Boot"],
    "contactEmail": "contact@traini8.com",
    "contactPhone": "9876543210"
}
```

**Response (201 Created):**

```json
{
    "id": 5,
    "centerName": "Traini8 Center",
    "centerCode": "TRAINI812355",
    "address": {
        "detailedAddress": "123 Main St",
        "state": "Maharashtra",
        "pincode": "400001"
    },
    "studentCapacity": 100,
    "coursesOffered": ["Java", "Spring Boot"],
    "contactEmail": "contact@traini8.com",
    "contactPhone": "9876543210",
		"createdOn": "2025-02-13T17:22:50.684389"
}

```

**Endpoint:** `GET /api/v1/training-centers`
**Response (200 Ok):**
```json

[
	{
		"id": 1,
		"centerName": "Traini8 Center",
		"centerCode": "TRAINI812361",
		"address": {
			"detailedAddress": "123 Main St",
			"city": "Mumbai",
			"state": "Maharashtra",
			"pincode": "400001"
		},
		"studentCapacity": 100,
		"coursesOffered": [
			"Java",
			"Spring Boot"
		],
		"contactEmail": "contact@traini8.com",
		"contactPhone": "9876543210",
		"createdOn": "2025-02-13T17:55:23.143668"
	},
	{
		"id": 2,
		"centerName": "Traini8 Center",
		"centerCode": "TRAINI812362",
		"address": {
			"detailedAddress": "123 Main St",
			"city": "Mumbai",
			"state": "Maharashtra",
			"pincode": "400001"
		},
		"studentCapacity": 100,
		"coursesOffered": [
			"Java",
			"Spring Boot"
		],
		"contactEmail": "contact@traini8.com",
		"contactPhone": "9876543210",
		"createdOn": "2025-02-13T17:55:28.225603"
	}
]



**Endpoint:** `GET /api/v1/training-centers`
**Response (200 Ok):**

```json
{
    "id": 5,
    "centerName": "Traini8 Center",
    "centerCode": "TRAINI812355",
    "address": {
        "detailedAddress": "123 Main St",
        "state": "Maharashtra",
        "pincode": "400001"
    },
    "studentCapacity": 100,
    "coursesOffered": ["Java", "Spring Boot"],
    "contactEmail": "contact@traini8.com",
    "contactPhone": "9876543210",
		"createdOn": "2025-02-13T17:22:50.684389"
}

```

### 2️⃣ **Handle Unique ********`centerCode`******** Validation**

If the `centerCode` already exists, it returns:
**Response (409 Conflict):**

---

## 📖 Exception Handling

The project has a **Global Exception Handler** to return user-friendly error messages.

### Example: **Validation Error**

If `centerName` is empty, the response will be:

```json
{
    "centerName": "CenterName is mandatory"
}
```

## 🛠️ Future Enhancements

✅ **Update & Delete Training Centers**
✅ **Pagination & Sorting for API Responses**
✅ **Swagger API Documentation**
✅ **Docker Compose for Full Setup**

---

## 👨‍💻 Author

**Gajendra NA**\
LinkedIn: ( https://www.linkedin.com/in/gajendra-na-7901a7258/ )
GitHub: ( https://github.com/GajendraNA )

---





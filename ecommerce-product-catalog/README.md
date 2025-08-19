#  E-Commerce Product Catalog (Spring Boot + Docker + MySQL)

This project is a simple **E-Commerce Product Catalog Service** built using **Spring Boot**, **MySQL**, and containerized with **Docker**.  
It provides REST APIs to manage product information (CRUD operations).

---

##  Features
- Spring Boot REST API for product catalog
- MySQL database for storing product details
- Dockerized application and database
- Easy setup with `docker-compose`
- Hibernate JPA for ORM
- Tested APIs using Postman

---

##  Project Architecture

Spring Boot App (REST API)
|
Docker Container
|
MySQL Database (Docker)


---

## Tech Stack
- **Java 17**
- **Spring Boot 3.2.5**
- **MySQL 8.0**
- **Docker / Docker Compose**
- **Hibernate / JPA**
- **Maven**

---

##  Setup Instructions

### 1. Clone Repository
```bash
git clone https://github.com/chaitanyachennamsetty/ecommerce-product-catalog.git
cd ecommerce-product-catalog

2. Build & Run with Docker Compose

docker compose up -d

3. Verify Containers

docker compose ps

You should see:

    ecommerce-product-catalog-app → Spring Boot app

    ecommerce-product-catalog-db → MySQL database

 Database Setup
Connect to MySQL

docker exec -it ecommerce-product-catalog-db mysql -u root -p

Password = root
Use the catalog database

USE catalogdb;

Insert Sample Data

INSERT INTO product (name, description, price, sku, stock) VALUES
('Laptop', 'High performance laptop', 1200.00, 'SKU001', 10),
('Smartphone', 'Latest model smartphone', 800.00, 'SKU002', 25),
('Headphones', 'Noise cancelling headphones', 150.00, 'SKU003', 50);

 API Endpoints

Base URL:

http://13.203.200.156:8080

Get All Products

GET /products

 Example: http://13.203.200.156:8080/products
✅ Sample Output (from /products)

[
  {
    "id": 1,
    "name": "Laptop",
    "description": "High performance laptop",
    "price": 1200.00,
    "sku": "SKU001",
    "stock": 10
  },
  {
    "id": 2,
    "name": "Smartphone",
    "description": "Latest model smartphone",
    "price": 800.00,
    "sku": "SKU002",
    "stock": 25
  },
  {
    "id": 3,
    "name": "Headphones",
    "description": "Noise cancelling headphones",
    "price": 150.00,
    "sku": "SKU003",
    "stock": 50
  }
]

📄 License

This project is for learning and resume showcase purposes.

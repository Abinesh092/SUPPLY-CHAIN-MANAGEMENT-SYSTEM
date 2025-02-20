# Supply Chain Management System

This project is a **Java-based Supply Chain Management System** with MySQL as the backend.

## Features:
- Manage **Products**, **Suppliers**, and **Orders**.
- GUI built with **Java Swing**.
- Database connectivity using **MySQL JDBC Connector**.

## Setup Instructions:

1. Install MySQL and create the database using:
   ```sql
   source database/supply_chain_db.sql;
   ```

2. Add `mysql-connector-java.jar` in the `lib/` folder.

3. Compile and run:
   ```sh
   javac -cp ".:lib/mysql-connector-java.jar" src/*.java
   java -cp ".:lib/mysql-connector-java.jar" src.MainMenu
   ```

Enjoy your **Supply Chain Management System**! 🚀

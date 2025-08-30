# Hashira Assignment – Polynomial Solver

This project implements a **polynomial solver** that reconstructs a polynomial from its given roots.  
The roots are provided in **JSON format**, and each root is expressed in different number bases.  
The program reads the JSON input, converts all roots into decimal, and solves for the polynomial coefficients.

---

## 📌 Problem Statement

- **Input**: JSON file containing:
  - `n`: number of roots provided
  - `k`: minimum number of roots required (`k = m + 1`, where `m` is the degree of the polynomial)
  - Roots: given by `"base"` and `"value"`
- **Output**:
  - Polynomial coefficients
  - Wrong Data Set Points (roots not used because they exceed the required `k`)

---

## 🛠️ Tech Stack

- **Language**: Java  
- **Libraries**: [Gson](https://github.com/google/gson) (for JSON parsing)  
- **JDK**: Java 11+  

---
## ▶️ How to Run

1. **Clone the repo**

   ```bash
   git clone https://github.com/Aak54321/Hashira_Assignment.git
   cd Hashira_Assignment
   ```
3. **Compile**
  ```bash
  javac -cp gson-2.10.1.jar PolynomialSolver.java
  ```
3. **Run**
   ```bash
   java -cp gson-2.10.1.jar:src PolynomialSolver
   ```

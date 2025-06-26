<div align="center">
  <h1>🏪 Welcome to the EasyPeasyShop! 🛒</h1>

  <img src="https://github.com/user-attachments/assets/d52544aa-2bad-45d9-9e14-c82a62965f64" alt="PixelShopArt" width="600"/>
</div>



# 📖 About The Project

## Project Description:
This project is an e-commerce application (online store), named EasyPeasyShop. We are given an existing, operational website that uses a Spring Boot API project for the backend server with a MySQL database for data storage. We were given the existing project code to modify, along with starter code that included the database script for the existing data structure. I made code changes in the API starter project, so Postman was used to test the application endpoints and logic. 

# ✍️ Application Requirements: 
Version 1 of this website allows users to browse products in various categories, 
add them to a shopping cart and check out to order the products. All of the 
features of the UI are fully functional. The changes and development will only 
need to be done in the backend Spring Boot Java API project. 
- Existing API Includes:
  - User registration and login
  - The ability to display products by category
  - Search for or filter the products list

## 🐞 Bugs:
The API code I began with was functional, but there were a few bugs in the project. I was tasked with:

  - Finding and fixing those bugs
  - Using manual debugging
  - Writing unit tests to help fix those bugs
---

# ✔️ Phases:
- ## Phase 1️⃣: CategoriesController
**The *CategoriesController* class has been created, but none of the methods have been implemented yet. I have to implement the code for each function and add the proper annotations in the controller.**
  - Only administrators (users with the ADMIN role) should be allowed to insert, update or delete a category.
  - The *MySqlCategoriesDao* also has all necessary functions defined, but you 
need to write the code to implement the functions.
  - The *Category* model has been defined



https://github.com/user-attachments/assets/889ee74b-2ced-40b6-bbd7-280f5e20879c


   
- ## Phase 2️⃣: Fix Bugs
**The *ProductsController* endpoint is fully implemented with necessary methods.**
  - **Bug 1:**
    - Users have reported that the product search functionality is returning incorrect 
results. I tested the search logic to find and fix the bug(s).
  - **Bug 2:**
    - Some users have also noticed that some of the products seem to be duplicated. 
For example, a laptop is listed 3 times, and it appears to be the same product, but 
there are slight differences, such as the description or the price.  
If you look at the 3 laptops you notice that they are the same product. This laptop 
has been edited twice, the first time you updated the price, the second update 
was to the description. It appears that instead of updating the product, each time 
you tried to update, it added a new product to the database.
    - I needed to find this bug and fix it so that administrators can safely update 
products. 

---
# 🖼️ Images?


---

# 👩‍💻 Interesting Piece of Code


---

# 🌱 Resources
- YearUp instructor  
- Fellow YearUp peers  
- Java Bootcamp Workbooks and past exercises  
- [Java Trainer Remsey](https://chatgpt.com/g/g-6800332fde008191822e81c0f54c8321-java-trainer-remsey)  
- Google Search  
- GitHub  

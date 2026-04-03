# DataScrap Automation Framework 🚀

## 📌 Project Overview

This project is a Selenium-based automation framework designed to extract market data from the EPEX Spot website and generate structured output in CSV format.

The framework follows a clean architecture using Page Object Model (POM) and TestNG for test execution.

---

## 🛠 Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven (optional)
* Eclipse IDE

---

## 📊 Features

* Automated data extraction from web tables
* Handles dynamic table structures
* Generates CSV reports with:

  * Hours
  * Low (£/MWh)
  * High (£/MWh)
  * Last (£/MWh)
  * Weight Avg (£/MWh)
* Page Object Model implementation
* Reusable test structure

---

## 📂 Project Structure

```
DataScrap/
│── src/
│   ├── main/java/
│   │   ├── PagePackage/
│   │   │   └── HomePage.java
│   │   ├── utility/
│   │   │   └── Baseclass.java
│   │
│   ├── test/java/
│   │   └── TestPackage/
│   │       └── HomeTest.java
│
│── output.csv
│── testng.xml
│── pom.xml (if using Maven)
│── README.md
```

---

## 🚀 How to Run

### 1️⃣ Clone the repository

```
git clone https://github.com/your-username/DataScrap.git
```

### 2️⃣ Open in Eclipse

* Import as existing Java project

### 3️⃣ Run Test

* Right click on `HomeTest.java`
* Run as → TestNG Test

---

## 📁 Output

* Extracted data will be stored in:

```
output.csv
```

---

## ⚠️ Notes

* Ensure Chrome browser is installed
* ChromeDriver is managed via WebDriverManager
* Internet connection required for data scraping
---

## 👩‍💻 Author

Priya Tayal
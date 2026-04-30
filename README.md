# Opencart V1.2.2 Cucumber BDD Automation Framework

A comprehensive **Behavior-Driven Development (BDD)** test automation framework for OpenCart v1.2.2 using Cucumber, Selenium WebDriver, and Java.

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Framework Architecture](#framework-architecture)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Project Structure](#project-structure)
- [Key Components](#key-components)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Reporting](#reporting)
- [Technologies Used](#technologies-used)
- [Key Features](#key-features)

---

## 🎯 Project Overview

This project is a **Selenium-based test automation framework** for OpenCart v1.2.2 using the Cucumber BDD approach. It enables QA teams to write test scenarios in Gherkin syntax (plain English) and execute them programmatically using Java and Selenium WebDriver.

**Key Highlights:**
- BDD approach for better test documentation and stakeholder communication
- Page Object Model (POM) for maintainable test code
- Parallel test execution (3 threads)
- Multi-browser support (Chrome, Firefox, Edge)
- Multiple execution environments (Local, Remote/Selenium Grid, LambdaTest cloud)
- Comprehensive logging with Log4j
- Advanced reporting (ExtentReports, Allure Reports)
- Cross-platform support (Windows, Linux, macOS)

---

## 🏗️ Framework Architecture

The framework follows a layered architecture:

```
┌─────────────────────────────────────┐
│        Feature Files (Gherkin)      │
├─────────────────────────────────────┤
│     Step Definitions (Cucumber)     │
├─────────────────────────────────────┤
│       Page Object Model (POM)       │
├─────────────────────────────────────┤
│     Base Class & Utilities          │
├─────────────────────────────────────┤
│      Selenium WebDriver             │
└─────────────────────────────────────┘
```

---

## 📦 Prerequisites

Before setting up the project, ensure you have:

- **Java Development Kit (JDK)**: 11 or higher
- **Maven**: 3.8.0 or higher
- **Git**: For version control
- **IDE**: Eclipse, IntelliJ IDEA, or VS Code
- **Browsers**: Chrome, Firefox, or Edge (for local execution)

---

## 🚀 Installation & Setup

### Step 1: Clone the Repository

```bash
git clone https://github.com/AnuragPatel94/Opencart_V122_Cucumber.git
cd Opencart_V122_Cucumber
```

### Step 2: Install Dependencies

```bash
mvn clean install
```

### Step 3: Configure Properties

Update the configuration file with your environment details (execution environment, browser, OS, URLs, etc.)

### Step 4: Run Tests

```bash
mvn test
```

---

## 📂 Project Structure

```
Opencart_V122_Cucumber/
│
├── src/test/
│   ├── java/
│   │   ├── base/
│   │   │   └── BaseClass.java              # WebDriver initialization & common setup
│   │   │
│   │   ├── pageobjects/
│   │   │   └── LoginPage.java              # Page Object Model for Login page
│   │   │
│   │   ├── stepDefinitions/
│   │   │   └── Login.java                  # Step definitions for login scenarios
│   │   │
│   │   ├── hooks/
│   │   │   └── Hooks.java                  # Cucumber hooks (Before/After)
│   │   │
│   │   ├── testRunner/
│   │   │   └── ParallelRunner.java         # Test execution runner
│   │   │
│   │   └── utilities/
│   │       └── *.java                      # Utility classes (ConfigReader, etc.)
│   │
│   └── resources/
│       └── features/                       # Feature files (.feature)
│
├── pom.xml                                 # Maven dependencies & plugins
├── README.md                               # This file
└── logs/                                   # Test execution logs
```

---

## 🔧 Key Components

### 1. **BaseClass.java** - Foundation Layer

**Purpose**: Central configuration and WebDriver management

**Key Features**:
- Thread-safe WebDriver instance using ThreadLocal
- Support for multiple browsers (Chrome, Firefox, Edge)
- Multi-environment execution:
  - **Local**: Direct browser driver execution
  - **Remote**: Selenium Grid execution
  - **LambdaTest**: Cloud-based testing
- Automatic driver initialization with implicit/explicit waits
- Cookie and cache management
- Logging support via Log4j

**Key Methods**:
```java
- initialSetup()              // Initialize WebDriver
- getDriver()                 // Get current thread's WebDriver
- quitDriver()                // Quit WebDriver and cleanup
- generateString()            // Generate random string
- generateNumber()            // Generate random numeric value
- generateAlphaNumeric()      // Generate random alphanumeric value
```

### 2. **LoginPage.java** - Page Object Model

**Purpose**: Encapsulate login page elements and interactions

**Web Elements**:
```
- Email Field (input-email)
- Password Field (input-password)
- Login Button
```

**Key Methods**:
```java
- setEmail(String email)      // Enter email with explicit wait
- setPassword(String pwd)     // Enter password with explicit wait
- clickLogin()                // Click login button with explicit wait
```

**Features**:
- Explicit waits with 10-second timeout
- Exception handling for element visibility/clickability
- Auto-clearing of fields before entering text
- Detailed error messages in console

### 3. **Hooks.java** - Test Lifecycle Management

**Purpose**: Setup and teardown operations for each scenario

**Hooks Implemented**:
```java
@Before(order=0)             // Setup: Initialize WebDriver
@After                       // Teardown: Quit WebDriver
@AfterStep                   // Capture screenshot on failure
```

**Features**:
- Automatic WebDriver initialization before each scenario
- Automatic WebDriver closure after each scenario
- Screenshot capture on test failure
- Screenshot attachment to Cucumber scenario report

### 4. **ParallelRunner.java** - Test Execution Engine

**Purpose**: Configure and execute Cucumber tests in parallel

**Configuration**:
```
- Features Path: src/test/resources/features/
- Glue Path: stepDefinitions, hooks
- Parallel Execution: 3 threads (methods)
- Test Tags: @sanity (configurable)
```

**Report Integration**:
- HTML Report
- Extent Report
- Allure Report
- Rerun failed tests

**Features**:
- Parallel test execution for faster feedback
- Tag-based test filtering (@sanity, @regression, etc.)
- Multiple report formats
- Failed test rerun capability

---

## ⚙️ Configuration

### Browser Configuration

Update the configuration file to specify:
- **Browser**: chrome, firefox, edge
- **Execution Environment**: local, remote, lambdatest
- **OS**: windows, linux, mac
- **Base URL**: OpenCart application URL

### LambdaTest Configuration

For cloud-based execution, credentials are configured in `BaseClass.java`:
```java
private static final String LT_USERNAME = "pavan.teens";
private static final String LT_ACCESS_KEY = "k1fACqdr0AbbIjITdlORsUEvpRaPDzlkVKWbFFujX5FBanPT1E";
```

### Logging Configuration

Log4j configuration via properties file includes:
- Console appender
- File appender
- Log level: DEBUG, INFO, WARN, ERROR

---

## ▶️ Running Tests

### Run All Tests

```bash
mvn test
```

### Run Specific Test Class

```bash
mvn test -Dtest=ParallelRunner
```

### Run Tests with Specific Tag

Modify `ParallelRunner.java` tags property:
```java
tags = "@sanity"              // Run only sanity tests
tags = "@regression"          // Run only regression tests
tags = "@sanity and @regression"  // Run both
tags = "@sanity or @regression"   // Run either
tags = "@sanity and not @regression"  // Sanity but not regression
```

### Run in Different Environment

Set environment variable before test execution:
```bash
export BROWSER=chrome          # or firefox, edge
export EXEC_ENV=local         # or remote, lambdatest
export OS=windows             # or linux, mac
```

---

## 📊 Reporting

### 1. **HTML Report**
Location: `reports/cucumber.html`

### 2. **Extent Report**
Configured via ExtentReports Adapter
- Enhanced HTML report with detailed screenshots
- Step-wise execution details

### 3. **Allure Report**
Configured via Allure Cucumber 7 JVM
- Visual test execution timeline
- Test history and trends
- Detailed error analysis

### 4. **Rerun Failed Tests**
Failed tests are recorded in: `target/rerun.txt`
Re-execute failed tests:
```bash
mvn test -Dtest=src/test/resources/features/@target/rerun.txt
```

---

## 🛠️ Technologies Used

| Technology | Version | Purpose |
|-----------|---------|---------|
| Selenium WebDriver | 4.26.0 | Browser automation |
| Cucumber | 7.20.1 | BDD framework |
| TestNG | 7.10.2 | Test execution framework |
| Log4j | 2.24.1 | Logging |
| Apache POI | 5.3.0 | Excel data handling |
| ExtentReports | 1.14.0 | Advanced HTML reporting |
| Allure Reports | 2.29.0 | Visual test reporting |
| Maven | 3.5+ | Build automation |
| Java | 11+ | Programming language |

---

## ✨ Key Features

✅ **BDD Approach**: Write tests in plain English using Gherkin syntax
✅ **Page Object Model**: Maintainable and scalable test code
✅ **Parallel Execution**: Execute tests in parallel for faster feedback
✅ **Multi-Browser Support**: Chrome, Firefox, Edge
✅ **Multi-Environment**: Local, Remote (Selenium Grid), LambdaTest Cloud
✅ **Cross-Platform**: Windows, Linux, macOS support
✅ **Advanced Logging**: Detailed logs via Log4j
✅ **Multiple Reports**: HTML, Extent, Allure reports
✅ **Automatic Screenshots**: Captured on test failure
✅ **Explicit Waits**: Robust element synchronization
✅ **Exception Handling**: Comprehensive error handling and messages
✅ **Thread-Safe**: ThreadLocal WebDriver for parallel execution

---

## 📝 Example Feature File

```gherkin
@sanity
Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given User navigates to OpenCart login page
    When User enters valid email and password
    And User clicks the login button
    Then User should be successfully logged in
```

---

## 🤝 Contributing

Contributions are welcome! Please follow these guidelines:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit changes (`git commit -m 'Add new feature'`)
4. Push to branch (`git push origin feature/new-feature`)
5. Open a Pull Request

---

## 📧 Support & Contact

For issues, suggestions, or contributions, please contact:
- **Author**: AnuragPatel94
- **Repository**: [Opencart_V122_Cucumber](https://github.com/AnuragPatel94/Opencart_V122_Cucumber)

---

## 📄 License

This project is open source and available under the MIT License.

---

**Last Updated**: April 30, 2026

# MediStore Automation Test - Selenium UI Testing

## 1. Introduction

This project provides automated UI testing for the MediStore pharmacy e-commerce system.

It focuses on end-to-end (E2E) testing of user workflows using Selenium WebDriver, simulating real user interactions on the deployed frontend.

The goal of this project is to ensure critical features such as authentication and navigation work correctly from the user's perspective.

---

## 2. Features

- Automated Login Test (Popup-based authentication)
- UI Interaction Testing with Selenium
- Configurable environment (local / deployed frontend)
- Stable test execution using explicit waits
- Data-testid based selectors for reliable element targeting

---

## 3. Test Scope

Current automated test scenarios include:

- User Login via popup modal
- Authentication state validation
- UI state verification after login:
  - Login button disappears
  - User menu appears

Future test coverage may include:

- Logout functionality
- Product search
- Add to cart
- Checkout flow

---

## 4. Technology Stack

- Language: Java 17
- Test Framework: JUnit 5
- Automation Tool: Selenium WebDriver
- Build Tool: Maven
- Driver Management: WebDriverManager

---

## 5. Project Structure
medistore-automation-test/
├── src/test/java/com/medistore/
│ ├── tests/ # Test cases (LoginTest, ...)
│ └── utils/ # ConfigReader, utilities
├── src/test/resources/
│ └── config.properties # Environment configuration
├── pom.xml
└── README.md

---

## 6. Configuration

Test environment is configured via `config.properties`:

```properties
base.url=http://localhost:5173
home.url=/customer/home
```

You can easily switch between:

- Local frontend
- Deployed frontend

## 7. Installation & Setup

### 7.1 Requirements

- Java 17
- Maven
- Chrome browser

### 7.2 Clone the repository

```bash
git clone https://github.com/your-username/medistore-automation-test.git
cd medistore-automation-test
```

### 7.3 Run tests

```bash
mvn test
```

Selenium will automatically:

- Open browser
- Execute test scenarios
- Validate UI behavior

---

## 8. Example Test Flow

Login automation test includes:

1. Open homepage
2. Click "Login" button
3. Enter email and password
4. Submit login form
5. Verify login success by: Checking user menu visibility

---

## 9. Best Practices Applied
- Explicit Wait (WebDriverWait) instead of Thread.sleep
- Data-testid for stable selectors
- Separation of configuration from test logic
- Clear and readable test flow

---

## 10. Future Improvements
- Apply Page Object Model (POM)
- Add more E2E scenarios (cart, order, payment)
- Integrate with CI/CD (GitHub Actions)
- Add test reporting (Allure / Extent Report)
- Cross-browser testing support

---

## 11. Notes

This project is developed as part of practical learning in software testing and automation.

It demonstrates the ability to:

- Write stable UI automation tests
- Work with real-world frontend systems
- Apply QA best practices in testing workflows

---

## 12. Related Projects
Backend: https://github.com/thvy815/MediStore_Backend
Frontend: https://github.com/thvy815/MediStore_Frontend

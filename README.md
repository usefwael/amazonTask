# Amazon Automation Testing Project

## Overview

This project contains automated test cases for verifying specific functionalities on the Amazon Egypt website using Selenium and TestNG. The primary focus is on accessing different sections (e.g., "Your Orders", "Your Addresses", and "Your Lists") and verifying that the appropriate sign-in prompts or pages are displayed.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven
- Selenium WebDriver
- TestNG
- A browser driver (e.g., ChromeDriver, GeckoDriver)

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/amazon-automation-tests.git
   cd amazon-automation-tests
2.Install dependencies:
Make sure Maven is installed, then run:
mvn clean install
3.Configure the browser driver:
Download the appropriate browser driver (e.g., EdgeDriver) and place it in your system path or specify its path in the code.

#TestCases 
1. Test Scenario 1: Login with Unregistered Email
- Navigate to Amazon.eg
- Attempt to log in with an unregistered email
- Verify that the appropriate error message is displayed

2. Test Scenario 2: Adding Items to Cart
- Navigate to Amazon.eg
- Add an item to the cart and select a quantity of 2
- Verify that the correct item, quantity, and price are displayed in the cart

3.Test Scenario  Test Access Restrictions:
- Navigate to Amazon.eg
- Verifies that accessing "Your Orders" and "Your Addresses" without being signed in prompts the user to sign in. It also checks that the "Your Lists" page is accessible.



Project Structure
-src/main/java: Contains the main codebase and utilities.
-src/test/java: Contains the test classes.

Authors
Youssef Wael - Initial work
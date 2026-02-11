#OCR API with Spring Boot & Tesseract (Kenya ID Scanning)                                                                                                                                                                                                                                                                                                                           
#Project Overview                                                                                                                                                                                                                                                                                                                                                               
This project is a simple Optical Character Recognition (OCR) REST API built using Spring Boot and Tesseract OCR (via Tess4J).
It allows users to upload an image of a document (such as a Kenyan National ID or ATM card) and receive the extracted text as a response.                                                                                                                                                                                                                                          
#Project Objective

-Learn and apply OCR technology using AI tools

-Build a minimal, runnable Spring Boot application

-Expose OCR functionality via a REST API

-Test the API using Postman

-Document the full setup and learning process clearly                                                                                                                                                    
#Technology Summary                                                                                                                     
OCR (Optical Character Recognition) is a technology that converts images containing text into machine-readable text.

#Real-world use cases:

National ID verification

Bank document processing

Insurance onboarding

KYC (Know Your Customer) systems

#This project uses:

-Tesseract OCR – an open-source OCR engine

-Tess4J – a Java wrapper for Tesseract

-Spring Boot – to expose OCR as a REST API                                                                                                                                                     
#System Requirements                                                                                                                                                                          
##Operating System

Windows 10 / 11                                                                                                                                                                       

##Tools & Technologies

Java JDK 17

Maven 3.8+

Spring Boot 3.x

IntelliJ IDEA (or any Java IDE)

Postman (for API testing)

Tesseract OCR Engine                                                                                                                                                                                                                                                                                                                                                  ⚙️ Installation & Setup
1️⃣ Install Java JDK 17

Download and install JDK 17 (Eclipse Temurin recommended).

Verify:

java -version

2️⃣ Install Apache Maven

Verify Maven installation:

mvn -v

3️⃣ Install Tesseract OCR (Required)

Download from:

https://github.com/UB-Mannheim/tesseract/wiki

Install to:

C:\Program Files\Tesseract-OCR


Ensure this folder exists:

C:\Program Files\Tesseract-OCR\tessdata

4️⃣ Clone the Project
git clone <YOUR_GITHUB_REPO_LINK>
cd ocr-demo                                                                                                                                                                             

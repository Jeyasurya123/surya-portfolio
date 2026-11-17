# Jeya Surya P - Portfolio (Spring Boot + Thymeleaf + Maven)

## Requirements
- JDK 17+
- Maven 3.9+ (or use your IDE: IntelliJ / Eclipse / VS Code)
- Internet (for Google Fonts and the devicon tech-logo CSS)

## Run
    mvn spring-boot:run
Open http://localhost:8080

## Build a runnable jar
    mvn clean package
    java -jar target/portfolio-1.0.0.jar

## Customize
- Name, about, contact, skills, projects: src/main/java/com/jeyasurya/portfolio/controller/PortfolioController.java
- Layout / sections: src/main/resources/templates/index.html
- Colors / animations: src/main/resources/static/css/style.css
- Photo: replace src/main/resources/static/images/profile.jpg (use a larger, sharper photo for best quality)
- Resume download: replace src/main/resources/static/files/Jeya_Surya_Resume.pdf
- Background video (optional): add src/main/resources/static/videos/hero.mp4

Skill icons: use a devicon class (https://devicon.dev, e.g. devicon-java-plain colored) or any emoji.

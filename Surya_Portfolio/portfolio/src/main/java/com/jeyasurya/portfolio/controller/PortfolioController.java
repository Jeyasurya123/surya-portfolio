package com.jeyasurya.portfolio.controller;

import com.jeyasurya.portfolio.model.Profile;
import com.jeyasurya.portfolio.model.Project;
import com.jeyasurya.portfolio.model.Skill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PortfolioController {

    @GetMapping("/")
    public String home(Model model) {

        Profile profile = new Profile(
                "Jeya Surya P",
                "Java Backend Developer",
                "Madurai, Tamil Nadu",
                "sjeya856@gmail.com",
                "+91 9360155051",
                "https://www.linkedin.com/in/jeya-surya1712/",
                "Java Backend Developer with ~2 years of experience building scalable, secure REST APIs "
                        + "and microservices using Java, Spring Boot and Spring Security. I work with Kafka, Redis, "
                        + "Elasticsearch, MySQL and MongoDB, and I have built AI-powered features using "
                        + "LangChain4j and the Google Gemini API."
        );

        Map<String, List<Skill>> skillGroups = new LinkedHashMap<>();
        skillGroups.put("Languages & Core", List.of(
                new Skill("Java 8+", "devicon-java-plain colored"),
                new Skill("SQL", "🗃️"),
                new Skill("JavaScript", "devicon-javascript-plain colored"),
                new Skill("Multithreading", "🧵"),
                new Skill("Collections & Streams", "📚")
        ));
        skillGroups.put("Frameworks", List.of(
                new Skill("Spring Boot", "devicon-spring-plain colored"),
                new Skill("Spring Security + JWT", "🔐"),
                new Skill("Spring Data JPA", "🗄️"),
                new Skill("Hibernate", "🐻"),
                new Skill("LangChain4j", "🤖")
        ));
        skillGroups.put("Data & Messaging", List.of(
                new Skill("MySQL", "devicon-mysql-plain colored"),
                new Skill("MongoDB", "devicon-mongodb-plain colored"),
                new Skill("Redis", "devicon-redis-plain colored"),
                new Skill("Elasticsearch", "🔍"),
                new Skill("Apache Kafka", "devicon-apachekafka-original colored")
        ));
        skillGroups.put("Tools & Concepts", List.of(
                new Skill("Git", "devicon-git-plain colored"),
                new Skill("Docker", "devicon-docker-plain colored"),
                new Skill("REST APIs", "🌐"),
                new Skill("Microservices", "🧩"),
                new Skill("WebSocket", "⚡")
        ));

        List<Project> projects = List.of(
                new Project("E-Commerce Platform",
                        "Java · Spring Boot · Microservices · Kafka · Redis · Elasticsearch",
                        List.of(
                                "Designed a distributed microservices e-commerce application with an API Gateway for centralized routing and service discovery.",
                                "Developed REST APIs for product, customer, inventory and order management.",
                                "Used Apache Kafka for asynchronous, event-driven processing of order, inventory and notification events.",
                                "Implemented Redis caching to speed up product retrieval and Elasticsearch for fast product search."
                        )),
                new Project("LLM-Powered Document Assistant",
                        "Java · Spring Boot · LangChain4j · Google Gemini",
                        List.of(
                                "Developed a full-stack AI-powered translation chat application using Java, Spring Boot and JavaScript.",
                                "Implemented user registration, login, profile management and secure authentication.",
                                "Integrated WebSocket for real-time communication and added text-to-text and voice-to-text translation.",
                                "Built REST APIs and responsive frontend interfaces integrated with Spring Boot services."
                        ))
        );

        model.addAttribute("profile", profile);
        model.addAttribute("skillGroups", skillGroups);
        model.addAttribute("marqueeSkills", skillGroups.values().stream().flatMap(List::stream).toList());
        model.addAttribute("projects", projects);
        return "index";
    }
}

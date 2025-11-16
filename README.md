# ✨ Anime Plot Generator  
A creative Spring Boot project that generates unique anime-style storylines, characters, and episode structures — all from a few simple inputs.

This is a fun yet technically solid project showing backend development, API design, templating logic, and frontend integration.

---

## 🚀 Features

### 🧠 **Backend (Spring Boot 3+)**
- REST API built using Spring Boot
- Clean layered architecture:
  - `controller`
  - `service`
  - `repository`
  - `dto`
  - `entity`
  - `util` (custom TemplateEngine)
- Generates:
  - Anime title  
  - Logline  
  - Synopsis  
  - Characters  
  - Episode list  
- Random seed system → same seed = same plot  
- Saves plot to H2 database  
- Fetch plot by ID  
- Clean JSON response

---

## 🎨 Frontend (Static HTML + JS)
- Fully custom UI  
- Glassmorphism + neon anime vibe  
- Episode grid view  
- Copy JSON  
- Copy shareable link  
- Download JSON  
- Smooth animations  
- Falling petal effect  
- Responsive layout

---

## 🗂 Project Structure
src/main/java
└── com.example.demo.anime
├── controller
├── dto
├── entity
├── repository
├── service
└── util

src/main/resources
└── static
└── index.html (frontend UI)

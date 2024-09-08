# Matrah App

## Overview
**Matrah App** is a comprehensive platform designed to help users discover venues for social outings. It serves three main user groups:
- **Users**: Discover new places to visit.
- **Venue Owners**: Manage and promote their venues.
- **Administrators**: Oversee platform functionality and manage users/venues.

The app features a user-friendly interface, personalized recommendations (to be added), and robust tools for venue management and user safety.

## Features and Functionality

### User Portal
- Venue discovery with advanced filtering.
- Personalized recommendations (future enhancement).
- User reviews and ratings.
- Booking tickets directly through the app.

### Owner Portal
- Venue creation and management.
- Dashboards for booking statistics and feedback.
- Venue promotion and analytics tools.

### Administrator Portal
- Full control over users and venues.
- User and venue approval/blocking.
- Detailed reporting and analytics.

## Technical Stack

### Frontend
- **Angular**: For a dynamic, interactive, and responsive user interface.

### Backend
- **Java Spring Boot**: Provides a scalable and robust backend infrastructure.

### Database
- **MySQL**: Manages relational data storage with reliability.
- **Redis**: Provides caching for frequently accessed data, boosting performance.

### Testing
- **Mockito** and **JUnit 5**: Follow Test-Driven Development (TDD) practices to ensure robust unit and integration testing.

### Security
- **Spring Security**: Handles user authentication and role-based access control (User, Owner, Admin).

### Development Methodology
- **Agile**: The project follows an Agile development approach, with regular sprints and iterative delivery to ensure continuous improvement and adaptation.

### Future Enhancements
- **Recommender System**: Using **Apache Mahout** for collaborative filtering to provide personalized venue suggestions.
- **Docker**: Future deployment will include Docker for containerization and Kubernetes for orchestration.

## Optimization Techniques

### 1. **Database Indexing**
Indexes are applied on frequently queried fields such as `venue_name`, `city`, and `category`, drastically improving lookup times and database performance, particularly for venue searches and filtering.

### 2. **Pagination**
Pagination is used for venue listings, reviews, and bookings to prevent overloading the system with large data sets. By loading only a subset of data at a time, memory usage is minimized, and navigation is quicker.

### 3. **Caching (Redis)**
Redis is utilized for caching frequently accessed data like venue details and recommendations, significantly reducing the database load and ensuring quicker response times.

### 4. **Monolithic Architecture**
The app is currently built as a monolithic application, meaning all components (User, Owner, Admin portals) are part of a single application. While this simplifies deployment and testing, plans for a transition to microservices in the future will allow for better scalability and maintainability.

## Development Plan

The development is split into multiple phases:

- **Phase 1**: Requirement gathering and analysis (2 weeks)
- **Phase 2**: Design and architecture (4 weeks)
- **Phase 3**: Development (12 weeks)
  - User Portal (4 weeks)
  - Owner Portal (4 weeks)
  - Administrator Portal (4 weeks)
- **Phase 4**: Testing (4 weeks)
- **Phase 5**: Deployment and launch (2 weeks)

## Market Analysis

**Matrah App** distinguishes itself from competitors such as Yelp and TripAdvisor through its personalized recommendation engine (coming soon), powerful venue owner tools, and strong administrative controls, making it an all-in-one platform for users, venue owners, and administrators.

## Risk Management

- **Development Delays**: Managed through Agile methodologies with regular sprint reviews and adjustments.
- **Security Vulnerabilities**: Handled by implementing comprehensive security measures, including regular audits and monitoring.

## Future Plans

1. **Recommender System**: Implement Apache Mahout for personalized venue suggestions.
2. **Docker & Kubernetes**: Deploy the application using Docker for containerization and Kubernetes for orchestration.
3. **Microservices Architecture**: Transitioning from a monolithic architecture to microservices to improve scalability and manageability.

-- Create the database
CREATE DATABASE matrah_app;

-- Use the database
USE matrah_app;

-- Create Users table
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    role ENUM('User', 'Owner', 'Admin') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    is_banned BOOLEAN DEFAULT FALSE
);

-- Add indexes to Users table
CREATE INDEX idx_users_username ON Users(username);
CREATE INDEX idx_users_email ON Users(email);
CREATE INDEX idx_users_role ON Users(role);

-- Create Cities table
CREATE TABLE Cities (
    city_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    state VARCHAR(255),
    countrycities VARCHAR(255)
);

-- Add indexes to Cities table
CREATE INDEX idx_cities_name ON Cities(name);

-- Create Areas table
CREATE TABLE Areas (
    area_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    city_id INT,
    FOREIGN KEY (city_id) REFERENCES Cities(city_id)
);

-- Add indexes to Areas table
CREATE INDEX idx_areas_name ON Areas(name);
CREATE INDEX idx_areas_city_id ON Areas(city_id);


-- Create Venues table
CREATE TABLE Venues (
    venue_id INT AUTO_INCREMENT PRIMARY KEY,
    owner_id INT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    category VARCHAR(255),
    address VARCHAR(255),
    city_id INT,
    area_id INT,
    latitude DOUBLE,
    longitude DOUBLE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    is_suspended BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (owner_id) REFERENCES Users(user_id),
    FOREIGN KEY (city_id) REFERENCES Cities(city_id),
    FOREIGN KEY (area_id) REFERENCES Areas(area_id)
);

-- Add indexes to Venues table
CREATE INDEX idx_venues_name ON Venues(name);
CREATE INDEX idx_venues_category ON Venues(category);
CREATE INDEX idx_venues_city_id ON Venues(city_id);
CREATE INDEX idx_venues_area_id ON Venues(area_id);

-- Create Services table
CREATE TABLE Services (
    service_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- Add index to Services table
CREATE INDEX idx_services_name ON Services(name);

-- Create VenueServices table (join table for many-to-many relationship between Venues and Services)
CREATE TABLE VenueServices (
    venue_id INT,
    service_id INT,
    PRIMARY KEY (venue_id, service_id),
    FOREIGN KEY (venue_id) REFERENCES Venues(venue_id),
    FOREIGN KEY (service_id) REFERENCES Services(service_id)
);

-- Add indexes to VenueServices table
CREATE INDEX idx_venueservices_venue_id ON VenueServices(venue_id);
CREATE INDEX idx_venueservices_service_id ON VenueServices(service_id);

-- Create Bookings table
CREATE TABLE Bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    venue_id INT,
    booking_date DATE NOT NULL,
    status ENUM('Confirmed', 'Cancelled', 'Completed') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (venue_id) REFERENCES Venues(venue_id)
);

-- Add indexes to Bookings table
CREATE INDEX idx_bookings_user_id ON Bookings(user_id);
CREATE INDEX idx_bookings_venue_id ON Bookings(venue_id);
CREATE INDEX idx_bookings_status ON Bookings(status);

-- Create Reviews table
CREATE TABLE Reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    venue_id INT,
    rating INT NOT NULL CHECK (rating >= 1 AND rating <= 5),
    comment TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (venue_id) REFERENCES Venues(venue_id)
);

-- Add indexes to Reviews table
CREATE INDEX idx_reviews_user_id ON Reviews(user_id);
CREATE INDEX idx_reviews_venue_id ON Reviews(venue_id);
CREATE INDEX idx_reviews_rating ON Reviews(rating);

-- Create Reports table
CREATE TABLE Reports (
    report_id INT AUTO_INCREMENT PRIMARY KEY,
    owner_id INT,
    user_id INT,
    reason TEXT,
    status ENUM('Pending', 'Approved', 'Rejected') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (owner_id) REFERENCES Users(user_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Add indexes to Reports table
CREATE INDEX idx_reports_owner_id ON Reports(owner_id);
CREATE INDEX idx_reports_user_id ON Reports(user_id);
CREATE INDEX idx_reports_status ON Reports(status);

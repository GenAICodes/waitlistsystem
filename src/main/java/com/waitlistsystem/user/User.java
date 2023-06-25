
    package com.waitlistsystem.user;
    import javax.persistence.*;
    import java.sql.Timestamp;
    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String email;
        private Timestamp registrationTime;
        // Constructors, getters, and setters
        public User() {}
        public User(String email, Timestamp registrationTime) {
            this.email = email;
            this.registrationTime = registrationTime;
        }
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public Timestamp getRegistrationTime() {
            return registrationTime;
        }
        public void setRegistrationTime(Timestamp registrationTime) {
            this.registrationTime = registrationTime;
        }
    }

package miu.edu.Lab12PartC;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    @NotBlank
    private String name;

    @NotBlank
    private String version;

    @NotBlank
    private String url;

    private String serverName;

    @Valid
    private User user;

    @Size(min = 1)
    private List<String> countries;

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public static class User {
        private String firstname;
        private String lastname;

        @NotBlank
        @Size(min = 8, max = 15)
        private String username;

        @NotBlank
        @Size(min = 8, max = 15)
        private String password;

        // Getters and setters

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public void print() {
        System.out.println("Application Name: " + getName());
        System.out.println("Version: " + getVersion());
        System.out.println("Server URL: " + getUrl());
        System.out.println("Server Name: " + getServerName());
        System.out.println("User Firstname: " + getUser().getFirstname());
        System.out.println("User Lastname: " + getUser().getLastname());
        System.out.println("User Username: " + getUser().getUsername());
        System.out.println("User Password: " + getUser().getPassword());
        System.out.println("Countries: " + String.join(", ", getCountries()));
    }
}

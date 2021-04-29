package com.hms.response;

public class JwtResponse {
    private String token;
    private String type = "Bearer ";
    private Long id;

    private String email;
    private String roles;
    private String phone;
    private String firstName;
    private String lastName;
    private String cin;
    private String adresse;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public JwtResponse(String accessToken, Long id, String email, String roles , String phone,
                       String firstName, String lastName, String cin, String adresse)
    {
        this.token = accessToken;
        this.id = id;

        this.email = email;
        this.roles = roles;
        this.phone=phone;
        this.firstName=firstName;
        this.lastName=lastName;
        this.cin=cin;
        this.adresse=adresse;

    }


    public String getAccessToken() { return token; }

    public void setAccessToken(String accessToken) { this.token = accessToken; }

    public String getTokenType() {   return type; }

    public void setTokenType(String tokenType) {   this.type = tokenType;  }

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


    public String getRoles() { return roles; }
}

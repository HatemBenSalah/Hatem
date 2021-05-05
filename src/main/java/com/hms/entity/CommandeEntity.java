package com.hms.entity;


import javax.persistence.*;

@Entity
@Table(name = "COMMANDE")
public class CommandeEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private UserEntity user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADRESSE")
    private String adresse;
    @Column(name = "NAMESERVICE")
    private String nameservice;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "PANNE_DESCRIPTION")
    private String pannedescription;
    @Column(name = "STATE")
    private String state;
    @Column(name = "DATE_DEMMANDE")
    private String datedemmande;




//
   public void setUser(UserEntity user) {
        this.user = user;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNameservice() {
        return nameservice;
    }

    public void setNameservice(String nameservice) {
        this.nameservice = nameservice;
    }

    public String getPannedescription() {
        return pannedescription;
    }

    public void setPannedescription(String pannedescription) {
        this.pannedescription = pannedescription;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDatedemmande() {
        return datedemmande;
    }

    public void setDatedemmande(String datedemmande) {
        this.datedemmande = datedemmande;
    }
}

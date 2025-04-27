package com.example.ISTE240_Project.Models;


import jakarta.persistence.*;

@Entity
@Table(name="USER")
public class User {

    /* DECLARED FIELDS */
    @Id
    private String email;

    @Column(name="Display_Name", length = 50, nullable = false)
    private String displayName;

    @Column(name="User_Name", length = 50, nullable = false)
    private String username;

    @Column(name="Password", length = 120, nullable = false)
    private String password;

    @Column(name="Bio", length = 120, nullable = false)
    private String bio;

    @Lob /* Tells JPA that image will store large binary data */ 
    @Column(columnDefinition = "LONGBLOB") /* Makes the database create a column with the type Longblob, which holds large binary data */ 
    private byte[] image;

    /* GETTERS */

    public String getDisplayName() {return displayName; }

    public String getUsername() { return username;}

    public String getEmail() {   return email; }

    public String getPassword() {    return password; }

    public String getBio(){return bio;}

    public byte[] getImage() {return image;}

    /* SETTERS */
    public void setDisplayName(String displayName) {this.displayName = displayName;}

    public void setUsername(String username) {this.username = username;}
  
    public void setEmail(String email) {  this.email = email;   }

    public void setPassword(String password) {    this.password = password;  }

    public void setBio(String bio){this.bio=bio;}

    public void setImage(byte[] image){this.image=image;}


}

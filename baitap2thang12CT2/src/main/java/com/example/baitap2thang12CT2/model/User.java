package com.example.baitap2thang12CT2.model;

imprt javax.persistence.*;

import org.hibernate.processor.xml.jaxb.GenerationType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fullname;
    private String email;
    private String phone;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY) // Lazy loading có thể gây vấn đề nếu session không còn
    @JoinTable(
        name = "user_category", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;  // Quan hệ nhiều nhiều với Category

    // Constructor không tham số
    public User() {}

    // Constructor có tham số
    public User(String fullname, String email, String phone, String password, List<Category> categories) {
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.categories = categories;
    }

    // Getter and Setter cho tất cả các thuộc tính
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    // Thêm phương thức toString() nếu cần thiết để debug
    @Override
    public String toString() {
        return "User{id=" + id + ", fullname='" + fullname + "', email='" + email + "', phone='" + phone + "'}";
    }
}

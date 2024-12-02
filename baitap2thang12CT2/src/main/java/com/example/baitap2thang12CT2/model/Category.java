package com.example.baitap2thang12CT2.model;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;       // Tên của category
    private String images;     // Đường dẫn hoặc tên của hình ảnh liên quan đến category

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private List<User> users;  // Quan hệ ngược lại với User, mappedBy chỉ ra tên thuộc tính đối diện trong User

    // Constructor không tham số
    public Category() {}

    // Constructor có tham số
    public Category(String name, String images) {
        this.name = name;
        this.images = images;
    }

    // Getter and Setter cho tất cả các thuộc tính
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    // Thêm phương thức toString() nếu cần thiết
    @Override
    public String toString() {
        return "Category{id=" + id + ", name='" + name + "', images='" + images + "'}";
    }
}

package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//--------------Lombok ------------------
@Data
@NoArgsConstructor
@AllArgsConstructor
//---------------------------------------
@Entity
//@Entity(name = "CustomerDetail")

@Table(name = "customer")
public class Customer {
    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String address;

    @Column(nullable = false)
    private double salary;
}

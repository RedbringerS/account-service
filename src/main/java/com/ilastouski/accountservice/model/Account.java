package com.ilastouski.accountservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @ManyToOne
    @JoinColumn(name =  "user_id", nullable = false)
    private User user;

    private BigDecimal balance;
    private String currency;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions;
}
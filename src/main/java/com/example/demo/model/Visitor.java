package com.example.demo.model;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visitor {

    @Id @GeneratedValue
    private Long id;

    private String fullName;
    private String email;
    private String phone;
    private String idProof;
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        if (phone == null) throw new RuntimeException("phone required");
        createdAt = LocalDateTime.now();
    }
}

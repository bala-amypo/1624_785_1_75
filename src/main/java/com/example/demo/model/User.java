package com.example.demo.model;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    @ElementCollection
    private Set<String> role;
}

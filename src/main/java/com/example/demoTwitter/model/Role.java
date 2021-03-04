package com.example.demoTwitter.model;

import lombok.*;
import javax.persistence.*;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "role_id")
        private Long id;
        private String role;
    }
}

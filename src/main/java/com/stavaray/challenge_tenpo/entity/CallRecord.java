package com.stavaray.challenge_tenpo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "call_record")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CallRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int num1;
    private int num2;
    private double percentage;
    private double total;
    private Instant timestamp;
}

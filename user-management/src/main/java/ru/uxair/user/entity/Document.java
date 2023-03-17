package ru.uxair.user.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "documents")
@Data
@ToString(exclude = {"id", "createdAt", "updatedAt"})
@EqualsAndHashCode()
@NoArgsConstructor
@RequiredArgsConstructor
public class Document {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "passenger") // Temporary as plug
//    @OneToOne()
//    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    @NonNull
    private String passenger; // Temporary type String as plug, ToDo: Passenger type

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @NonNull
    private DocumentType type;

    @Column(name = "number")
    @NonNull
    private long number;

    @Column(name = "expiry_date")
    @NonNull
    private LocalDate expiryDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "is_default")
    @NonNull
    private Boolean isDefault;
}

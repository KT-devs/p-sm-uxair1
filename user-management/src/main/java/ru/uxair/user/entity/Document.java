package ru.uxair.user.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "documents")
@Data
@ToString(exclude = {"id", "createdAt", "updatedAt"})
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@RequiredArgsConstructor
public class Document {
    @Id
    @Column(name = "id")
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "passenger") // Temporary as plug
//    @OneToOne()
//    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    @NotEmpty(message = "Input passenger")
    @NonNull
    private String passenger; // Temporary type String as plug, ToDo: Passenger type

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Select document type")
    @NonNull
    private DocumentType type;

    @Column(name = "number")
    @NotNull(message = "Input document number")
    @NonNull
    private Long number;

    @Column(name = "expiry_date")
    @NotNull(message = "Input document expire date DD.MM.YYYY")
    @NonNull
    private LocalDate expiryDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "is_default")
    @NotNull(message = "Document is default?")
    @NonNull
    private Boolean isDefault;
}

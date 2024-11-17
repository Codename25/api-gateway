package start.up.apigateway.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "\"user\"")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(sequenceName = "user_id_seq", name = "user_id_seq", allocationSize = 1)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    @Column(name = "is_letter_recipient")
    private boolean isLetterRecipient;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}

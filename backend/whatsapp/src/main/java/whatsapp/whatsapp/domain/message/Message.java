  package whatsapp.whatsapp.domain.message;

  import java.time.LocalDateTime;
  import java.util.UUID;

  import org.hibernate.annotations.CreationTimestamp;
  import org.hibernate.annotations.UpdateTimestamp;

  import jakarta.persistence.Column;
  import jakarta.persistence.Entity;
  import jakarta.persistence.EnumType;
  import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType;
  import jakarta.persistence.Id;
  import jakarta.persistence.JoinColumn;
  import jakarta.persistence.ManyToOne;
  import jakarta.persistence.Table;
  import lombok.AccessLevel;
  import lombok.EqualsAndHashCode;
  import lombok.Getter;
  import lombok.NoArgsConstructor;
  import lombok.Setter;
  import whatsapp.whatsapp.domain.user.User;

  @Entity
  @Table(name = "messages")
  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  @EqualsAndHashCode(of = "id")
  public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Setter
    @Column(nullable = false, length = 1000)
    private String content;

    @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MessageStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, name = "author_id")
    private User author;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Message(String content,
                    User author
    ) {
      this.content = content;
      this.status = MessageStatus.SENT;
      this.author = author;
    }
  }

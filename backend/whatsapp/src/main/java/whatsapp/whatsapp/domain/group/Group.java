package whatsapp.whatsapp.domain.group;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import whatsapp.whatsapp.domain.message.Message;
import whatsapp.whatsapp.domain.user.User;

@Entity
@Table(name = "groups")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class Group {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Setter
  @Column(nullable = false, length = 50)
  private String name;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Message> messages = new HashSet<>();

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "group_member",
    joinColumns = @JoinColumn(nullable = false, name = "group_id"),
    inverseJoinColumns = @JoinColumn(nullable = false, name = "member_id")
  )
  private Set<User> members = new HashSet<>();

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public Group(String name) {
    this.name = name;
  }

  public void addMessage(Message message) {
    this.messages.add(message);
  }

  public void removeMessage(Message message) {
    this.messages.remove(message);
  }

  public void addMembers(Set<User> members) {
    this.members.addAll(members);
  }

  public void removeMembers(Set<User> members) {
    this.members.removeAll(members);
  }
}

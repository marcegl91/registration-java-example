package wolox.examples.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.google.common.base.Preconditions;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import wolox.examples.services.PasswordEncoderService;

/**
 * Model for users
 *
 * @author M. G.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    private String username;

    @NotNull
    private String name;

    @NotNull
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    @NotNull
    private LocalDate birthDate;

    public User() {
    }

    public User(long id, String username, String name, LocalDate birthDate, String password) {
        this.id = id;
        setUsername(username);
        setName(name);
        setBirthDate(birthDate);
        setPassword(password);
    }

    public User(String username, String name, LocalDate birthDate, String password) {
        setUsername(username);
        setName(name);
        setBirthDate(birthDate);
        setPassword(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        Preconditions.checkArgument(username != null && !username.isEmpty());

        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Preconditions.checkArgument(name != null && !name.isEmpty());

        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Preconditions.checkArgument(password != null && !password.isEmpty());

        this.password = PasswordEncoderService.encode(password);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        Preconditions.checkArgument(birthDate != null && birthDate.isBefore(LocalDate.now()));

        this.birthDate = birthDate;
    }
}

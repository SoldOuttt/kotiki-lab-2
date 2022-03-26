package entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Value
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@ToString(of = {"id", "fullName"})
public class CatOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(nullable = false)
	String fullName;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	Date dayOfBirth;

	@Column(nullable = false)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ownerId")
	@Singular
	Set<Cat> cats;
}

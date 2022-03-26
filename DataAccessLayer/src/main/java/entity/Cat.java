package entity;

import entity.additional_info.CatColor;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Value
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@ToString(of = {"id", "name"})
public class Cat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(nullable = false)
	String name;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	Date dayOfBirth;

	@Column(nullable = false)
	String breed;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	CatColor color;

	@Singular("oneFriend")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="catFriends",
			joinColumns=@JoinColumn(name="catId"),
			inverseJoinColumns=@JoinColumn(name="friendId")
	)
	Set<Cat> friends;

	@Singular("oneFriendOf")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="catFriends",
			joinColumns=@JoinColumn(name="friendId"),
			inverseJoinColumns=@JoinColumn(name="catId")
	)
	Set<Cat> friendOf;
}

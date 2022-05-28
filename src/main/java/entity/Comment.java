package entity;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;


@Entity
@Table(name = "comments")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Post post;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User creator;

    @Column
    private String comment;
}

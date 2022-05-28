package entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private User creator;

    @OneToMany(mappedBy = "post")
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<Comment> comments;
}

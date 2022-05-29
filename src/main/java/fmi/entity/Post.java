package fmi.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User creator;

    @OneToMany(mappedBy = "post")
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<Comment> comments;
}

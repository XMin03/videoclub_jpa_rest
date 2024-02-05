package org.iesvdm.videoclub.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "tutorial",
        schema="videoclub_jpa",
        indexes={@Index(name = "title_index",columnList = "title")}
)
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title",length = 50)
    private String titulo;
    @Column(name = "description",length = 150,nullable = false)
    private String description;
    @Column(name = "publi")
    private boolean published;
    @Column(nullable = false)
    private Date fechaPublicacion;

    @OneToMany(mappedBy = "tutorial")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Comentario> comments;
}

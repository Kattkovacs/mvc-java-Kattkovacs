package spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.dao.Status;


import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ToDo {
    @Column(nullable = false)
    private String title;

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    public static ToDo create(String title){
        return ToDo.builder().title(title).status(Status.ACTIVE).build();
    }

    public boolean isCompleted() { return this.status == Status.COMPLETE;}
}

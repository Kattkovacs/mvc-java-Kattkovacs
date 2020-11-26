package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import spring.dao.Status;
import spring.entity.ToDo;

import javax.transaction.Transactional;
import java.util.List;

public interface ToDoRepository extends JpaRepository <ToDo, Long> {

    ToDo findToDoById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE ToDo t set t.title = :title WHERE t.id = :id")
    void updateTitle(Long id, String title);


    @Modifying
    @Transactional
    @Query("UPDATE ToDo t set t.status = :status WHERE t.id = :id")
    void updateStatus(Long id, Status status);

    @Modifying
    @Transactional
    void removeToDoByStatusIs(Status status);

    @Modifying
    @Transactional
    @Query("UPDATE ToDo t set t.status = :status")
    void updateAllStatuses(Status status);

    List<ToDo> findByStatusIs(Status status);
}

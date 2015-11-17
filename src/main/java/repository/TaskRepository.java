package repository;

import entity.Tasks;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Kate on 15.11.2015.
 */
@Repository
@Transactional
public class TaskRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public TaskRepository() {
    }

    public void addTask(Tasks tasks){
        this.sessionFactory.getCurrentSession().save(tasks);
    }

    public List<Tasks> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Tasks").list();
    }

    public void removeTask(Integer id){
        Tasks tasks = (Tasks) this.sessionFactory.getCurrentSession().load(Tasks.class, id);
        if (tasks != null){
            this.sessionFactory.getCurrentSession().delete(tasks);
        }
    }

}

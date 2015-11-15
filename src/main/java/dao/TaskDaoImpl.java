package dao;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import entity.Tasks;
/**
 * Created by Kate on 15.11.2015.
 */
@Transactional
public class TaskDaoImpl implements TaskDao{

    @Autowired
    private HibernateTemplate  hibernateTemplate;
    public void saveTask() {
        Tasks tasks = new Tasks();
        tasks.setName("Ram");
        tasks.setDescription("testDesc");
        tasks.setPriority("Middle");
        hibernateTemplate.save(tasks);
    }
}

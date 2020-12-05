import org.hibernate.SessionFactory;
import org.hsmak.hibernate.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@Transactional
public class GenericPersistenceTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void whenBootstrapHibernateSession_thenNoException() {


    }
}
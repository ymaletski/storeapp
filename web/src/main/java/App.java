
import org.joda.time.DateTime;
import org.springframework.context.support.GenericXmlApplicationContext;

import ru.mail.yura.model.Address;
import ru.mail.yura.model.Goods;
import ru.mail.yura.model.News;
import ru.mail.yura.model.User;
import ru.mail.yura.constant.Role;
import ru.mail.yura.dao.AddressDao;
import ru.mail.yura.dao.GoodsDao;
import ru.mail.yura.dao.NewsDao;
import ru.mail.yura.dao.UserDao;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	/*GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    	ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
    	ctx.refresh();
    	UserDao userDao = ctx.getBean("userDao", UserDao.class);
    	AddressDao addressDao = ctx.getBean("addressDao", AddressDao.class);
    	NewsDao newsDao = ctx.getBean("newsDao", NewsDao.class);
    	GoodsDao goodsDao = ctx.getBean("goodsDao", GoodsDao.class);
    	
    	User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setEmail("email");
        user.setPassword("password");
        user.setRole(Role.USER_ROLE);
        user.setActive(true);
                
        Address address = new Address(user, "city", "street", "num", "zipcode");
        News news = new News("caption", "content", new DateTime("2015-10-15"));
        News news1 = new News("caption1", "content1", new DateTime("2017-10-15"));
        User user1 = userDao.findByIdWithDetails(3L);
             
        
                
        user.setAddress(address);
        user.getNews().add(news);
        user1.getNews().add(news1);
        userDao.save(user);
        userDao.save(user1);
        
        
        userDao.softDelete(user);
    	for(User userInfo: userDao.findAllWithDetails()) {
    		System.out.println( userInfo );
    	}
        System.out.println( "Hello World!" );
        for(Address addressInfo: addressDao.findAllWithDetails()) {
    		System.out.println( addressInfo );
    		System.out.println( addressInfo.getUser().getFirstName() );
    	}
        for(News newsInfo: newsDao.findAll()) {
    		System.out.println( newsInfo );
    	}
        for(Goods goodsInfo: goodsDao.findAll()) {
    		System.out.println( goodsInfo );
    	}*/
    }
}

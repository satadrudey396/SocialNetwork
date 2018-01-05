package com.niit.SocialBackEndSaltlake;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.SocialBackEndSaltlake.Dao.BlogDao;
import com.niit.SocialBackEndSaltlake.Dao.BlogDaoImpl;
import com.niit.SocialBackEndSaltlake.Dao.ForumDao;
import com.niit.SocialBackEndSaltlake.Dao.ForumDaoImpl;
import com.niit.SocialBackEndSaltlake.Dao.FriendDao;
import com.niit.SocialBackEndSaltlake.Dao.FriendDaoImpl;
import com.niit.SocialBackEndSaltlake.Dao.JobsDao;
import com.niit.SocialBackEndSaltlake.Dao.JobsDaoImpl;
import com.niit.SocialBackEndSaltlake.Dao.ProfilePictureDao;
import com.niit.SocialBackEndSaltlake.Dao.ProfilePictureDaoImpl;
import com.niit.SocialBackEndSaltlake.Dao.UserDao;
import com.niit.SocialBackEndSaltlake.Dao.UserDaoImpl;
import com.niit.SocialBackEndSaltlake.Model.Blogs;
import com.niit.SocialBackEndSaltlake.Model.Forum;
import com.niit.SocialBackEndSaltlake.Model.Friend;
import com.niit.SocialBackEndSaltlake.Model.Jobs;
import com.niit.SocialBackEndSaltlake.Model.ProfilePicture;
import com.niit.SocialBackEndSaltlake.Model.UserBlogComments;
import com.niit.SocialBackEndSaltlake.Model.UserDetail;
import com.niit.SocialBackEndSaltlake.Model.UserForumComments;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class ApplicationContextConfig {
	public static Logger logger = Logger.getLogger("ApplicationContextConfig");

	public DataSource getOracleDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		driverManagerDataSource.setUsername("system");
		driverManagerDataSource.setPassword("hitesh");
		return driverManagerDataSource;
	}

	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		return properties;
	}

	@Bean
	public SessionFactory getSessionFactory() {
		LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(getOracleDataSource());
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		localSessionFactoryBuilder.addAnnotatedClass(Blogs.class);
		localSessionFactoryBuilder.addAnnotatedClass(UserForumComments.class);
		localSessionFactoryBuilder.addAnnotatedClass(Forum.class);
		localSessionFactoryBuilder.addAnnotatedClass(UserBlogComments.class);
		localSessionFactoryBuilder.addAnnotatedClass(Friend.class);
		localSessionFactoryBuilder.addAnnotatedClass(Jobs.class);
		localSessionFactoryBuilder.addAnnotatedClass(UserDetail.class);
		localSessionFactoryBuilder.addAnnotatedClass(UserDetail.class);
		localSessionFactoryBuilder.addAnnotatedClass(ProfilePicture.class);


		System.out.println("SessionFactory Bean Created");
		return localSessionFactoryBuilder.buildSessionFactory();
	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

	@Bean
	public UserDao getUserDAO(SessionFactory sessionFactory) {
		System.out.println("User DAO object Created");
		return new UserDaoImpl(sessionFactory);
	}

	@Bean
	public BlogDao getBlogDAO(SessionFactory sessionFactory) {
		System.out.println("Blog DAO object Created");
		return new BlogDaoImpl(sessionFactory);
	}
	@Bean
	public ForumDao getForumDAO(SessionFactory sessionFactory) {
		System.out.println("Forum DAO object Created");
		return new ForumDaoImpl(sessionFactory);
	}
	@Bean
	public JobsDao getJobsDAO(SessionFactory sessionFactory) {
		System.out.println("jobs DAO object Created");
		return new JobsDaoImpl(sessionFactory);
	}@Bean
	public FriendDao getFriendDAO(SessionFactory sessionFactory) {
		System.out.println("Friend DAO object Created");
		return new FriendDaoImpl(sessionFactory);
	}
	/*@Bean
	public ForumCommentsDao getForumCommentsDAO(SessionFactory sessionFactory) {
		System.out.println("ForumComments DAO object Created");
		return new ForumCommentsDaoImpl(sessionFactory);
	}
	@Bean
	public BlogCommentsDao getBlogCommentsDAO(SessionFactory sessionFactory) {
		System.out.println("BlogComments DAO object Created");
		return new BlogCommentsDaoImpl(sessionFactory);
	}*/
	@Bean
	public ProfilePictureDao getProfilePictureDAO(SessionFactory sessionFactory) {
		System.out.println("ProfilePicture DAO object Created");
		return new ProfilePictureDaoImpl(sessionFactory);
	}
}

package com.niit.SocialBackEndSaltlake.Dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialBackEndSaltlake.Model.ProfilePicture;

@Repository("profilePictureDAO")
public class ProfilePictureDaoImpl implements ProfilePictureDao {
	@Autowired
	SessionFactory sessionFactory;

	public ProfilePictureDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public boolean save(ProfilePicture profilePicture) 
	{
		try 
		{
			sessionFactory.getCurrentSession().save(profilePicture);
			return true;
		} catch (Exception e) 
		{
			System.out.println("exception arised" + e);
			return false;
		}
	}

	@Override
	public ProfilePicture getProfilePicture(String username) 
	{
		Session session = sessionFactory.openSession();
		ProfilePicture profilePicture = (ProfilePicture) session.get(ProfilePicture.class, username);
		session.close();
		return profilePicture;
	}
}

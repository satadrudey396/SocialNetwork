package com.niit.SocialBackEndSaltlake.Dao;

import com.niit.SocialBackEndSaltlake.Model.ProfilePicture;

public interface ProfilePictureDao 
{
	public boolean save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);
}

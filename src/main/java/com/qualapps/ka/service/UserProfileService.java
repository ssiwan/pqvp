package com.qualapps.ka.service;

import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.data.PqvpDao;
import com.qualapps.ka.data.UserProfileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserProfileService {
    private static final String USER_NOT_FOUND_EXCEPTION = "UserNotFoundException";

    @Autowired
    private PqvpDao pqvpdao;

    /**
     * Service to fetch a user
     * @param userName the User Name
     * @return user
     * @throws PqvpException - USer not found
     */
    public UserProfileData getUserByName(String userName) throws PqvpException{
        UserProfileData usr;
        try {
            usr = pqvpdao.getUser(userName);
        } catch (Exception e) {
            String[] params = new String[]{"UserName", userName};
            throw new PqvpException(USER_NOT_FOUND_EXCEPTION, params);
        }
        return usr;
    }

    public UserProfileData getUserById(long userProfileId) throws PqvpException{
        UserProfileData usr;
        try {
            usr = pqvpdao.getUser(userProfileId);
        } catch (Exception e) {
            String[] params = new String[]{"userProfileId", Long.toString(userProfileId)};
            throw new PqvpException(USER_NOT_FOUND_EXCEPTION, params);
        }
        return usr;
    }

    public List<UserProfileData> getAllUsers() throws PqvpException{
        List<UserProfileData> usrs;
        try {
            usrs = pqvpdao.getUser();
        } catch (Exception e) {
            String[] params = new String[]{};
            throw new PqvpException(USER_NOT_FOUND_EXCEPTION, params);
        }
        return usrs;
    }
}


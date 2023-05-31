package rikkei.academy.service;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import rikkei.academy.model.User;

@Service
public class UserService implements IUserService{
    

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

}

package rikkei.academy.service;

import org.springframework.stereotype.Service;
import rikkei.academy.model.User;

@Service
public interface IUserService {
    void saveUser(User user);

}

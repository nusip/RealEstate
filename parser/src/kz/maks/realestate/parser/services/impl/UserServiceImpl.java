package kz.maks.realestate.parser.services.impl;

import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.realestate.parser.entities.User;
import kz.maks.realestate.parser.services.UserService;

@Service
public class UserServiceImpl extends AbstractServiceImpl implements UserService {

    @Override
    public User get(Long id) {
        User user = db.load(User.class, id);
        return user;
    }

}

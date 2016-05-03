package kz.maks.realestate.parser.services.impl;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.core.shared.PasswordUtils;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.assemblers.dto.UserDtoAssembler;
import kz.maks.realestate.parser.entities.User;
import kz.maks.realestate.parser.services.UserService;
import kz.maks.realestate.shared.dtos.UserDto;
import kz.maks.realestate.shared.dtos.params.UserSearchParams;

import java.util.ArrayList;

import static kz.maks.core.back.entities.AbstractUserEntity.CREDENTIALS_FIELD;
import static kz.maks.core.back.entities.AbstractUserEntity.IDENTIFIER_FIELD;
import static org.hibernate.criterion.Restrictions.eq;

@Service
public class UserServiceImpl extends AbstractServiceImpl implements UserService {

    @Inject
    private UserDtoAssembler assembler;

    @Override
    public User get(Long id) {
        User user = db.load(User.class, id);
        return user;
    }

    @Override
    public UserDto get(String identifier, String credentials) {
        String hash = PasswordUtils.getPasswordHash(credentials);
        User user = (User) session().createCriteria(User.class)
                .add(eq(IDENTIFIER_FIELD, identifier))
                .add(eq(CREDENTIALS_FIELD, hash)).uniqueResult();
        UserDto userDto = user != null ? assembler.assemble(user, new UserDto()) : null;
        return userDto;
    }

    @Override
    public void delete(Long id) {
        db.delete(User.class, id);
    }

    @Override
    public UserDto getDto(Long id) {
        User user = db.load(User.class, id);
        UserDto userDto = assembler.assemble(user, new UserDto());
        return userDto;
    }

    @Override
    public ListResponse<UserDto> list(UserSearchParams params) {
        // TODO
        return null;
    }

    @Override
    public void save(UserDto userDto) {

    }

}

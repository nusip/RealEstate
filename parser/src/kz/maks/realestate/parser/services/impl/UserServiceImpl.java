package kz.maks.realestate.parser.services.impl;

import com.google.common.base.Strings;
import kz.maks.core.back.BackUtils;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.entities.Role;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.core.shared.PasswordUtils;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.assemblers.dto.UserDtoAssembler;
import kz.maks.realestate.parser.assemblers.entity.user.UserAssembler;
import kz.maks.realestate.parser.entities.User;
import kz.maks.realestate.parser.services.UserService;
import kz.maks.realestate.shared.dtos.UserDto;
import kz.maks.realestate.shared.dtos.params.UserSearchParams;
import kz.maks.realestate.shared.models.YesNo;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static kz.maks.core.back.entities.AbstractUserEntity.CREDENTIALS_FIELD;
import static kz.maks.core.back.entities.AbstractUserEntity.IDENTIFIER_FIELD;
import static kz.maks.core.back.entities.AbstractUserEntity.IS_ACTIVE_FIELD;
import static kz.maks.realestate.parser.entities.User.FIRST_NAME_FIELD;
import static kz.maks.realestate.parser.entities.User.ROOT_USER_IDENTIFIER;
import static org.hibernate.criterion.Restrictions.*;

@Service
public class UserServiceImpl extends AbstractServiceImpl implements UserService {

    @Inject
    private UserDtoAssembler userDtoAssembler;

    @Inject
    private UserAssembler userAssembler;

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
        UserDto userDto = user != null ? userDtoAssembler.assemble(user, new UserDto()) : null;
        return userDto;
    }

    @Override
    public void delete(Long id) {
        db.delete(User.class, id);
    }

    @Override
    public UserDto getDto(Long id) {
        User user = db.load(User.class, id);
        UserDto userDto = userDtoAssembler.assemble(user, new UserDto());
        return userDto;
    }

    @Override
    public ListResponse<UserDto> list(UserSearchParams params) {
        long rowCount = BackUtils.getRowCount(listCriteria(params));
        Criteria listCriteria = listCriteria(params);
        boolean hasNext = BackUtils.setPaginationAndSorting(listCriteria, rowCount, params);

        List<User> entityList = listCriteria.list();
        List<UserDto> dtoList = new ArrayList<>();

        for (User entity : entityList) {
            UserDto dto = userDtoAssembler.assemble(entity, new UserDto());
            dtoList.add(dto);
        }

        ListResponse<UserDto> listResponse = new ListResponse<>(dtoList, hasNext);

        return listResponse;
    }

    private Criteria listCriteria(UserSearchParams params) {
        Criteria criteria = session().createCriteria(User.class);

        criteria.add(ne(IDENTIFIER_FIELD, ROOT_USER_IDENTIFIER));

        if (!isNullOrEmpty(params.getIdentifier())) {
            criteria.add(ilike(IDENTIFIER_FIELD, params.getIdentifier(), MatchMode.ANYWHERE));
        }
        if (!isNullOrEmpty(params.getFirstName())) {
            criteria.add(ilike(FIRST_NAME_FIELD, params.getFirstName(), MatchMode.ANYWHERE));
        }
        if (params.getIsActive() != null && params.getIsActive() != YesNo.NO_MATTER) {
            if (params.getIsActive() == YesNo.YES) {
                criteria.add(eq(IS_ACTIVE_FIELD, true));

            } else if (params.getIsActive() == YesNo.NO) {
                criteria.add(or(isNull(IS_ACTIVE_FIELD), eq(IS_ACTIVE_FIELD, false)));
            }
        }

        return criteria;
    }

    @Override
    public void save(UserDto userDto) {
        User user;

        if (userDto.getId() != null) {
            user = get(userDto.getId());

        } else {
            user = new User();
        }

        userAssembler.assemble(userDto, user);

        db.save(user);
    }

    @Override
    public Role getRole(Long id) {
        Role role = db.load(Role.class, id);
        return role;
    }

}

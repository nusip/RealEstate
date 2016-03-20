package kz.maks.realestate.parser.services.remotes;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Remote;
import kz.maks.core.back.services.remotes.AbstractRemoteImpl;
import kz.maks.realestate.parser.services.UserService;
import kz.maks.realestate.shared.dtos.UserDto;
import kz.maks.realestate.shared.remotes.UserRemote;

import java.rmi.RemoteException;

@Remote
public class UserRemoteImpl extends AbstractRemoteImpl implements UserRemote {

    @Inject(proxy = true)
    private UserService userService;

    public UserRemoteImpl() throws RemoteException {}

    @Override
    public UserDto get(String identifier, String credentials)  throws RemoteException {
        return userService.get(identifier, credentials);
    }

}

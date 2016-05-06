package kz.maks.realestate.shared.remotes;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.UserDto;
import kz.maks.realestate.shared.dtos.params.UserSearchParams;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserRemote extends Remote {

    UserDto get(String identifier, String credentials) throws RemoteException;

    void delete(Long id) throws RemoteException;

    UserDto getDto(Long id) throws RemoteException;

    ListResponse<UserDto> list(UserSearchParams params) throws RemoteException;

    void save(UserDto userDto) throws RemoteException;

}

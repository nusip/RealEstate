package kz.maks.realestate.shared.remotes;

import kz.maks.realestate.shared.dtos.get.UserDto;

import java.rmi.Remote;

public interface UserRemote extends Remote {

    UserDto get(String identifier, String credentials);

}

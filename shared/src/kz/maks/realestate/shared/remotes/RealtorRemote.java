package kz.maks.realestate.shared.remotes;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.RealtorDto;
import kz.maks.realestate.shared.dtos.params.RealtorSearchParams;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RealtorRemote extends Remote {

    ListResponse<RealtorDto> list(RealtorSearchParams params) throws RemoteException;

}

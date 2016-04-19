package kz.maks.realestate.shared.remotes;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.RealtorDto;
import kz.maks.realestate.shared.dtos.params.RealtorSearchParams;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

public interface RealtorRemote extends Remote {

    ListResponse<RealtorDto> list(RealtorSearchParams params) throws RemoteException;

    List<RealtorDto> listNew(Date lastUpdatedAt) throws RemoteException;

    List<String> listRealtorsNumbers(List<String> phoneNumbers) throws RemoteException;

}

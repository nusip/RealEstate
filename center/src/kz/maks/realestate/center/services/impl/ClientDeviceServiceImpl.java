package kz.maks.realestate.center.services.impl;

import kz.maks.core.back.BackUtils;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Service;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.center.assemblers.dto.ClientDtoAssembler;
import kz.maks.realestate.center.assemblers.dto.DeviceDtoAssembler;
import kz.maks.realestate.center.assemblers.entity.ClientAssembler;
import kz.maks.realestate.center.assemblers.entity.DeviceAssembler;
import kz.maks.realestate.center.entities.Client;
import kz.maks.realestate.center.entities.Device;
import kz.maks.realestate.center.services.ClientDeviceService;
import kz.maks.realestate.shared.dtos.ClientDto;
import kz.maks.realestate.shared.dtos.DeviceDto;
import kz.maks.realestate.shared.dtos.params.ClientSearchParams;
import kz.maks.realestate.shared.dtos.params.DeviceSearchParams;
import kz.maks.realestate.shared.models.YesNo;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static org.hibernate.criterion.Restrictions.*;

@Service
public class ClientDeviceServiceImpl extends ActivationServiceImpl implements ClientDeviceService {

    @Inject
    private ClientDtoAssembler clientDtoAssembler;

    @Inject
    private ClientAssembler clientAssembler;

    @Inject
    private DeviceDtoAssembler deviceDtoAssembler;

    @Inject
    private DeviceAssembler deviceAssembler;

    @Override
    public ListResponse<ClientDto> listClients(ClientSearchParams params) {
        long rowCount = BackUtils.getRowCount(listCriteria(params));
        Criteria listCriteria = listCriteria(params);
        boolean hasNext = BackUtils.setPaginationAndSorting(listCriteria, rowCount, params);

        List<Client> entityList = listCriteria.list();
        List<ClientDto> dtoList = new ArrayList<>();

        for (Client entity : entityList) {
            ClientDto dto = clientDtoAssembler.assemble(entity, new ClientDto());
            dtoList.add(dto);
        }

        ListResponse<ClientDto> listResponse = new ListResponse<>(dtoList, hasNext);

        return listResponse;
    }

    private Criteria listCriteria(ClientSearchParams params) {
        Criteria criteria = session().createCriteria(Client.class);

        if (!isNullOrEmpty(params.getName())) {
            criteria.add(ilike("name", params.getName(), MatchMode.ANYWHERE));
        }
        if (params.getIsActive() != null && params.getIsActive() != YesNo.NO_MATTER) {
            if (params.getIsActive() == YesNo.YES) {
                criteria.add(eq("isActive", true));

            } else if (params.getIsActive() == YesNo.NO) {
                criteria.add(or(isNull("isActive"), eq("isActive", false)));
            }
        }

        return criteria;
    }

    @Override
    public Client getClient(Long id) {
        Client client = db.load(Client.class, id);
        return client;
    }

    @Override
    public ClientDto getClientDto(Long id) {
        Client client = db.load(Client.class, id);
        ClientDto clientDto = clientDtoAssembler.assemble(client, new ClientDto());
        return clientDto;
    }

    @Override
    public void saveClient(ClientDto clientDto) {
        Client client;

        if (clientDto.getId() != null) {
            client = getClient(clientDto.getId());

        } else {
            client = new Client();
        }

        clientAssembler.assemble(clientDto, client);

        db.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        db.delete(Client.class, id);
    }

    @Override
    public ListResponse<DeviceDto> listDevices(DeviceSearchParams params) {
        long rowCount = BackUtils.getRowCount(listCriteria(params));
        Criteria listCriteria = listCriteria(params);
        boolean hasNext = BackUtils.setPaginationAndSorting(listCriteria, rowCount, params);

        List<Device> entityList = listCriteria.list();
        List<DeviceDto> dtoList = new ArrayList<>();

        for (Device entity : entityList) {
            DeviceDto dto = deviceDtoAssembler.assemble(entity, new DeviceDto());
            dtoList.add(dto);
        }

        ListResponse<DeviceDto> listResponse = new ListResponse<>(dtoList, hasNext);

        return listResponse;
    }

    private Criteria listCriteria(DeviceSearchParams params) {
        Criteria criteria = session().createCriteria(Device.class);

        if (!isNullOrEmpty(params.getClientName())) {
            Criteria clientCri = criteria.createCriteria("client");
            clientCri.add(ilike("name", params.getClientName(), MatchMode.ANYWHERE));
        }
        if (!isNullOrEmpty(params.getNumber())) {
            criteria.add(ilike("number", params.getNumber(), MatchMode.ANYWHERE));
        }
        if (params.getIsActive() != null && params.getIsActive() != YesNo.NO_MATTER) {
            if (params.getIsActive() == YesNo.YES) {
                criteria.add(eq("isActive", true));

            } else if (params.getIsActive() == YesNo.NO) {
                criteria.add(or(isNull("isActive"), eq("isActive", false)));
            }
        }

        return criteria;
    }

    @Override
    public Device getDevice(Long id) {
        Device device = db.load(Device.class, id);
        return device;
    }

    @Override
    public DeviceDto getDeviceDto(Long id) {
        Device device = db.load(Device.class, id);
        DeviceDto deviceDto = deviceDtoAssembler.assemble(device, new DeviceDto());
        return deviceDto;
    }

    @Override
    public void saveDevice(DeviceDto deviceDto) {
        Device device;

        if (deviceDto.getId() != null) {
            device = getDevice(deviceDto.getId());

        } else {
            device = new Device();
        }

        deviceAssembler.assemble(deviceDto, device);

        db.save(device);
    }

    @Override
    public void deleteDevice(Long id) {
        db.delete(Device.class, id);
    }
}

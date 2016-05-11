package kz.maks.realestate.center.assemblers.dto;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.core.shared.Utils;
import kz.maks.realestate.center.entities.Client;
import kz.maks.realestate.shared.dtos.ClientDto;

import static kz.maks.core.shared.Utils.extractTitles;

@Bean
public class ClientDtoAssembler implements IAssembler<Client, ClientDto> {

    @Override
    public ClientDto assemble(Client client, ClientDto clientDto) {
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setIsActive(Boolean.TRUE.equals(client.getIsActive()));
        clientDto.setDeviceNumbers(extractTitles(client.getDevices()));
        return clientDto;
    }

}

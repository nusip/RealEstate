package kz.maks.realestate.center.assemblers.entity;

import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.realestate.center.entities.Client;
import kz.maks.realestate.center.entities.Device;
import kz.maks.realestate.shared.dtos.ClientDto;

import java.util.ArrayList;

public class ClientAssembler implements IAssembler<ClientDto, Client> {

    @Override
    public Client assemble(ClientDto clientDto, Client client) {
        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setIsActive(clientDto.getIsActive());
        return client;
    }

}

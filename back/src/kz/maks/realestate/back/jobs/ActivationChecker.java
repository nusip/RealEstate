package kz.maks.realestate.back.jobs;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.shared.Utils;
import kz.maks.realestate.back.BackRemotes;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

@Bean
public class ActivationChecker {

    public void check() {
        try {
            String macAddress = Utils.getMacAddress();
            boolean allowed = BackRemotes.activationRemote().isDeviceAllowed(macAddress);

            if (!allowed) {
                throw new RuntimeException("Access is forbidden for mac: " + macAddress);
            }

        } catch (UnknownHostException | SocketException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }

}

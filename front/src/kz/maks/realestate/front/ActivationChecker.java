package kz.maks.realestate.front;

import kz.maks.core.shared.Utils;
import kz.maks.realestate.front.services.FrontRemotes;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

public class ActivationChecker {

    public static void check() {
        try {
            String macAddress = Utils.getMacAddress();
            boolean allowed = FrontRemotes.activationRemote().isDeviceAllowed(macAddress);

            if (!allowed) {
                throw new RuntimeException("Access is forbidden for mac: " + macAddress);
            }

        } catch (UnknownHostException | SocketException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }

}

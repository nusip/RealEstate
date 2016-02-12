package kz.maks.realestate.center.services.impl;

import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.realestate.center.entities.Device;
import kz.maks.realestate.center.services.ActivationService;

import static java.lang.Boolean.TRUE;
import static org.hibernate.criterion.Restrictions.eq;

@Service
public class ActivationServiceImpl extends AbstractServiceImpl implements ActivationService {

    @Override
    public boolean isDeviceAllowed(String deviceNumber) {
        Device device = (Device) session().createCriteria(Device.class).add(eq("number", deviceNumber)).uniqueResult();

        if (device != null && TRUE.equals(device.getIsActive()) && TRUE.equals(device.getClient().getIsActive()))
            return true;

        return false;
    }

}

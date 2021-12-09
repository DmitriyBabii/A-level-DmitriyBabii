package com.alevel.hw11.models;

import lombok.Getter;

@Getter
public class Service {
    static private final Phone[] referencePhones = {
            new PushButtonPhone("Nokia 230 Dual Dark Silver", 2020, Memory.M32),
            new FlipPhone("PHILIPS E255 Xenium", 2021, Memory.M32),
            new TouchscreenPhone("Samsung Galaxy A51", 2020, Memory.M128)
    };

    private final String address;

    public Service(String address) {
        this.address = address;
    }

    public void repairPhone(Phone phone) {
        if (isBrokenPhone(phone)) {
            phone.setBroken(false);
            if (checkPhoneOperation(phone)) {
                System.out.printf("'%s' has been successfully repaired\n", phone.getModel());
            }

        } else if (!checkPhoneOperation(phone)) {
            System.out.println("The phone is broken, but we do not know how to help you");
        } else {
            System.out.printf("'%s' does not need to be repaired\n", phone.getModel());
        }
    }

    private boolean isBrokenPhone(Phone phone) {
        for (Phone referencePhone : referencePhones) {
            if (referencePhone.getType().equals(phone.getType())) {
                return !comparePhones(referencePhone, phone);
            }
        }

        System.out.println("Phones of this type are not supported");
        return false;
    }

    private boolean comparePhones(Phone a, Phone b) {
        return a.hashCode() == b.hashCode()
                && a.equals(b);
    }

    private boolean checkPhoneOperation(Phone phone) {
        if (phone.call()) {
            switch (phone.getType()) {
                case "PushButtonPhone":
                    return ((PushButtonPhone) phone).pushSomeButton();
                case "FlipPhone":
                    return ((FlipPhone) phone).openPhoneCover() && ((FlipPhone) phone).pushSomeButton();
                case "TouchscreenPhone":
                    return ((TouchscreenPhone) phone).pushScreen();
            }
        }

        return false;
    }

    public String[] getSupportedTypes() {
        String[] types = new String[referencePhones.length];
        for (int i = 0; i < types.length; i++) {
            types[i] = referencePhones[i].getType();
        }

        return types;
    }
}

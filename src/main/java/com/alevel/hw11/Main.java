package com.alevel.hw11;

import com.alevel.hw11.models.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Service service = new Service("Barabashova");
        Phone[] phones = {
                new PushButtonPhone("Nokia 230 Dual Dark Silver", 2020, Memory.M128),
                new FlipPhone("PHILIPS E255 Xenium", 2021, Memory.M256),
                new TouchscreenPhone("Samsung Galaxy A51", 2020, Memory.M512),
                new FlipPhone("Broken phone", 2021, Memory.M64, true)
        };

        System.out.println("Service on " + service.getAddress() + " repairs: " + Arrays.toString(service.getSupportedTypes()) + "\n");
        for (Phone phone : phones) {
            service.repairPhone(phone);
            System.out.println(phone + "\n");
        }
    }
}

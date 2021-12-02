package com.alevel.hw11.models;

public enum Memory {
    //M - Micro
    M32(32), M64(64), M128(128), M256(256), M512(512);

    int value;

    Memory(int value) {
        this.value = value;
    }
}

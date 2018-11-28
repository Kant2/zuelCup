package com.example.competitiondemo.enums;

public enum  GenderEnum {

    MALE(0, "男"),
    FEMALE(1, "女");

    private int id;
    private String name;

    GenderEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public static GenderEnum getEnumByName(String name) {
        for (GenderEnum genderEnum: GenderEnum.values()) {
            if (genderEnum.getName() == name) {
                return genderEnum;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}

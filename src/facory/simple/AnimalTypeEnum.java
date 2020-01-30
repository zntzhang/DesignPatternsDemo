package facory.simple;

public enum AnimalTypeEnum {
    Bird("bird"),
    Cat("cat"),
    Dog("dog");
    private String type;

    AnimalTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

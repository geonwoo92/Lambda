package common;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString

public class Member {
    private String username;
    private String password;
    private String verify_password;
    private String name;
    private String social_Security_Number;
    private String phone_number;
    private String address;

    private double height;
    private double weight;

    @Builder(builderMethodName = "builder")

    public Member(String username, String password, String verify_password, String name, String social_Security_Number, String phone_number, String address, double height, double weight) {

        this.username = username;
        this.password = password;
        this.verify_password = verify_password;
        this.name = name;
        this.social_Security_Number = social_Security_Number;
        this.phone_number = phone_number;
        this.address = address;
        this.height = height;
        this.weight = weight;
    }

    public void setPassword(String password) {
    }
}

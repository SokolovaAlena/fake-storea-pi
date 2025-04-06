package users.GetUser;

public class GetUserResponseSampleGenerator {

    public static ResponseGetUsers getuserWithId1 () {

       return ResponseGetUsers.builder()
                .id(1)
                .email("john@gmail.com")
                .username("johnd")
                .password("m38rmF$")
                .phone("1-570-236-7033")
                .v(0)
                .name(Name.builder()
                        .firstname("john")
                        .lastname("doe")
                        .build())
                .address(Address.builder()
                        .city("kilcoole")
                        .street("new road")
                        .number(7682)
                        .zipcode("12926-3874")
                        .geolocation(Geolocation.builder()
                                .lat("-37.3159")
                                .jsonMemberLong("81.1496")
                                .build())
                        .build())
                .build();
    }
}

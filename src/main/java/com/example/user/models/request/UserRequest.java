package com.example.user.models.request;

import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String name;

    private String email;

    private String password;

    private List<PhoneRequest> phones;
}

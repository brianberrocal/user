package com.example.user.models.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneRequest {

    private String number;
    private String citycode;
    private String contrycode;
}

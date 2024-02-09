package com.trustmeenglish.learnenglish.dto;


import com.trustmeenglish.learnenglish.entity.Role;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    Set<Role> roles;


}

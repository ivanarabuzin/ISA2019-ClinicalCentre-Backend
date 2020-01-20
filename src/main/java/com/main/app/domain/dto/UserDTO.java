package com.main.app.domain.dto.user;


import com.main.app.enums.Role;

/**
 * The dto used for exposing user data through API.
 *
 *
 */
public class UserDTO {

    private Long id;

    private String email;

    private Role role;

    public UserDTO() {
    }

    public UserDTO(Long id, String email, Role role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

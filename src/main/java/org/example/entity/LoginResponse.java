package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.example.model.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class LoginResponse {

    @Id
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    private String token;
    private String expires;
    @JsonProperty("lastInvalidateAllSessionsPerformed")
    private String lastInvalidateSessionsPerformed;

}

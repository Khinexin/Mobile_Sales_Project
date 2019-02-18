package com.demo.mobileproject.domain.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class PersistentLogins {

    @Id @Column(length = 64)
    private String series;
    @Column(length = 64)
    private String useName;
    @Column(length = 64)
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUsed;

}

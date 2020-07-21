package com.cel.hexarchsample.infrastructure.adapter.database.jpa.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class CustomerEntity {

    // Warning this class is just a sample. It may not work out of the box

    @Id
    private UUID customerId;

    @Column
    private String name;
    @Column
    private String phoneNumber;

}

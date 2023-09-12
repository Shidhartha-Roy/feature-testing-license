package com.sid.filemngt.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {
    @Id
    private String dlNo;
    private String HolderName;
    @Lob
    @Column(name = "data", columnDefinition = "LONGBLOB")
    private byte[] data;


}

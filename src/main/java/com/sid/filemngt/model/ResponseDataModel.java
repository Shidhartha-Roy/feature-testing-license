package com.sid.filemngt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataModel {
    private String fileName;
    private String downloadURL;
    private String fileType;
    private long fileSize;
}

package com.sid.filemngt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewDlModel {

    private String dlNo;

    private String holder;

    private byte[] data;

    public NewDlModel(String dlNo, String holder) {
        this.dlNo = dlNo;
        this.holder = holder;
    }
}

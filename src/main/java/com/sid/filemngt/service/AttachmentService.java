package com.sid.filemngt.service;

import com.sid.filemngt.entities.Attachment;
import com.sid.filemngt.model.NewDlModel;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {

//    Attachment getAttachment(String fileId) throws Exception;

    Attachment saveDl(NewDlModel newDlModel) throws Exception;
}

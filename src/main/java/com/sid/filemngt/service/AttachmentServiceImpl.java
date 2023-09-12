package com.sid.filemngt.service;

import com.sid.filemngt.entities.Attachment;
import com.sid.filemngt.model.NewDlModel;
import com.sid.filemngt.repository.AttachmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService{

    private AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

//    @Override
//    public Attachment getAttachment(String fileId) throws Exception {
//        return attachmentRepository.findById(fileId).orElseThrow(()->new Exception("File not found with ID: "+ fileId));
//    }

    @Override
    public Attachment saveDl(NewDlModel newDlModel) throws Exception {
        try{
            Attachment attachment = new Attachment();
            attachment.setDlNo(newDlModel.getDlNo());
            attachment.setHolderName(newDlModel.getHolder());
            attachment.setData(newDlModel.getData());

            return attachmentRepository.save(attachment);

        }
        catch(Exception e){
            throw e;
        }

    }
}

package com.sid.filemngt.controller;

import com.sid.filemngt.entities.Attachment;
import com.sid.filemngt.model.NewDlModel;
import com.sid.filemngt.model.ResponseDataModel;
import com.sid.filemngt.service.AttachmentService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AttachmentController {

    private AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }


    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("dlNo") String dlNo, @RequestParam("holder") String holder) throws Exception {
        try{
            //Only Receiving Pdf Files
            if (!file.getContentType().equals("application/pdf")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid file type. Please upload a PDF file.");
            }

            byte[] fileContent = file.getBytes();
            NewDlModel newDlModel = new NewDlModel(dlNo, holder, fileContent);

            Attachment attachment = attachmentService.saveDl(newDlModel);
            return ResponseEntity.ok(attachment);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Dl Already Exists");
        }
    }



    @GetMapping("/download/{dlNo}")
    public ResponseEntity<NewDlModel> downloadFile(@PathVariable String dlNo) throws Exception {
        Attachment attachment = attachmentService.getAttachment(dlNo);

        NewDlModel newDlModel = new NewDlModel(attachment.getDlNo(), attachment.getHolderName());
        newDlModel.setDlNo(attachment.getDlNo());
        newDlModel.setHolder(attachment.getHolderName());

        return ResponseEntity.ok().body(newDlModel);

    }
}

package com.project1.demo.controller;

//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.project1.demo.data.entity.Player;
import com.project1.demo.payload.UploadFileResponse;
import com.project1.demo.service.PlayerService;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileUploadController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/upload")
public UploadFileResponse mapReapExcelDatatoDB(@RequestParam("nameField") String nameField, @RequestParam("file") MultipartFile ExcelDataFile) throws IOException {

        List<Player> tempPlayerList = new ArrayList<Player>();
        XSSFWorkbook workbook = new XSSFWorkbook(ExcelDataFile.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for(int i=1; i<worksheet.getPhysicalNumberOfRows(); i++) {
            Player tempPlayer = new Player();

            XSSFRow row = worksheet.getRow(i);

//            tempPlayer.setId((int) row.getCell(0).getNumericCellValue());
//            tempPlayer.setContent(row.getCell(1).getStringCellValue());
//            tempStudentList.add(tempPlayer);

            tempPlayer.setName(row.getCell(0).getStringCellValue());
            System.out.println(tempPlayer.getName());
            tempPlayer.setEmail_Address(row.getCell(1).getStringCellValue());
            System.out.println(tempPlayer.getEmail_Address());
            tempPlayer.setPurchase_Package(row.getCell(2).getStringCellValue());
            System.out.println(tempPlayer.getPurchase_Package());
            tempPlayer.setNamefield(nameField);
            System.out.println(nameField);

            tempPlayerList.add(tempPlayer);

            playerService.AddPlayer(tempPlayer);
        }
//        playerService.AddPlayer(tempPlayerList);

        String fileName = StringUtils.cleanPath(ExcelDataFile.getOriginalFilename());
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        return new UploadFileResponse(fileName, fileDownloadUri, ExcelDataFile.getContentType(), ExcelDataFile.getSize(), nameField);

    }

}

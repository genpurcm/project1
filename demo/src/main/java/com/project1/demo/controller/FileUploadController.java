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

            //Skip the Excel's header.
            XSSFRow row = worksheet.getRow(i);

            tempPlayer.setFirst_Name(row.getCell(0).getStringCellValue());
            System.out.println(tempPlayer.getFirst_Name());
            tempPlayer.setLast_Name(row.getCell(1).getStringCellValue());
            tempPlayer.setEmail_Address(row.getCell(2).getStringCellValue());
            tempPlayer.setTeam(row.getCell(3).getStringCellValue());
            tempPlayer.setNumber(row.getCell(4).getNumericCellValue());
            System.out.println(tempPlayer.getNumber());
            System.out.println(row.getCell(4).getNumericCellValue());
//            tempPlayer.setPosition(row.getCell(5).getStringCellValue());
            tempPlayer.setBirthday(row.getCell(6).getDateCellValue());
            tempPlayer.setWeight(row.getCell(7).getNumericCellValue());
            tempPlayer.setHeight(row.getCell(8).getNumericCellValue());
            tempPlayer.setNationality(row.getCell(9).getStringCellValue());
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

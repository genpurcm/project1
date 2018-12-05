package com.project1.demo.controller;

import com.project1.demo.data.entity.Player;
import com.project1.demo.payload.UploadFileResponse;
import com.project1.demo.service.PlayerService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@RestController
public class FileUploadController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/upload")
    public UploadFileResponse mapReapExcelDatatoDB(@RequestParam("nameField") String nameField, @RequestParam("file") MultipartFile ExcelDataFile) throws IOException, InvalidFormatException {
        List<Player> tempPlayerList = new ArrayList<Player>();
        try {

            XSSFWorkbook workbook = new XSSFWorkbook(ExcelDataFile.getInputStream());
            XSSFSheet worksheet = workbook.getSheet("Match");

            Iterator<Row> rows = worksheet.iterator();

            rows.next();

            worksheet.forEach(row -> {
                if (row.getRowNum() == 0){
                    return; //Continues to the next code....
                }
                Player tempPlayer = new Player();
                //            Iterator<Cell> cellsInRow = currentRow.iterator();
                tempPlayer.setFirstName(row.getCell(0).getStringCellValue());
                tempPlayer.setLastName(row.getCell(1).getStringCellValue());
                tempPlayer.setEmailAddress(row.getCell(2).getStringCellValue());
                tempPlayer.setTeam(row.getCell(3).getStringCellValue());
                tempPlayer.setNumber(row.getCell(4).getNumericCellValue());
//                tempPlayer.setPosition(row.getCell(5).getStringCellValue());

                Date date = row.getCell(6).getDateCellValue();
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int year  = localDate.getYear();
                int month = localDate.getMonthValue();
                int day   = localDate.getDayOfMonth();
                tempPlayer.setBirthday(localDate);
//                tempPlayer.setBirthday(row.getCell(6).getDateCellValue());
                tempPlayer.setWeight(row.getCell(7).getNumericCellValue());
                tempPlayer.setHeight(row.getCell(8).getNumericCellValue());
                tempPlayer.setNationality(row.getCell(9).getStringCellValue());
                tempPlayer.setNamefield(nameField);
                System.out.println("Lamda forEach Loop");

                tempPlayerList.add(tempPlayer);

                playerService.AddPlayer(tempPlayer);

            });


//        while (rows.hasNext()){
//            Row row = rows.next();
////            if (row.getRowNum() == 0){
////                continue;
////            }
//            Player tempPlayer = new Player();
//            //            Iterator<Cell> cellsInRow = currentRow.iterator();
//            tempPlayer.setFirst_Name(row.getCell(0).getStringCellValue());
//            tempPlayer.setLast_Name(row.getCell(1).getStringCellValue());
//            tempPlayer.setEmail_Address(row.getCell(2).getStringCellValue());
//            tempPlayer.setTeam(row.getCell(3).getStringCellValue());
//            tempPlayer.setNumber(row.getCell(4).getNumericCellValue());
////            tempPlayer.setPosition(row.getCell(5).getStringCellValue());
//            tempPlayer.setBirthday(row.getCell(6).getDateCellValue());
//            tempPlayer.setWeight(row.getCell(7).getNumericCellValue());
//            tempPlayer.setHeight(row.getCell(8).getNumericCellValue());
//            tempPlayer.setNationality(row.getCell(9).getStringCellValue());
//            tempPlayer.setNamefield(nameField);
//            System.out.println("While has next");
//
//            tempPlayerList.add(tempPlayer);
//
//            playerService.AddPlayer(tempPlayer);
//        }

            workbook.close();


//        for(int i=1; i<worksheet.getPhysicalNumberOfRows(); i++) {
//            Player tempPlayer = new Player();
//
//            //Skip the Excel's header.
//            XSSFRow row = worksheet.getRow(i);
//
//            tempPlayer.setFirst_Name(row.getCell(0).getStringCellValue());
//            System.out.println(tempPlayer.getFirst_Name());
//            tempPlayer.setLast_Name(row.getCell(1).getStringCellValue());
//            tempPlayer.setEmail_Address(row.getCell(2).getStringCellValue());
//            tempPlayer.setTeam(row.getCell(3).getStringCellValue());
//            tempPlayer.setNumber(row.getCell(4).getNumericCellValue());
//            System.out.println(tempPlayer.getNumber());
//            System.out.println(row.getCell(4).getNumericCellValue());
////            tempPlayer.setPosition(row.getCell(5).getStringCellValue());
//            tempPlayer.setBirthday(row.getCell(6).getDateCellValue());
//            tempPlayer.setWeight(row.getCell(7).getNumericCellValue());
//            tempPlayer.setHeight(row.getCell(8).getNumericCellValue());
//            tempPlayer.setNationality(row.getCell(9).getStringCellValue());
//            tempPlayer.setNamefield(nameField);
//            System.out.println(nameField);
//
//            tempPlayerList.add(tempPlayer);
//
//            playerService.AddPlayer(tempPlayer);
//        }
//        playerService.AddPlayer(tempPlayerList);



        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException Handler: "+ e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception Handler: "+ e.getMessage());
        } finally {
            System.out.println("Finally Thrown");
        }

        String fileName = StringUtils.cleanPath(ExcelDataFile.getOriginalFilename());
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri, ExcelDataFile.getContentType(), ExcelDataFile.getSize(), nameField, tempPlayerList);
    }

}

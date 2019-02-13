package com.project1.demo.controller;

import com.project1.demo.data.entity.User;
import com.project1.demo.data.entity.Role;
import com.project1.demo.payload.UploadFileResponse;
import com.project1.demo.service.UserService;
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
    private UserService userService;

    @PostMapping("/upload")
    public UploadFileResponse mapReapExcelDatatoDB(@RequestParam("nameField") String nameField, @RequestParam("file") MultipartFile ExcelDataFile) throws IOException, InvalidFormatException {
        List<User> tempUserList = new ArrayList<User>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(ExcelDataFile.getInputStream());
            XSSFSheet worksheet = workbook.getSheet("Match");

            Iterator<Row> rows = worksheet.iterator();

            rows.next();

            worksheet.forEach(row -> {
                if (row.getRowNum() == 0){
                    return; //Continues to the next code....
                }
                User tempUser = new User();
                //            Iterator<Cell> cellsInRow = currentRow.iterator();
                tempUser.setFirstName(row.getCell(0).getStringCellValue());
                tempUser.setLastName(row.getCell(1).getStringCellValue());
                tempUser.setEmailAddress(row.getCell(2).getStringCellValue());
                tempUser.setTeam(row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
                tempUser.setNumber(row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());
                tempUser.setPosition(row.getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
                    Date date = row.getCell(6).getDateCellValue();
                    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    int year  = localDate.getYear();
                    int month = localDate.getMonthValue();
                    int day   = localDate.getDayOfMonth();
                tempUser.setBirthday(localDate);
//                tempUser.setBirthday(row.getCell(6).getDateCellValue());
                tempUser.setWeight(row.getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());
                tempUser.setHeight(row.getCell(8, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());
                tempUser.setNationality(row.getCell(9, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
                tempUser.setPassword(row.getCell(10).getStringCellValue());
                Role userRole = new Role(row.getCell(11, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
                List<Role> roles = new ArrayList<>();
                roles.add(userRole);
                tempUser.setRoles(roles);
//                playerRepository.save(player);
//                tempUser.setRoles(row.getCell(11).getStringCellValue());
                tempUser.setNamefield(nameField);
                System.out.println("Lamda forEach Loop");

                tempUserList.add(tempUser);
                userService.AddUser(tempUser);
            });

//        while (rows.hasNext()){
//            Row row = rows.next();
////            if (row.getRowNum() == 0){
////                continue;
////            }
//            User tempPlayer = new User();
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
//            tempUserList.add(tempPlayer);
//
//            userService.AddUser(tempPlayer);
//        }

            workbook.close();

//        for(int i=1; i<worksheet.getPhysicalNumberOfRows(); i++) {
//            User tempPlayer = new User();
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
//            tempUserList.add(tempPlayer);
//
//            userService.AddUser(tempPlayer);
//        }
//        userService.AddUser(tempUserList);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException Handler: "+ e.getMessage());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("NullPointerException Handler: "+ e.getMessage() + "Seems that a cell is empty/blank");
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
        return new UploadFileResponse(fileName, fileDownloadUri, ExcelDataFile.getContentType(), ExcelDataFile.getSize(), nameField, tempUserList);
    }

}

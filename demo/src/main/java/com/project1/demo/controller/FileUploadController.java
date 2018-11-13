package com.project1.demo.controller;

//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.project1.demo.data.entity.Student;
import com.project1.demo.service.StudentService;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileUploadController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/upload")
    public void mapReapExcelDatatoDB(@RequestParam("file") MultipartFile ExcelDataFile) throws IOException {

        List<Student> tempStudentList = new ArrayList<Student>();
        XSSFWorkbook workbook = new XSSFWorkbook(ExcelDataFile.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for(int i=1; i<worksheet.getPhysicalNumberOfRows(); i++) {
            Student tempStudent = new Student();

            XSSFRow row = worksheet.getRow(i);

//            tempStudent.setId((int) row.getCell(0).getNumericCellValue());
//            tempStudent.setContent(row.getCell(1).getStringCellValue());
//            tempStudentList.add(tempStudent);

            tempStudent.setName(row.getCell(0).getStringCellValue());
            System.out.println(tempStudent.getName());
            tempStudent.setEmail_Address(row.getCell(1).getStringCellValue());
            System.out.println(tempStudent.getEmail_Address());
            tempStudent.setPurchase_Package(row.getCell(2).getStringCellValue());
            System.out.println(tempStudent.getPurchase_Package());
            tempStudentList.add(tempStudent);

            studentService.AddStudent(tempStudent);



        }
    }


}

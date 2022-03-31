import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Dump_to_excel {
    public static void main(String[] args) throws InterruptedException, IOException {
        create_Excel_file("State_wise_result");
        create_Excel_Sheet_For_candidates_with_MaxVote("State_wise_result.xlsx");
        create_Excel_Sheet_For_candidates_with_MinVote("State_wise_result.xlsx");
        create_Excel_Sheet_For_maximum_vote_difference("State_wise_result.xlsx");
        create_Excel_Sheet_For_minimum_vote_difference("State_wise_result.xlsx");
        create_Excel_Sheet_For_maximum_vote_percentage_difference("State_wise_result.xlsx");
        create_Excel_Sheet_For_minimum_vote_percentage_difference("State_wise_result.xlsx");
        create_Excel_Sheet_For_maximum_vote_percentage_winner("State_wise_result.xlsx");
        create_Excel_Sheet_For_minimum_vote_percentage_winner("State_wise_result.xlsx");
        create_Excel_Sheet_For_miscellaneous_Data("State_wise_result.xlsx");


    }
    public static void create_Excel_file(String fileName) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        FileOutputStream out = new FileOutputStream(
                new File("D:\\selenium assignemnt\\Election_selenium\\Election_selenium" + fileName + ".xlsx"));

        workbook.write(out);
        out.close();
        System.out.println(fileName + ".xlsx written successfully");
    }

    public static void create_Excel_Sheet_For_candidates_with_MaxVote(String file_Path)
            throws IOException {
        String excelFilePath = file_Path;
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);

            //sheet1 creation
            Sheet sheet1 = workbook.createSheet("candidates_with_MaxVote");
            sheet1.setColumnWidth(0, 6000);
            sheet1.setColumnWidth(1, 4000);
            Row header1 = sheet1.createRow(0);
            CellStyle headerStyle1 = workbook.createCellStyle();
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            font.setFontName("Arial");
            font.setBold(true);
            headerStyle1.setFont(font);
            Cell headerCell1 = header1.createCell(0);
            headerCell1.setCellValue("State Name");
            headerCell1 = header1.createCell(1);
            headerCell1.setCellValue("Constituency Name");
            headerCell1 = header1.createCell(2);
            headerCell1.setCellValue("Candidate Name");
            headerCell1 = header1.createCell(3);
            headerCell1.setCellValue("Total Votes");

            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }

    public static void create_Excel_Sheet_For_candidates_with_MinVote(String file_Path)
            throws IOException {
        String excelFilePath = file_Path;
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);

            //sheet2 creation
            Sheet sheet2 = workbook.createSheet("candidates_with_MinVote");
            sheet2.setColumnWidth(0, 6000);
            sheet2.setColumnWidth(1, 4000);

            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            Row header2 = sheet2.createRow(0);
            CellStyle headerStyle2 = workbook.createCellStyle();
            headerStyle2.setFont(font);
            Cell headerCell2 = header2.createCell(0);
            headerCell2.setCellValue("State Name");
            headerCell2 = header2.createCell(1);
            headerCell2.setCellValue("Constituency Name");
            headerCell2 = header2.createCell(2);
            headerCell2.setCellValue("Candidate Name");
            headerCell2 = header2.createCell(3);
            headerCell2.setCellValue("Total Votes");


            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }

    public static void create_Excel_Sheet_For_maximum_vote_difference(String file_Path)
            throws IOException {
        String excelFilePath = file_Path;
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);


            Sheet sheet3 = workbook.createSheet("maximum_vote_difference_margin");
            sheet3.setColumnWidth(0, 6000);
            sheet3.setColumnWidth(1, 4000);
            Row header3 = sheet3.createRow(0);
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            CellStyle headerStyle3 = workbook.createCellStyle();
            headerStyle3.setFont(font);
            Cell headerCell3 = header3.createCell(0);
            headerCell3.setCellValue("State Name");
            headerCell3 = header3.createCell(1);
            headerCell3.setCellValue("Constituency Name");
            headerCell3 = header3.createCell(2);
            headerCell3.setCellValue("Winner Name");
            headerCell3 = header3.createCell(3);
            headerCell3.setCellValue("Winner Total Votes");
            headerCell3 = header3.createCell(4);
            headerCell3.setCellValue("Runner-Up Name");
            headerCell3 = header3.createCell(5);
            headerCell3.setCellValue("Runner-Up Total Votes");
            headerCell3 = header3.createCell(6);
            headerCell3.setCellValue("Total Margin");


            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }


    }
    public static void create_Excel_Sheet_For_minimum_vote_difference(String file_Path)
            throws IOException {
        String excelFilePath = file_Path;
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet4 = workbook.createSheet("minimum_vote_difference_margin");
            sheet4.setColumnWidth(0, 6000);
            sheet4.setColumnWidth(1, 4000);
            Row header4 = sheet4.createRow(0);
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            CellStyle headerStyle4 = workbook.createCellStyle();
            headerStyle4.setFont(font);
            Cell headerCell4 = header4.createCell(0);
            headerCell4.setCellValue("State Name");
            headerCell4 = header4.createCell(1);
            headerCell4.setCellValue("Constituency Name");
            headerCell4 = header4.createCell(2);
            headerCell4.setCellValue("Winner Name");
            headerCell4 = header4.createCell(3);
            headerCell4.setCellValue("Winner Total Votes");
            headerCell4 = header4.createCell(4);
            headerCell4.setCellValue("Runner-Up Name");
            headerCell4 = header4.createCell(5);
            headerCell4.setCellValue("Runner-Up Total Votes");
            headerCell4 = header4.createCell(6);
            headerCell4.setCellValue("Total Margin");


            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }

    }
    public static void create_Excel_Sheet_For_maximum_vote_percentage_difference(String file_Path)
            throws IOException {
        String excelFilePath = file_Path;
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);


            Sheet sheet5 = workbook.createSheet("maximum_vote_percentage_difference_margin");
            sheet5.setColumnWidth(0, 6000);
            sheet5.setColumnWidth(1, 4000);
            Row header5 = sheet5.createRow(0);
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            CellStyle headerStyle5 = workbook.createCellStyle();
            headerStyle5.setFont(font);
            Cell headerCell5 = header5.createCell(0);
            headerCell5.setCellValue("State Name");
            headerCell5 = header5.createCell(1);
            headerCell5.setCellValue("Constituency Name");
            headerCell5 = header5.createCell(2);
            headerCell5.setCellValue("Winner Name");
            headerCell5 = header5.createCell(3);
            headerCell5.setCellValue("Winner Total Votes Percentage");
            headerCell5 = header5.createCell(4);
            headerCell5.setCellValue("Runner-Up Name ");
            headerCell5 = header5.createCell(5);
            headerCell5.setCellValue("Runner-Up Total Votes Percentage");
            headerCell5 = header5.createCell(6);
            headerCell5.setCellValue("Total Percentage Margin");


            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }

    }
    public static void create_Excel_Sheet_For_minimum_vote_percentage_difference(String file_Path)
            throws IOException {
        String excelFilePath = file_Path;
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet6 = workbook.createSheet("minimum_vote_percentage_difference_margin");
            sheet6.setColumnWidth(0, 6000);
            sheet6.setColumnWidth(1, 4000);
            Row header6 = sheet6.createRow(0);
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            CellStyle headerStyle6 = workbook.createCellStyle();
            headerStyle6.setFont(font);
            Cell headerCell6 = header6.createCell(0);
            headerCell6.setCellValue("State Name");
            headerCell6 = header6.createCell(1);
            headerCell6.setCellValue("Constituency Name");
            headerCell6 = header6.createCell(2);
            headerCell6.setCellValue("Winner Name");
            headerCell6 = header6.createCell(3);
            headerCell6.setCellValue("Winner Total Votes Percentage");
            headerCell6 = header6.createCell(4);
            headerCell6.setCellValue("Runner-Up Name ");
            headerCell6 = header6.createCell(5);
            headerCell6.setCellValue("Runner-Up Total Votes Percentage");
            headerCell6 = header6.createCell(6);
            headerCell6.setCellValue("Total Percentage Margin");

            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }

    }
    public static void create_Excel_Sheet_For_maximum_vote_percentage_winner(String file_Path)
            throws IOException {
        String excelFilePath = file_Path;
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet7 = workbook.createSheet("maximum_vote_percentage_winner");
            sheet7.setColumnWidth(0, 6000);
            sheet7.setColumnWidth(1, 4000);
            Row header7 = sheet7.createRow(0);
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            CellStyle headerStyle7 = workbook.createCellStyle();
            headerStyle7.setFont(font);
            Cell headerCell7 = header7.createCell(0);
            headerCell7.setCellValue("State Name");
            headerCell7 = header7.createCell(1);
            headerCell7.setCellValue("Constituency Name");
            headerCell7 = header7.createCell(2);
            headerCell7.setCellValue("Candidate Name");
            headerCell7 = header7.createCell(3);
            headerCell7.setCellValue("Total Votes Percent");

            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }

    }
    public static void create_Excel_Sheet_For_minimum_vote_percentage_winner(String file_Path)
            throws IOException {
        String excelFilePath = file_Path;
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet8 = workbook.createSheet("minimum_vote_percentage_winner");
            sheet8.setColumnWidth(0, 6000);
            sheet8.setColumnWidth(1, 4000);
            Row header8 = sheet8.createRow(0);
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            CellStyle headerStyle8 = workbook.createCellStyle();
            headerStyle8.setFont(font);
            Cell headerCell8 = header8.createCell(0);
            headerCell8.setCellValue("State Name");
            headerCell8 = header8.createCell(1);
            headerCell8.setCellValue("Constituency Name");
            headerCell8 = header8.createCell(2);
            headerCell8.setCellValue("Candidate Name");
            headerCell8 = header8.createCell(3);
            headerCell8.setCellValue("Total Votes Percent");
            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }

    }
    public static void create_Excel_Sheet_For_miscellaneous_Data(String file_Path)
            throws IOException {
        String excelFilePath = file_Path;
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);


            Sheet sheet9 = workbook.createSheet("miscellaneous_Data");
            sheet9.setColumnWidth(0, 6000);
            sheet9.setColumnWidth(1, 4000);
            Row header9 = sheet9.createRow(0);
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            CellStyle headerStyle9 = workbook.createCellStyle();
            headerStyle9.setFont(font);
            Cell headerCell9 = header9.createCell(0);
            headerCell9.setCellValue("State Name");
            headerCell9 = header9.createCell(1);
            headerCell9.setCellValue("Count of Less Than NOTA");
            headerCell9 = header9.createCell(2);
            headerCell9.setCellValue("Count Candidate Greater than 50% Votes");

            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }

    }
    public static void write_Into_excel(String fileName,String StateName, String SheetName, String ConstName, String CandName, String Vote) {


        String excelFilePath = fileName+".xlsx";
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheet(SheetName);

            int rowCount = sheet.getLastRowNum();
            Row row = sheet.createRow(++rowCount);
            Cell cell = row.createCell(0);
            cell.setCellValue(StateName);
            cell = row.createCell(1);
            cell.setCellValue(ConstName);
            cell = row.createCell(2);
            cell.setCellValue(CandName);
            cell = row.createCell(3);
            cell.setCellValue(Vote);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }
    public static void write_Into_excel_type_2(String fileName,String StateName, String SheetName,String ConstName,String WinnerName, String Vote,String runnerUpName,String runnerUpVotes,String margin){
        String excelFilePath = fileName+".xlsx";
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheet(SheetName);

            int rowCount = sheet.getLastRowNum();
            Row row = sheet.createRow(++rowCount);
            Cell cell = row.createCell(0);
            cell.setCellValue(StateName);
            cell = row.createCell(1);
            cell.setCellValue(ConstName);
            cell = row.createCell(2);
            cell.setCellValue(WinnerName);
            cell = row.createCell(3);
            cell.setCellValue(Vote);
            cell = row.createCell(4);
            cell.setCellValue(runnerUpName);
            cell = row.createCell(5);
            cell.setCellValue(runnerUpVotes);
            cell = row.createCell(6);
            cell.setCellValue(margin);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }
    public static void write_Into_excel_misc(String fileName,String StateName,String SheetName,int less_than_NOTA, int greater_Than_50_percentage){
        String excelFilePath = fileName+".xlsx";
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheet(SheetName);

            int rowCount = sheet.getLastRowNum();
            Row row = sheet.createRow(++rowCount);
            Cell cell = row.createCell(0);
            cell.setCellValue(StateName);
            cell = row.createCell(1);
            cell.setCellValue(less_than_NOTA);
            cell = row.createCell(2);
            cell.setCellValue(greater_Than_50_percentage);

            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }

}

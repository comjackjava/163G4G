package com.qhit.lh.g4.cx.exam.tkgl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qhit.lh.g4.jay.exam.kmgl.bean.Course;
import com.qhit.lh.g4.jay.exam.tkgl.bean.WrittenQuestion;

public class PoiReaderExcel {

	@SuppressWarnings("resource")
	public static List<WrittenQuestion> readerExcel(InputStream is,Course course) {
		List<WrittenQuestion> listQuestion = new ArrayList<WrittenQuestion>();
		//声明并打�?��作簿
		Workbook workbook = null;
		try{
			//读取数据流中的文件对�?
			workbook = new HSSFWorkbook(is);
		}catch(Exception e){
			try {
				//读取数据流中的文件对�?
				workbook = new XSSFWorkbook(is);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		try {
			//读取默认的第�?��工作�?
			Sheet sheet = (Sheet) workbook.getSheetAt(0);
			//从索引为1的行�?���?
			int firstRowIndex = 1;
			//读到有数据的�?��行的索引
			int lastRowIndex = sheet.getPhysicalNumberOfRows();
			for (int i = firstRowIndex; i < lastRowIndex; i++) {
				//通过索引获取当前行的对象
				Row row = sheet.getRow(i);
				WrittenQuestion question = new WrittenQuestion();
				//获取�?��单元格索�?
				int lastCellIndex = row.getLastCellNum();
				if(row.getCell(0).getStringCellValue() == null && "".equals(row.getCell(0).getStringCellValue())){
					break;
				}
				for (int j = 0; j < lastCellIndex; j++) {
					//获取当前单元格的对象
					Cell cell = row.getCell(j);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					switch (j) {
					case 0:
						question.setQtitle(cell.getStringCellValue());
						break;
					case 1:
						question.setOptionA(cell.getStringCellValue());
						break;
					case 2:
						question.setOptionB(cell.getStringCellValue());
						break;
					case 3:
						question.setOptionC(cell.getStringCellValue());
						break;
					case 4:
						question.setOptionD(cell.getStringCellValue());
						break;
					case 5:
						question.setAnswer(cell.getStringCellValue());
						break;
					case 6:
						question.setQtype(cell.getStringCellValue());
						break;
					case 7:
						question.setDegree(cell.getStringCellValue());
						break;
					case 8:
						question.setChapter(cell.getStringCellValue());
						break;
					}
				}
				//设置课程编号
				question.setCsId(course.getCsId());
				//添加试题和课程的关系
				question.setCourse(course);
				//把读取的试题对象保存到集合中
				listQuestion.add(question);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listQuestion;
	}

}

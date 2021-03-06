package com.qhit.lh.g4.jack.exam.tkgl.utils;

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

import com.qhit.lh.g4.jack.exam.kmgl.bean.Course;
import com.qhit.lh.g4.jack.exam.tkgl.bean.WrittenTest;

public class PoiReaderExcel {
	@SuppressWarnings("resource")

	public static List<WrittenTest> readerExcel(InputStream is,Course course) {

		List<WrittenTest> listQuestion = new ArrayList<WrittenTest>();

		//声明工作簿

		Workbook workbook = null;

		try{

			//读取数据流中的文件对象

			workbook = new HSSFWorkbook(is);

		}catch(Exception e){

			try {

				//读取数据流中的文件对象

				workbook = new XSSFWorkbook(is);

			} catch (IOException e1) {

				e1.printStackTrace();

			}

		}

		try {

			//读取默认的第一个工作表

			Sheet sheet = (Sheet) workbook.getSheetAt(0);

			//从索引为1的行开始读

			int firstRowIndex = 1;

			//读到有数据的最后行的索引

			int lastRowIndex = sheet.getPhysicalNumberOfRows();

			for (int i = firstRowIndex; i < lastRowIndex; i++) {

				//通过索引获取当前行的对象

				Row row = sheet.getRow(i);

				WrittenTest question = new WrittenTest();

				//获取最后单元格索引

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

				question.setCsId(course.getCsId());

				

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

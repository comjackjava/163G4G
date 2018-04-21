/**
 * 
 */
package com.qhit.lh.g4.perfact.exam.questions_management.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.qhit.lh.g4.perfact.exam.questions_management.bean.WrittenTest;
import com.qhit.lh.g4.perfact.exam.subject_management.bean.Course;

/**
 * @author 万曦晖
 *TODO
 *2018年1月5日上午10:04:20
 */
public class PoiReaderExce {
	@SuppressWarnings("resource")
	public static List<WrittenTest> readerExcel (InputStream is,Course course){
		List<WrittenTest> listTest = new ArrayList<WrittenTest>();
		//声明工作溥
		Workbook workbook = null;
		try {
			//读取数据流的对象文件
			workbook = new HSSFWorkbook(is);
		} catch (IOException e) {
			//读取数据流的对象文件
			try {
				workbook = new HSSFWorkbook(is);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}


		try {

			//默认读取第一个工作表
			Sheet sheet = workbook.getSheetAt(0);
			//从索引为1开始读取
			int fristRowIndex = 1;
			//读到有数据的最后行的索引
			int lastRowIndex = sheet.getPhysicalNumberOfRows();
			for (int i = fristRowIndex; i < lastRowIndex; i++) {
				//通过索引获取当前行的对象
				Row row = sheet.getRow(i);
				WrittenTest writtenTest = new WrittenTest();
				//获取最后单元格索引
				int lastCellIndex = row.getLastCellNum();
				if(row.getCell(0).getStringCellValue() == null && "".equals(row.getCell(0).getStringCellValue())) {
					break;
				}
				for (int j = 0; j < lastCellIndex; j++) {
					//获取当前单元格的对象
					Cell cell = row.getCell(j);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					switch (j) {
					case 0:
						writtenTest.setQtitle(cell.getStringCellValue());
						break;
					case 1:
						writtenTest.setOptionA(cell.getStringCellValue());
						break;
					case 2:
						writtenTest.setOptionB(cell.getStringCellValue());
						break;
					case 3:
						writtenTest.setOptionC(cell.getStringCellValue());
						break;
					case 4:
						writtenTest.setOptionD(cell.getStringCellValue());
						break;
					case 5:
						writtenTest.setAnswer(cell.getStringCellValue());
						break;
					case 6:
						writtenTest.setQtype(cell.getStringCellValue());
						break;
					case 7:
						writtenTest.setDegree(cell.getStringCellValue());
						break;
					case 8:
						writtenTest.setChapter(cell.getStringCellValue());
						break;
					}
					//设置课程编号
					writtenTest.setCsId(course.getCsId());
					//添加试题和课程的关系
					writtenTest.setCourse(course);
					//把读取的试题对象保存到集合中
					listTest.add(writtenTest);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listTest;

	}
}

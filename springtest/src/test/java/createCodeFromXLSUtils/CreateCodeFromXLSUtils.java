package createCodeFromXLSUtils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreateCodeFromXLSUtils {

	public static void main(String[] args) {

		hehe();
	}

	private static void hehe() {
		String filePath = CreateCodeFromXLSUtils.class.getResource("").getFile() + "makeInterface.xls";
//		System.out.println(filePath);
//		File file = new File(filePath);

//		System.out.println(file.exists());

		try {
			excelMethord(filePath,1,0,4,3,2);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}

	// 读取 xls 模板 生成 接口的 及测试信息 (简化重复 劳动)
	private static void excelMethord(String filePath, int code, int name, int desc, int isNull, int length)
			throws Exception {
		// 澹版槑涓�涓伐浣滆杽
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(filePath)));

		HSSFSheet sheet = workbook.getSheetAt(0);

		StringBuffer sbfParam=new StringBuffer();
		StringBuffer sbf=new StringBuffer();
		StringBuffer sbfMap=new StringBuffer();
		int index = 0;
		boolean flag = true;
		while (flag) {
			try {
				HSSFRow row = sheet.getRow(index++);
				HSSFCell cell = row.getCell(code);
				String codeValue = cell.getStringCellValue();
				cell = row.getCell(name);
				String nameValue = cell.getStringCellValue();
				cell = row.getCell(desc);
				String descValue = cell.getStringCellValue();
				cell = row.getCell(isNull);
				if(cell!=null){
					String isNullValue = cell.getStringCellValue();
				}else{
					String isNullValue =null;
				}
				cell = row.getCell(length);
				String lengthValue = cell.getStringCellValue();
				String row2 = getRow( codeValue , nameValue , descValue , lengthValue );
				System.out.println(row2);
				sbf.append("String  "+codeValue+"  =\"\";\n");
				sbfParam.append("java.lang.String  "+codeValue+"  ,");
				sbfMap.append("map.put(\""+codeValue+"\","+codeValue+");\n");
			} catch (Exception e) {
				e.printStackTrace();
				flag=false;
			}
		}

		System.out.println( );
		System.out.println(sbfParam.toString());
		System.out.println( );
		System.out.println(sbf.toString());
		System.out.println(sbfMap.toString());
	}
	
	private static String getRow(String codeValue ,String nameValue ,String descValue ,String lengthValue ){
		lengthValue=lengthValue.substring(lengthValue.indexOf("(")+1,lengthValue.indexOf(")"));
		return " <field code=\""+codeValue+"\"  name=\""+nameValue+"\" length=\""+lengthValue+"\" desc=\""+descValue+"\" />"; 
	}

}

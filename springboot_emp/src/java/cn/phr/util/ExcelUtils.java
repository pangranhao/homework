package cn.phr.util;



import cn.phr.comm.Excel;
import cn.phr.comm.ExcleHeard;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ExcelUtils {
    //关于excel 了解几个对象
    public static void excelutil(List list, HttpServletResponse response){
        /*首先处理标题*/
        Object o = list.get(0);//得到要下载的对象(第一步就是要获取一个下载的对象)

        Class aClass = o.getClass();//利用反射得到类的对象（获取完对象之后我们利用反射的方法".getclass"方法得到这个对象）

        //获取标题名 以及标题上面的注解(做工具类之前我们已经写好了一个自定义注解，
        // 这个注解就是做标题的标识用的，在这里我们需要通过对象调用一个getAnnotation方法获取到我们定义的注解)
        ExcleHeard annotation = (ExcleHeard) aClass.getAnnotation(ExcleHeard.class);
        //获取标题名（获取到之后调用我们定义的默认的title）
        String title = annotation.title();
        //我们利用poi的XSSWorkbook的方法创建了excel工作簿
        XSSFWorkbook book = new XSSFWorkbook();
        //然后我们跟着有调用了createSheet在工作簿中创建了一个工作表
        XSSFSheet sheet = book.createSheet(title);
        //在工作表中创建一个新行放进下标为0
        XSSFRow row = sheet.createRow(0);

        //处理列头
        //得到类的所以属性（java反射可以通过getDeclaredFields获取所有动态的属性）
        Field[] fields = aClass.getDeclaredFields();
        //定义一个cellnom=0
        int cellNom=0;
        //遍历输出我们的获取到了所有属性
        for (int i = 0; i <fields.length ; i++) {
            //具体每一个属性 （找到里面具体的每一个属性）
            Field field=fields[i];

            //判断此属性是否要导出来的属性（然后我们需要一个我们之前写的一个自定义注解 作用是作为我们需要导出数据的标识 同理用getAnnotation获取他这个类）
            Excel annotation1 = field.getAnnotation(Excel.class);
            //判断他是否为空
            if (annotation1!=null){
                //调用出我们定义的默认的name
              String rownumname=annotation1.name();
              //创建一个新的单元格，把我们定义的一个cellNom放在里面
                XSSFCell cell = row.createCell(cellNom);
                //为单元格进行赋值
                cell.setCellValue(rownumname);
                //相当于+1
                cellNom++;
            }

        }
        //处理数据（然后我们遍历输出我们对象的集合）
        for (int i = 0; i <list.size() ; i++) {
            //获取具体数据（与上面一样获取到他的具体数据）
            Object o1 = list.get(i);
            //创建行 +1（创建行+1 在循环中有多少数据就进行加一行）
            XSSFRow row1 = sheet.createRow(i + 1);
            //定义一个cells=0
            int cells=0;
            //遍历输出我们得到的所有属性
            for (int j = 0; j <fields.length ; j++) {
                //具体每一个属性（得到他们具体的每一个属性）
                Field fields1=fields[j];
                //这一步就是判断注解是否存在 isAnnotationPresent这个方法是我们在自定义注解是否在属性的上面如果是就返回一个true
                boolean annotationPresent = fields1.isAnnotationPresent(Excel.class);
                //得到之后如果是true的时候说明存在
                if (annotationPresent==true){
                    //存在就要给单元格进行赋值
                    XSSFCell cell = row1.createCell(cells);
                    //获取属相值 在反射中 对类和对象来说

                    try {
                        //用java反射进行暴力访问 因为他的类型定位了boolean类型所以返回true的时候就可以访问这个属性，返回false相反
                        fields1.setAccessible(true);
                        //取出属性里面的数据
                        Object o2 = fields1.get(o1);
                        //判断里面是否为空
                        if (o2!=null){
                            //通过属性 getType获取到这个接口的类型
                            Class<?> type = fields1.getType();
                            //判断他是都是时间类型
                            //如果是的话进行转换
                            if (type== Date.class){
                                //g格式化日期
                                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                                Date date=(Date)o2;
                                String format = sdf.format(date);
                                cell.setCellValue(format);
                            }else {
                                //如果不是日期类型的话他属性里面的数据转为string类型
                                cell.setCellValue(o2.toString());
                            }
                        }else {
                            //或者转换为空
                            cell.setCellValue("");
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    //随后在加+1
                    cells++;

                }

            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", "attachment; filename=\""+ UUID.randomUUID().toString()+".xlsx\"");

        ServletOutputStream outputStream=null;

        try {
            outputStream = response.getOutputStream();
            book.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

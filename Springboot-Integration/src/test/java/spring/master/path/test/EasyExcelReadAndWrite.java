package spring.master.path.test;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.junit.Test;
import spring.master.path.entity.WriteModel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ProjectManagement
 * @BelongsPackage: spring.master.path.test
 * @Author: QiFei
 * @CreateTime: 2019-09-30 15:33
 * @Description: EasyExcel读取与输出
 */
public class EasyExcelReadAndWrite {

    @Test
    public void writeToExcel(){
        String sourcePath = "d:/upload/123.xls";
        try {
            OutputStream os = new FileOutputStream(sourcePath);
            ExcelWriter writer = EasyExcelFactory.getWriter(os);

            //导出仅有一个sheet的Excel文件
            Sheet sheet = new Sheet(1,0, WriteModel.class);

            //sheet设置名
            sheet.setSheetName("第一个sheet");

            //写数据到 Writer 上下文
            //入参1：创建要写入的模型数据
            //入参2：要写入的目标 sheet
            writer.write(createModelList(),sheet);

            //将上下文中的最终 os 写入到指定文件中
            writer.finish();

            //关闭流
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<WriteModel> createModelList(){
        List<WriteModel> writeModels = new ArrayList<>();

        for(int i= 0;i<100;i++){
            WriteModel writeModel = WriteModel.builder().name("feige").password("123456").age(i + 1).build();
            writeModels.add(writeModel);
        }
        return writeModels;
    }
}

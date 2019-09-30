package spring.master.path.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Builder;
import lombok.Data;

/**
 * @BelongsProject: ProjectManagement
 * @BelongsPackage: spring.master.path.entity
 * @Author: QiFei
 * @CreateTime: 2019-09-30 15:38
 * @Description:
 */
@Data
@Builder
public class WriteModel extends BaseRowModel {
    @ExcelProperty(value = "姓名",index = 0)
    private String name;
    @ExcelProperty(value = "密码",index = 1)
    private String password;
    @ExcelProperty(value = "年龄",index = 2)
    private Integer age;
}

package spring.master.path.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @BelongsProject: ProjectManagement
 * @BelongsPackage: spring.master.path.entity
 * @Author: QiFei
 * @CreateTime: 2019-09-30 15:01
 * @Description: 假期安排
 */
@Data
@Accessors(chain = true)
public class HolidayPlans {
    /** 第几天 */
    private Integer dayNum;
    /** 景点 */
    private String placeOfInterest;
    /** 人数 */
    private Integer personsNum;
    /** 预算 */
    private Double budget;
}

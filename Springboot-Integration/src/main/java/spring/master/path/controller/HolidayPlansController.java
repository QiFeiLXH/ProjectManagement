package spring.master.path.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.master.path.service.HolidayPlansService;

/**
 * @BelongsProject: ProjectManagement
 * @BelongsPackage: spring.master.path.controller
 * @Author: QiFei
 * @CreateTime: 2019-09-30 15:09
 * @Description:
 */
@RestController
public class HolidayPlansController {

    @Autowired
    private HolidayPlansService holidayPlansService;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String get(){
        return null;
    }
}

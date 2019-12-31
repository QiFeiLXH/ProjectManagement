package org.qifei;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

/**
 * @BelongsProject: ProjectManagement
 * @BelongsPackage: org.qifei
 * @Author: QiFei
 * @CreateTime: 2019-12-06 09:04
 * @Description:
 */
public class CommonTest {



    @BeforeTest
    public Kid createKid(){
        Kid kid = new Kid() {
            {
                setAge(10);
                setName("小花");
                setBirthday(LocalDateTime.of(2019, 12, 6, 9, 49, 34));
            }
        };
        return kid;
    }

    @Test
    public void doProcess() throws JsonProcessingException {
        Kid kid = this.createKid();
        System.out.println(kid.toString());
        Gson gson = new Gson();
        String kidJson = gson.toJson(kid);
        System.out.println(kidJson);
        ObjectMapper om = new ObjectMapper();
        String kidString = om.writeValueAsString(kid);
        System.out.println(kidString);


    }
}

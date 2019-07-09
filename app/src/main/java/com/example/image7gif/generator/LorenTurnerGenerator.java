package com.example.image7gif.generator;


import com.example.image7gif.R;
import com.example.image7gif.model.UserBO;

import java.util.ArrayList;
import java.util.List;

public class LorenTurnerGenerator {

    static int images[] = {R.mipmap.image_three, R.mipmap.image_three, R.mipmap.image_three, R.mipmap.image_three};

//    public static UserBO userBO(){
//
//        UserBO userBO = new UserBO();
//        userBO.setName("Loren Turner");
//        userBO.setAddress("France ");
//        userBO.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
//        userBO.setImages(images);
//
//        return userBO;
//    }

    public static List<UserBO> userBOList(){
        List<UserBO> screenBOList = new ArrayList<UserBO>();

        for(int i = 0;i<1;i++){
            UserBO userBO = new UserBO();
            userBO.setId(i+"");
            userBO.setName("Loren Turner");
            userBO.setAddress("France  ");
            userBO.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
            userBO.setImages(images);
            screenBOList.add(userBO);

        }
        return screenBOList;
    }
}

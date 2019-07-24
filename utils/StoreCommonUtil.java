package com.boot.security.server.utils;

import com.boot.security.server.dto.LoginUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2018/11/9.
 */
public class StoreCommonUtil {
    /**
     *  判断登录用户是否是系统管理员
     * @return
     */
    public static List<String> GetLoginUserCheckStoreId() {
    LoginUser user=UserUtil.getLoginUser();
    if (user.getUserRole()==Const.SystemManageRoleId){
        return null;
    }else {
        List<String> List = new ArrayList<>();
        List = Arrays.asList(user.getSbStoreId().split(","));
        if (List.size()==0){
            List.add("-1");
        }
       /* List.add("-1");*/
        return List;
    }
}






}

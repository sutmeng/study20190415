package com.boot.security.server.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {


	/**
     * 添加cookie
     * 
     * @param response
     * @param name Key
     * @param value Value
     * @param maxAge 有效时间，单位为秒
     */
   static   public void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        //cookie.setDomain(".jsoft.me"); // cookie作用域
        response.addCookie(cookie);
    }
    
    
    /**  
     * 根据名字获取cookie  
     * @param request  
     * @param name cookie名字  
     * @return  
     */  
    static public  Cookie getCookieByName(HttpServletRequest request,String name){
        Map<String,Cookie> cookieMap = ReadCookieMap(request);  
        if(cookieMap.containsKey(name)){  
            Cookie cookie = (Cookie)cookieMap.get(name);  
            return cookie;  
        }else{  
            return null;  
        }     
    }
    /**  
     * 将cookie封装到Map里面  
     * @param request  
     * @return  
     */  
   static private  Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();  
        Cookie[] cookies = request.getCookies();  
        if(null!=cookies){  
            for(Cookie cookie : cookies){  
                cookieMap.put(cookie.getName(), cookie);  
            }  
        }  
        return cookieMap;  
    }  
    
    
    
	
	
	
	
	
	
	
}

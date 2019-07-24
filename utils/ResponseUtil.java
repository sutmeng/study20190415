package com.boot.security.server.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.boot.security.server.model.ResultEntity;

public class ResponseUtil {

	public static void responseJson(HttpServletResponse response, int status, Object data) {
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "*");
			response.setContentType("application/json;charset=UTF-8");
			response.setStatus(status);

			response.getWriter().write(JSONObject.toJSONString(data));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *生成页面请求的返回json数据，为页面laytable要求返回的固定格式
	 * @param rowcount
	 * @param data
	 * @return
	 */
	public static String GetResponseResultJson(int rowcount,List<PageData> data){
	JSONObject result = new JSONObject();
	result.put("code",0);
	result.put("msg", "ok");
	result.put("count", rowcount);
	result.put("data",data);
	return result.toJSONString();
}
	/**为页面layui下的table组件ajax请求要求返回的固定格式的数据，从而渲染界面数据项
	 *
	 * @param totalRowCount 总行数
	 * @param data  指定页下的列表数据集合，形式为List<dto>，其中列表项类型是实体类型模型，可以是model，也可以是dto
	 * @return
	 */
	public static Map<String,Object> GetResponseResultForLayuiTable(int totalRowCount, Object data){
		Map<String,Object> result = new HashMap<String,Object>();
		//layui下的table要求4个大项，
		result.put("code",0);
		result.put("msg", "ok");
		result.put("count", totalRowCount);//总行数
		result.put("data",data);//当前页的数据项集合，形式为List<dto>
		return result;
	}



	public static Map<String,Object> GetResponseResultForData(int code , Object data){
		Map<String,Object> result = new HashMap<String,Object>();
		//layui下的table要求4个大项，
		result.put("code",0);
		result.put("msg", "ok");
		result.put("data",data);//当前页的数据项集合，形式为List<dto>
		return result;
	}

    public static Map<String, Object> GetResponseResultForDataTest(int code, Object data) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (code == 1000) result.put("msg", "请求成功");
        if (code == 8001) result.put("msg", "时间戳为空");
        if (code == 8002) result.put("msg", "nonceStr 为空");
        if (code == 8003) result.put("msg", "签名为空");
        if (code == 8004) result.put("msg", "签名验证失败");
        if (code == 8005) result.put("msg", "服务器异常");
        if (code == 8006) result.put("msg", "非法参数");
        if (code == 8007) result.put("msg", "用户名不存在");
        if (code == 8008) result.put("msg", "密码错误");

        result.put("code", code);
        result.put("result", data);//当前页的数据项集合，形式为List<dto>
		System.out.println(result.entrySet());
		return result;
    }










}

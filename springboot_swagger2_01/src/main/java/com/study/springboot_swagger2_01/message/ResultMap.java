package com.study.springboot_swagger2_01.message;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResultMap {

	   private String message="operation successful";
	   
	   private String code="111111";

	   private String errorMessage="operation failed";

	   private String errorCode="111112";
	   
	   public Map<String,Object> Data(Boolean data){
		   Map<String,Object> map=new HashMap<String,Object>();
		   if (data){
			   map.put("msg", message);
			   map.put("code", code);
			   map.put("data", data);
		   }else {
			   map.put("msg", errorMessage);
			   map.put("code", errorCode);
			   map.put("data", data);
		   }

		   return map;
	   }
	   
	   public Map<String,Object> Data(Float data){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("msg", message);
		   map.put("code", code);
		   map.put("data", data);
		   return map;
	   }
	   
	   public Map<String,Object> Data(Long data){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("msg", message);
		   map.put("code", code);
		   map.put("data", data);
		   return map;
	   }
	   
	   
	   public Map<String,Object> Data(Byte data){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("msg", message);
		   map.put("code", code);
		   map.put("data", data);
		   return map;
	   }
	   
	   public Map<String,Object> Data(Short data){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("msg", message);
		   map.put("code", code);
		   map.put("data", data);
		   return map;
	   }
	   
	   public Map<String,Object> Data(Character data){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("msg", message);
		   map.put("code", code);
		   map.put("data", data);
		   return map;
	   }
	   
	   
	   public Map<String,Object> Data(Double data){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("msg", message);
		   map.put("code", code);
		   map.put("data", data);
		   return map;
	   }
	   
	   public Map<String,Object> Data(Integer data){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("msg", message);
		   map.put("code", code);
		   map.put("data", data);
		   return map;
	   }
	   
	   public Map<String,Object> Data(String data){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("msg", message);
		   map.put("code", code);
		   map.put("data", data);
		   return map;
	   }
	   
	   public Map<String,Object> Data(Object data){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("msg", message);
		   map.put("code", code);
		   map.put("data", data);
		   return map;
	   }
	   
	   public Map<String,Object> Data(){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("msg", message);
		   map.put("code", code);
		   return map;
	   }

}

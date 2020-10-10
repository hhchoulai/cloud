package com.vo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;


@Data
//当值为空时，不序列化值
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO implements Serializable {
    private Integer status;
    private String message;
    private Object data;

    //    静态工厂方法
    public static ResultVO success(){
        ResultVO resultVO=new ResultVO();
        resultVO.setStatus(0);
        resultVO.setMessage("成功");
        return resultVO;
    }
    public static ResultVO success(Object data){
        ResultVO resultVO=new ResultVO();
        resultVO.setStatus(0);
        resultVO.setMessage("成功");
        resultVO.setData(data);
        return resultVO;
    }
    public static ResultVO success(String message){
        ResultVO resultVO=new ResultVO();
        resultVO.setStatus(0);
        resultVO.setMessage(message);
        return resultVO;
    }
    public static ResultVO success(String message,Object data){
        ResultVO resultVO=new ResultVO();
        resultVO.setStatus(0);
        resultVO.setMessage(message);
        resultVO.setData(data);
        return resultVO;
    }
    public static ResultVO fail(Integer status,String message){
        ResultVO resultVO=new ResultVO();
        resultVO.setStatus(status);
        resultVO.setMessage(message);
        return resultVO;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return this.getStatus().equals(ResultVO.success().getStatus());
    }
}

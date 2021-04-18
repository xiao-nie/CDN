package cn.awall.awalladmin.vo;

public class CommonResult<T> {
    private Integer code;
    private T data;

    public CommonResult(Integer code,T data){
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public T getData() {
        return data;
    }
}

package com.egnesse.sckullappsuperadmin.dto;

/**
 * Created by adityaagrawal on 16/02/16.
 */
public class ResponseDTO {
    private String message;
    private Integer status;
    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", data='" + data + '\'' +
                '}';
    }
}

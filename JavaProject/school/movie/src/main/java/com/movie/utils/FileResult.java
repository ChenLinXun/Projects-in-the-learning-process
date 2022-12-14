package com.movie.utils;

import lombok.Data;

import java.io.Serializable;
@Data
public class FileResult implements Serializable {
    //判断结果
    private boolean success;
    //返回信息
    private String message;

    public FileResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }
}




package br.com.anderson.springbootwithjavaintroduction.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionsResponse implements Serializable {

    private Date timeInstant;
    private String message;
    private String Detail;

    public ExceptionsResponse(Date timeInstant, String message, String detail) {
        this.timeInstant = timeInstant;
        this.message = message;
        Detail = detail;
    }

    public Date getTimeInstant() {
        return timeInstant;
    }

    public void setTimeInstant(Date timeInstant) {
        this.timeInstant = timeInstant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }
}

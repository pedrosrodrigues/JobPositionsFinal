package util;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class Color implements Serializable {
	
    private static final long serialVersionUID = 1L;
    private String color;

    public Color() {
        this.color = "system_grey.css";
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
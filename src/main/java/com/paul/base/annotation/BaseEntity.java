package com.paul.base.annotation;

@SimpleAnnotation(name = "class")
public class BaseEntity {
    @SimpleAnnotation(name="constructor")
    public BaseEntity() {

    }
    @SimpleAnnotation()
    private String defaultContent;

    @SimpleAnnotation(name = "content")
    private String content;

    @SimpleAnnotation(name = "getDefaultContent")
    public String getDefaultContent() {
        return defaultContent;
    }

    @SimpleAnnotation(name = "setDefaultContent")
    public void setDefaultContent(String defaultContent) {
        this.defaultContent = defaultContent;
    }

    @SimpleAnnotation(name = "getContent")
    public String getContent() {
        return content;
    }

    @SimpleAnnotation(name = "setContent")
    public void setContent(String content) {
        this.content = content;
    }

}

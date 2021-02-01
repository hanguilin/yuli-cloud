package cn.javayuli.cloud.generator.entity;

/**
 * @description: 属性列定义
 * @author: HanGuiLin
 * @createDate: 2021/1/17
 * @version: 1.0
 */
public class FieldDefinition {

    /**
     * 字段名
     */
    private String name;

    /**
     * 字段名(首字母小写)
     */
    private String nameLower;

    /**
     * 字段类型
     */
    private String type;

    /**
     * 注释
     */
    private String comment;

    /**
     * 是否主键
     */
    private boolean primary;

    /**
     * 是否自增
     */
    private boolean autoincrement;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameLower() {
        return nameLower;
    }

    public void setNameLower(String nameLower) {
        this.nameLower = nameLower;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public boolean isAutoincrement() {
        return autoincrement;
    }

    public void setAutoincrement(boolean autoincrement) {
        this.autoincrement = autoincrement;
    }
}

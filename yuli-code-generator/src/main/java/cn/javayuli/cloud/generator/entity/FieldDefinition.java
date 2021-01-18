package cn.javayuli.cloud.generator.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;

/**
 * @description: 属性列定义
 * @author: HanGuiLin
 * @createDate: 2021/1/17
 * @version: 1.0
 */
@TableName("filed_definition")
public class FieldDefinition extends Model<FieldDefinition> {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 列名
     */
    private String columnName;

    /**
     * 列类型
     */
    private String columnType;

    /**
     * 列长度
     */
    private String columnLength;

    /**
     * 是否可为空
     */
    private String columnNullable;

    /**
     * 是否为主键
     */
    private String columnIsPrimary;

    /**
     * 默认值
     */
    private String columnDefaultValue;

    /**
     * 功能描述
     */
    private String comment;

    /**
     * java属性名
     */
    private String propertyName;

    /**
     * java属性类型
     */
    private String propertyType;

    /**
     * 关联生成id
     */
    private String generatorId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 备注
     */
    private String remark;

    /**
     * 逻辑删除
     */
    @TableLogic
    private String delFlag;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
    }

    public LocalDateTime getCreateTime(){
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime){
        this.createTime=createTime;
    }

    public String getCreateBy(){
        return createBy;
    }

    public void setCreateBy(String createBy){
        this.createBy=createBy;
    }

    public LocalDateTime getUpdateTime(){
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime){
        this.updateTime=updateTime;
    }

    public String getUpdateBy(){
        return updateBy;
    }

    public void setUpdateBy(String updateBy){
        this.updateBy=updateBy;
    }

    public String getRemark(){
        return remark;
    }

    public void setRemark(String remark){
        this.remark=remark;
    }

    public String getDelFlag(){
        return delFlag;
    }

    public void setDelFlag(String delFlag){
        this.delFlag=delFlag;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnLength() {
        return columnLength;
    }

    public void setColumnLength(String columnLength) {
        this.columnLength = columnLength;
    }

    public String getColumnNullable() {
        return columnNullable;
    }

    public void setColumnNullable(String columnNullable) {
        this.columnNullable = columnNullable;
    }

    public String getColumnIsPrimary() {
        return columnIsPrimary;
    }

    public void setColumnIsPrimary(String columnIsPrimary) {
        this.columnIsPrimary = columnIsPrimary;
    }

    public String getColumnDefaultValue() {
        return columnDefaultValue;
    }

    public void setColumnDefaultValue(String columnDefaultValue) {
        this.columnDefaultValue = columnDefaultValue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
    }
}

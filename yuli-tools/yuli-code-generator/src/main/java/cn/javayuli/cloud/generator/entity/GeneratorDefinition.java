package cn.javayuli.cloud.generator.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * @description: 生成属性定义
 * @author: HanGuiLin
 * @createDate: 2021/1/17
 * @version: 1.0
 */
@TableName("generator_definition")
public class GeneratorDefinition extends Model<GeneratorDefinition> {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 包名
     */
    private String packageName;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 子模块名
     */
    private String subModuleName;

    /**
     * 功能描述
     */
    private String comment;

    /**
     * 网关前缀
     */
    private String gateWayPrefix;

    /**
     * 表前缀
     */
    private String tablePrefix;

    /**
     * 作者
     */
    private String author;

    /**
     * 项目版本
     */
    private String projectVersion;

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
     *
     */
    @TableLogic
    private String delFlag;

    /**
     * 数据源名称
     */
    @TableField(exist = false)
    private String dsName;

    /**
     * 类名
     */
    @TableField(exist = false)
    private String className;

    /**
     * 类名首字母小写
     */
    @TableField(exist = false)
    private String classNameLower;

    /**
     * 接口包名
     */
    @TableField(exist = false)
    private String apiPackage;

    /**
     * 引用包名
     */
    @TableField(exist = false)
    private String referencePackage;

    /**
     * 所有字段
     */
    @TableField(exist = false)
    private List<FieldDefinition> fieldList;

    /**
     * 类中额外导入的包
     */
    @TableField(exist = false)
    private Set<String> importClassList;

    /**
     * 当前时间
     */
    @TableField(exist = false)
    private String now;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getSubModuleName() {
        return subModuleName;
    }

    public void setSubModuleName(String subModuleName) {
        this.subModuleName = subModuleName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public void setProjectVersion(String projectVersion) {
        this.projectVersion = projectVersion;
    }

    public List<FieldDefinition> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<FieldDefinition> fieldList) {
        this.fieldList = fieldList;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassNameLower() {
        return classNameLower;
    }

    public void setClassNameLower(String classNameLower) {
        this.classNameLower = classNameLower;
    }

    public String getApiPackage() {
        return apiPackage;
    }

    public void setApiPackage(String apiPackage) {
        this.apiPackage = apiPackage;
    }

    public String getReferencePackage() {
        return referencePackage;
    }

    public void setReferencePackage(String referencePackage) {
        this.referencePackage = referencePackage;
    }

    public Set<String> getImportClassList() {
        return importClassList;
    }

    public void setImportClassList(Set<String> importClassList) {
        this.importClassList = importClassList;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getGateWayPrefix() {
        return gateWayPrefix;
    }

    public void setGateWayPrefix(String gateWayPrefix) {
        this.gateWayPrefix = gateWayPrefix;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}

package cn.javayuli.cloud.generator.entity;

import java.util.List;
import java.util.Set;

/**
 * @description: 生成属性定义
 * @author: HanGuiLin
 * @createDate: 2021/1/17
 * @version: 1.0
 */
public class GeneratorDefinition {

    /**
     * 数据源名称
     */
    private String dataSourceName;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 类名
     */
    private String className;

    /**
     * 类名首字母小写
     */
    private String classNameLower;

    /**
     * 包名
     */
    private String packageName;

    /**
     * 接口包名
     */
    private String apiPackage;

    /**
     * 引用包名
     */
    private String referencePackage;

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
     * 作者
     */
    private String author;

    /**
     * 项目版本
     */
    private String projectVersion;

    /**
     * 所有字段
     */
    private List<FieldDefinition> fieldList;

    /**
     * 类中额外导入的包
     */
    private Set<String> importClassList;

    /**
     * 当前时间
     */
    private String now;

    /**
     * 网关前缀
     */
    private String gateWayPrefix;

    public String getDataSourceName() {
        return dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
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
}

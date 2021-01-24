package cn.javayuli.cloud.generator.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.javayuli.cloud.common.core.util.FreeMarkerUtil;
import cn.javayuli.cloud.common.core.util.SpringContextHolder;
import cn.javayuli.cloud.generator.entity.FieldDefinition;
import cn.javayuli.cloud.generator.entity.GeneratorDefinition;
import cn.javayuli.cloud.generator.mapper.DbMapper;
import cn.javayuli.cloud.generator.mapper.GeneratorDefinitionMapper;
import cn.javayuli.cloud.generator.properties.GenerateProperties;
import cn.javayuli.cloud.generator.service.GeneratorDefinitionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @description: 代码生成业务实现类
 * @author: HanGuiLin
 * @createDate: 2021/1/18
 * @version: 1.0
 */
@Service
public class GeneratorDefinitionServiceImpl extends ServiceImpl<GeneratorDefinitionMapper, GeneratorDefinition> implements GeneratorDefinitionService {

    /**
     * 模板根路径
     */
    private static final String TPL_PATH = "/template";

    /**
     * 控制层模板
     */
    private static final String CONTROLLER = "Controller.java";

    /**
     * 业务类模板
     */
    private static final String SERVICE = "Service.java";

    /**
     * 业务实现类模板
     */
    private static final String SERVICE_IMPL = "ServiceImpl.java";

    /**
     * 数据库mapper模板
     */
    private static final String MAPPER = "Mapper.java";

    /**
     * 实体模板
     */
    private static final String ENTITY = "Entity.java";

    /**
     * 前端弹窗模板
     */
    private static final String FORM = "Form.vue";

    /**
     * 前端列表模板
     */
    private static final String INDEX = "Index.vue";

    /**
     * 模板列表
     */
    private static List<String> TEMPLATE_LIST;

    static {
        List<String> temp = CollUtil.newArrayList();
        temp.add(CONTROLLER);
        temp.add(SERVICE);
        temp.add(SERVICE_IMPL);
        temp.add(MAPPER);
        temp.add(ENTITY);
        temp.add(INDEX);
        temp.add(FORM);
        TEMPLATE_LIST = Collections.unmodifiableList(temp);
    }

    @Autowired
    private DbMapper dbMapper;

    @Autowired
    private GenerateProperties generateProperties;

    /**
     * 根据配置生成代码并包装成byte数组
     *
     * @param generatorDefinition 生成描述
     * @return
     * @throws IOException
     */
    @Override
    public byte[] getCodeByte(GeneratorDefinition generatorDefinition) throws IOException {
        if (generatorDefinition == null) {
            return new byte[0];
        }
        String tableName = generatorDefinition.getTableName();
        // 查询表列信息
        List<Map<String, Object>> columnInfoList = dbMapper.queryColumns(tableName, generatorDefinition.getDsName());
        if (CollUtil.isEmpty(columnInfoList)) {
            return new byte[0];
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        // 设置实体值
        assembly(generatorDefinition, columnInfoList);
        // 替换模板字符,放入zip
        freemarkerInToZip(zip, generatorDefinition);
        IoUtil.close(zip);
        return outputStream.toByteArray();
    }

    /**
     * 替换模板字符并构造压缩包
     *  @param zip                 zip流
     * @param generatorDefinition 属性定义
     */
    private void freemarkerInToZip(ZipOutputStream zip, GeneratorDefinition generatorDefinition) throws IOException {
        Map<String, Object> params = BeanUtil.beanToMap(generatorDefinition, false, true);
        freemarker.template.Configuration configuration = SpringContextHolder.getBean(freemarker.template.Configuration.class);
        configuration.setClassForTemplateLoading(FreeMarkerUtil.class, TPL_PATH);
        for (String template: TEMPLATE_LIST) {
            // 模板替换字符串
            String tpl = FreeMarkerUtil.parseTpl(configuration, template, params);
            // 添加到zip
            zip.putNextEntry(new ZipEntry(Objects.requireNonNull(getFilePath(template, generatorDefinition))));
            IoUtil.write(zip, StandardCharsets.UTF_8, false, tpl);
            zip.closeEntry();
        }
    }

    /**
     * 获取文件路径与名称
     *
     * @param template    模板路径
     * @param generatorDefinition 生成类描述
     * @return
     */
    private String getFilePath(String template, GeneratorDefinition generatorDefinition) {
        String className = generatorDefinition.getClassName();
        String packageName = generatorDefinition.getPackageName();
        String moduleName = generatorDefinition.getModuleName();
        String apiPackage = generatorDefinition.getApiPackage();
        String referencePackage = generatorDefinition.getReferencePackage();
        String structureJava = String.valueOf(generateProperties.getStructure().get("java"));
        String structureWeb = String.valueOf(generateProperties.getStructure().get("web"));
        // ###########前端页面###########
        if (template.contains(INDEX)) {
            return structureWeb + File.separator + className + "Index.vue";
        }
        if (template.contains(FORM)) {
            return structureWeb + File.separator + className + "Form.vue";
        }
        String basePath = "src" + File.separator + "main" + File.separator + "java";
        if (StrUtil.isNotBlank(packageName)) {
            basePath += File.separator + packageName.replace(".", File.separator) + File.separator + moduleName;
        }
        // ###########后台界面###########
        if (template.contains(CONTROLLER)) {
            return structureJava + File.separator + basePath + File.separator + apiPackage + File.separator + "controller"+ File.separator + className + "Controller.java";
        }
        if (template.contains(SERVICE)) {
            return structureJava + File.separator + basePath + File.separator + apiPackage + File.separator + "service" + File.separator + className + "Service.java";
        }
        if (template.contains(SERVICE_IMPL)) {
            return structureJava + File.separator + basePath + File.separator + apiPackage + File.separator + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
        }
        if (template.contains(MAPPER)) {
            return structureJava + File.separator + basePath + File.separator + apiPackage + File.separator + "mapper" + File.separator + className + "Mapper.java";
        }
        if (template.contains(ENTITY)) {
            return structureJava + File.separator + basePath + File.separator + referencePackage + File.separator + "entity" + File.separator + className + ".java";
        }
        return null;
    }

    /**
     * 组装实体
     *  @param generatorDefinition 生成描述对象
     * @param columnInfoList      列信息
     */
    private void assembly(GeneratorDefinition generatorDefinition, List<Map<String, Object>> columnInfoList) {
        // 拼接父子模块
        String moduleName = generatorDefinition.getModuleName();
        String subModuleName = generatorDefinition.getSubModuleName();
        if (StrUtil.isNotBlank(subModuleName)) {
            generatorDefinition.setModuleName(moduleName + File.separator + subModuleName);
        }
        // 当前时间
        generatorDefinition.setNow(LocalDateTimeUtil.format(LocalDate.now(), DatePattern.CHINESE_DATE_PATTERN));
        String tableName = generatorDefinition.getTableName();
        // 去除表前缀
        String tablePrefix = generatorDefinition.getTablePrefix();
        if (StrUtil.isNotBlank(tablePrefix) && tableName.startsWith(tablePrefix)) {
            tableName = tableName.replaceFirst(tablePrefix, "");
        }
        // 类名首字母大写
        generatorDefinition.setClassName(columnToPropertyFirstUpper(tableName));
        // 类名首字母小写
        generatorDefinition.setClassNameLower(firstCharLower(generatorDefinition.getClassName()));
        // 根据配置文件设置默认值
        setDefaultValue(generatorDefinition);
        Set<String> importClassList = CollUtil.newHashSet();
        List<FieldDefinition> fieldList = CollUtil.newArrayList();
        Map<String, Object> importClassMap = generateProperties.getImportClass();
        Map<String, Object> typeMap = generateProperties.getType();
        columnInfoList.stream().forEach(column -> {
            FieldDefinition fieldDefinition = new FieldDefinition();
            // 设置属性名
            String propertyName = columnToProperty(String.valueOf(column.get("column_name")));
            fieldDefinition.setName(propertyName);
            // 设置属性名第一个字符小写
            fieldDefinition.setNameLower(firstCharLower(propertyName));
            // 设置属性类型
            Object dataType = typeMap.get(column.get("data_type"));
            String typeStr = dataType == null ? null : String.valueOf(dataType);
            fieldDefinition.setType(typeStr);

            // 如果数据类型在需要导入类的列表中，则添加到导入列表
            if (importClassMap.containsKey(dataType)) {
                importClassList.add(String.valueOf(importClassMap.get(dataType)));
            }
            // 设置属性注释
            String columnComment = String.valueOf(column.get("column_comment"));
            fieldDefinition.setComment(columnComment);
            // 设置属性是否主键
            String columnKey = String.valueOf(column.get("column_key"));
            fieldDefinition.setPrimary("PRI".equals(columnKey));
            // 设置属性是否自增
            String extra = String.valueOf(column.get("extra"));
            fieldDefinition.setAutoincrement("auto_increment".equals(extra));
            fieldList.add(fieldDefinition);
        });
        generatorDefinition.setFieldList(fieldList);
        generatorDefinition.setImportClassList(importClassList);
    }

    /**
     * 设置默认值
     *
     * @param generatorDefinition 生成对象描述
     */
    private void setDefaultValue(GeneratorDefinition generatorDefinition) {
        Class<? extends GeneratorDefinition> aClass = generatorDefinition.getClass();
        Map<String, Object> defaultValueMap = generateProperties.getDefaultValue();
        if (MapUtil.isNotEmpty(defaultValueMap)) {
            defaultValueMap.entrySet().stream().forEach(entry -> {
                String field = entry.getKey();
                Object defaultValue = entry.getValue();
                if (ReflectUtil.hasField(aClass, field)) {
                    Object fieldValue = ReflectUtil.getFieldValue(generatorDefinition, field);
                    // 字段值为空则设置默认值
                    if (fieldValue == null || (fieldValue instanceof String && StrUtil.isBlank(String.valueOf(fieldValue)))) {
                        ReflectUtil.setFieldValue(generatorDefinition, field, defaultValue);
                    }
                }
            });
        }
    }

    /**
     * 数据库列名转换类字段
     *
     * @param columnName 列名
     */
    private String columnToProperty(String columnName) {
        // 将所有以'_'分割的首字母大写并去掉'_'
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replaceAll("_", "");
    }

    /**
     * 数据库列名转换类字段(第一个字符大写)
     *
     * @param columnName 列名
     */
    private String columnToPropertyFirstUpper(String columnName) {
        // 将所有以'_'分割的首字母大写并去掉'_'
        return WordUtils.capitalizeFully(columnName, new char[]{' ', '_'}).replaceAll("_", "");
    }

    /**
     * 首字母转小写
     *
     * @param s 字符串
     * @return
     */
    private String firstCharLower(String s) {
        return Character.isLowerCase(s.charAt(0)) ? s : Character.toLowerCase(s.charAt(0)) + s.substring(1);
    }
}

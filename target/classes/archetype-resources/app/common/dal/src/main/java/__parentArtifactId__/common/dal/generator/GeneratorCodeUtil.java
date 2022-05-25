#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.common.dal.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Property;

import java.io.File;
import java.util.Scanner;

public class GeneratorCodeUtil {
    /**
     * 数据库的配置
     */
    private static final String DB_URL = "jdbc:mysql://dev.db.sunmi.com:3306/app_${parentArtifactId}?useUnicode=true&characterEncoding=UTF8&useSSL=true&serverTimezone=Asia/Shanghai&autoReconnect=true&allowPublicKeyRetrieval=false&failOverReadOnly=false";
    private static final String USERNAME = "app_${parentArtifactId}";
    private static final String PASSWORD = "HBCfxXa16acNBJ8BtpGX";


    /**
     * 代码生成位置
     */
    public static final String PARENT_NAME = "com.sunmi.sbs.${parentArtifactId}";

    /**
     * 基本路径
     */
    public static final String SRC_MAIN_JAVA = "common"+File.separatorChar+"dal"+File.separatorChar+"src"+File.separatorChar+"main"+File.separatorChar+"java";

    /**
     * module 名字
     */
    public static final String MODULE_NAME = "";

    /**
     * 作者
     */
    public static String author = "cjunl";

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + File.separator + MODULE_NAME + File.separator + SRC_MAIN_JAVA;

        System.out.println(filePath);
        Scanner scanner = new Scanner(System.in);
        System.out.println("表名称：");
        //apply_no,approve_record,factory_notice_obj,project_conf,segment_manage,segment_use_detail,segment_use_main,supplier_extend remind_user

        //model、dto、convert、单字段不会生成TableField
        String[] tableNames =(scanner.next()).split(",");
        for (String tableName : tableNames) {
            moduleGenerator(tableName);
        }
    }

    public static void moduleGenerator(String tableName) {
        new AutoGenerator(getDataSourceConfig())// 数据源配置
                .global(getGlobalConfig())// 全局配置
                .packageInfo(getPackageConfig())// 包配置
                .strategy(getStrategyConfig(tableName))// 策略配置
                .template(getTemplateConfig())// 模板配置
                .execute();
    }

    private static StrategyConfig getStrategyConfig(String tableName) {
        return new StrategyConfig.Builder()
                .enableCapitalMode()//驼峰命名
                .addInclude(tableName.split(","))
                .entityBuilder()
                .formatFileName("%sDO")
                .enableLombok()
                .enableRemoveIsPrefix()
                .logicDeleteColumnName("deleted")
                .columnNaming(NamingStrategy.underline_to_camel)
                .naming(NamingStrategy.underline_to_camel)
                .idType(IdType.AUTO)
                .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
                .serviceBuilder()
                .convertServiceFileName(name -> name + "Service")
                .convertServiceImplFileName(name -> name + "ServiceImpl")
                .mapperBuilder()
                .enableBaseResultMap()
                .build();
    }

    private static PackageConfig getPackageConfig() {
        return new PackageConfig.Builder()
                .parent("com.baomidou.mybatisplus.samples.generator")
                .moduleName(MODULE_NAME)// 设置父包模块名
                .parent(PARENT_NAME)
                .mapper("common.dal.dao")//DAO
                .xml("mapper")
                .service("core.service")
                .serviceImpl("core.service.impl")
                .entity("common.dal.entity").build();//DO
    }


    private static DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig.Builder(DB_URL, USERNAME, PASSWORD).build();
    }


    private static GlobalConfig getGlobalConfig() {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + File.separator + MODULE_NAME + File.separator + SRC_MAIN_JAVA;
        return new GlobalConfig.Builder()
                .outputDir(filePath)//输出目录
                .dateType(DateType.ONLY_DATE)
                .fileOverride()//覆盖已有文件
                .author(author)
                .enableSwagger()
                .openDir(false)
                .build();
    }

    private static TemplateConfig getTemplateConfig() {
        return new TemplateConfig.Builder()
                .service("template/vm/service.java.vm", "template/vm/serviceImpl.java.vm")
                .entity("template/vm/entity.java.vm")
                .mapper("template/vm/mapper.java.vm")
                .mapperXml("template/vm/mapper.xml.vm")
                .disable(TemplateType.CONTROLLER)//禁用controller模板
                .build();
    }
}

package cn.javayuli.cloud.system.ref.entity;

import java.util.List;

/**
 * @description:
 * @author: hanguilin
 * @createDate: 2021/1/29
 * @version: 1.0
 */
public class SystemParam {

    /**
     * 磁盘使用情况
     */
    private List<DiskParam> diskParamList;

    /**
     * 操作系统
     */
    private String osName;

    /**
     * 获取本机ip
     */
    private String serverIp;

    /**
     * 获取本机计算机名称
     */
    private String hostName;

    /**
     * 操作系统版本
     */
    private String osVersion;

    /**
     * 程序启动时间
     */
    private String jvmStartTime;

    /**
     * pid
     */
    private String pid;

    /**
     * cpu核数
     */
    private String processors;

    /**
     * JAVA_HOME
     */
    private String javaHome;

    /**
     * JAVA_VERSION
     */
    private String javaVersion;

    /**
     * jvm名称
     */
    private String jvmName;

    /**
     * USER_HOME
     */
    private String userHome;

    /**
     * USER_NAME
     */
    private String userName;

    /**
     * 初始的总内存(JVM)
     */
    private String initialMemorySize;

    /**
     * 最大可用内存(JVM)
     */
    private String maxMemorySize;

    /**
     * 已使用的内存(JVM)
     */
    private String usedMemorySize;

    /**
     * 总的物理内存
     */
    private String totalMemorySize;

    /**
     * 剩余的物理内存
     */
    private String freePhysicalMemorySize;

    /**
     * 已使用的物理内存
     */
    private String usedPhysicalMemorySize;

    /**
     * 总线程数
     */
    private String totalThread;

    /**
     * cpu核数
     */
    private Integer logicalProcessorOfCPU;

    /**
     * cpu系统使用率
     */
    private String utilizationRateOfCPUSystem;

    /**
     * cpu用户使用率
     */
    private String utilizationRateOfCPUUser;

    /**
     * cpu当前等待率
     */
    private String currentWaitingRateOfCPU;

    /**
     * cpu当前空闲率
     */
    private String currentIdleRateOfCPU;

    /**
     * 项目路径
     */
    private String projectDir;


    public static class DiskParam {

        /**
         * 路径
         */
        private String path;

        /**
         * 容量
         */
        private String total;

        /**
         * 可用空间
         */
        private String un;

        /**
         * 空闲
         */
        private String free;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getUn() {
            return un;
        }

        public void setUn(String un) {
            this.un = un;
        }

        public String getFree() {
            return free;
        }

        public void setFree(String free) {
            this.free = free;
        }
    }

    public List<DiskParam> getDiskParamList() {
        return diskParamList;
    }

    public void setDiskParamList(List<DiskParam> diskParamList) {
        this.diskParamList = diskParamList;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getJvmStartTime() {
        return jvmStartTime;
    }

    public void setJvmStartTime(String jvmStartTime) {
        this.jvmStartTime = jvmStartTime;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProcessors() {
        return processors;
    }

    public void setProcessors(String processors) {
        this.processors = processors;
    }

    public String getJavaHome() {
        return javaHome;
    }

    public void setJavaHome(String javaHome) {
        this.javaHome = javaHome;
    }

    public String getUserHome() {
        return userHome;
    }

    public void setUserHome(String userHome) {
        this.userHome = userHome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInitialMemorySize() {
        return initialMemorySize;
    }

    public void setInitialMemorySize(String initialMemorySize) {
        this.initialMemorySize = initialMemorySize;
    }

    public String getMaxMemorySize() {
        return maxMemorySize;
    }

    public void setMaxMemorySize(String maxMemorySize) {
        this.maxMemorySize = maxMemorySize;
    }

    public String getUsedMemorySize() {
        return usedMemorySize;
    }

    public void setUsedMemorySize(String usedMemorySize) {
        this.usedMemorySize = usedMemorySize;
    }

    public String getTotalMemorySize() {
        return totalMemorySize;
    }

    public void setTotalMemorySize(String totalMemorySize) {
        this.totalMemorySize = totalMemorySize;
    }

    public String getFreePhysicalMemorySize() {
        return freePhysicalMemorySize;
    }

    public void setFreePhysicalMemorySize(String freePhysicalMemorySize) {
        this.freePhysicalMemorySize = freePhysicalMemorySize;
    }

    public String getUsedPhysicalMemorySize() {
        return usedPhysicalMemorySize;
    }

    public void setUsedPhysicalMemorySize(String usedPhysicalMemorySize) {
        this.usedPhysicalMemorySize = usedPhysicalMemorySize;
    }

    public String getTotalThread() {
        return totalThread;
    }

    public void setTotalThread(String totalThread) {
        this.totalThread = totalThread;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public Integer getLogicalProcessorOfCPU() {
        return logicalProcessorOfCPU;
    }

    public void setLogicalProcessorOfCPU(Integer logicalProcessorOfCPU) {
        this.logicalProcessorOfCPU = logicalProcessorOfCPU;
    }

    public String getUtilizationRateOfCPUSystem() {
        return utilizationRateOfCPUSystem;
    }

    public void setUtilizationRateOfCPUSystem(String utilizationRateOfCPUSystem) {
        this.utilizationRateOfCPUSystem = utilizationRateOfCPUSystem;
    }

    public String getUtilizationRateOfCPUUser() {
        return utilizationRateOfCPUUser;
    }

    public void setUtilizationRateOfCPUUser(String utilizationRateOfCPUUser) {
        this.utilizationRateOfCPUUser = utilizationRateOfCPUUser;
    }

    public String getCurrentWaitingRateOfCPU() {
        return currentWaitingRateOfCPU;
    }

    public void setCurrentWaitingRateOfCPU(String currentWaitingRateOfCPU) {
        this.currentWaitingRateOfCPU = currentWaitingRateOfCPU;
    }

    public String getCurrentIdleRateOfCPU() {
        return currentIdleRateOfCPU;
    }

    public void setCurrentIdleRateOfCPU(String currentIdleRateOfCPU) {
        this.currentIdleRateOfCPU = currentIdleRateOfCPU;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getJvmName() {
        return jvmName;
    }

    public void setJvmName(String jvmName) {
        this.jvmName = jvmName;
    }

    public String getProjectDir() {
        return projectDir;
    }

    public void setProjectDir(String projectDir) {
        this.projectDir = projectDir;
    }
}

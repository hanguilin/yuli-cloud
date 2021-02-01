package cn.javayuli.cloud.system.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.api.service.SystemInfoService;
import cn.javayuli.cloud.system.ref.entity.SystemParam;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: hanguilin
 * @createDate: 2021/1/29
 * @version: 1.0
 */
@Service
public class SystemInfoServiceImpl implements SystemInfoService {
    
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    /**
     * 获取系统信息
     *
     * @return
     * @throws InterruptedException
     * @throws UnknownHostException
     */
    @Override
    public Rest<SystemParam> getInfo() throws InterruptedException, UnknownHostException {
        SystemParam systemParam = new SystemParam();
        SystemInfo systemInfo = new SystemInfo();

        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        // 椎内存使用情况
        MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();

        // 初始的总内存
        long initTotalMemorySize = memoryUsage.getInit();
        // 最大可用内存
        long maxMemorySize = memoryUsage.getMax();
        // 已使用的内存
        long usedMemorySize = memoryUsage.getUsed();

        InetAddress addr = InetAddress.getLocalHost();
        // 获取本机ip
        String serverIp = addr.getHostAddress();
        systemParam.setServerIp(serverIp);
        // 获取本机计算机名称
        String hostName = addr.getHostName();
        systemParam.setHostName(hostName);
        // 操作系统版本
        String osVersion = System.getProperty("os.version");
        systemParam.setOsVersion(osVersion);
        // 操作系统
        String osName = System.getProperty("os.name");
        // 总的物理内存
        String totalMemorySize = DECIMAL_FORMAT
                .format(osmxb.getTotalPhysicalMemorySize() / 1024.0 / 1024 / 1024) + "G";
        // 剩余的物理内存
        String freePhysicalMemorySize = DECIMAL_FORMAT
                .format(osmxb.getFreePhysicalMemorySize() / 1024.0 / 1024 / 1024) + "G";
        // 已使用的物理内存
        String usedMemory = DECIMAL_FORMAT.format(
                (osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize()) / 1024.0 / 1024 / 1024)
                + "G";
        // 获得线程总数
        ThreadGroup parentThread;
        for (parentThread = Thread.currentThread().getThreadGroup(); parentThread
                .getParent() != null; parentThread = parentThread.getParent()) {
        }

        int totalThread = parentThread.activeCount();

        // 磁盘使用情况
        File[] files = File.listRoots();
        List<SystemParam.DiskParam> diskParams = CollUtil.newArrayList();
        for (File file : files) {
            String total = new DecimalFormat("#.#").format(file.getTotalSpace() * 1.0 / 1024 / 1024 / 1024)
                    + "G";
            String free = new DecimalFormat("#.#").format(file.getFreeSpace() * 1.0 / 1024 / 1024 / 1024) + "G";
            String un = new DecimalFormat("#.#").format(file.getUsableSpace() * 1.0 / 1024 / 1024 / 1024) + "G";
            String path = file.getPath();
            SystemParam.DiskParam diskParam = new SystemParam.DiskParam();
            // 路径
            diskParam.setPath(path);
            // 总量
            diskParam.setTotal(total);
            // 可用
            diskParam.setUn(un);
            // 空闲
            diskParam.setFree(free);
            diskParams.add(diskParam);
        }
        systemParam.setDiskParamList(diskParams);
        // 操作系统
        systemParam.setOsName(osName);
        // 程序启动时间
        String jvmStartTime = LocalDateTimeUtil.format(LocalDateTimeUtil.ofUTC(ManagementFactory.getRuntimeMXBean().getStartTime()), DatePattern.ISO8601_PATTERN);
        systemParam.setJvmStartTime(jvmStartTime);
        // pid
        systemParam.setPid(System.getProperty("PID"));
        // cpu核数
        systemParam.setProcessors(String.valueOf(Runtime.getRuntime().availableProcessors()));
        printlnCpuInfo(systemInfo, systemParam);
        // JAVA_HOME
        systemParam.setJavaHome(System.getProperty("java.home"));
        // JAVA_VERSION
        systemParam.setJavaVersion(System.getProperty("java.version"));
        // JVM name
        systemParam.setJvmName(System.getProperty("java.vm.name"));
        // USER_HOME
        systemParam.setUserHome(System.getProperty("user.home"));
        // USER_NAME
        systemParam.setUserName(System.getProperty("user.name"));
        // 初始的总内存(JVM)
        systemParam.setInitialMemorySize(new DecimalFormat("#.#").format(initTotalMemorySize * 1.0 / 1024 / 1024) + "M");
        // 最大可用内存(JVM)
        systemParam.setMaxMemorySize(new DecimalFormat("#.#").format(maxMemorySize * 1.0 / 1024 / 1024) + "M");
        // 已使用的内存(JVM)
        systemParam.setUsedMemorySize(new DecimalFormat("#.#").format(usedMemorySize * 1.0 / 1024 / 1024) + "M");
        // 总的物理内存
        systemParam.setTotalMemorySize(totalMemorySize);
        // 剩余的物理内存
        systemParam.setFreePhysicalMemorySize(freePhysicalMemorySize);
        // 已使用的物理内存
        systemParam.setUsedPhysicalMemorySize(usedMemory);
        // 总线程数
        systemParam.setTotalThread(String.valueOf(totalThread));
        // 项目路径
        systemParam.setProjectDir(System.getProperty("user.dir"));
        return Rest.success(systemParam);
    }

    /**
     * 打印 CPU 信息
     *
     * @param systemInfo
     * @param systemParam
     */
    private void printlnCpuInfo(SystemInfo systemInfo, SystemParam systemParam) throws InterruptedException {
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        // 睡眠1s
        TimeUnit.SECONDS.sleep(1);
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()]
                - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()]
                - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()]
                - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()]
                - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
        long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()]
                - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long user = ticks[CentralProcessor.TickType.USER.getIndex()]
                - prevTicks[CentralProcessor.TickType.USER.getIndex()];
        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()]
                - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()]
                - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
        // cpu核数
        systemParam.setLogicalProcessorOfCPU(processor.getLogicalProcessorCount());
        // cpu系统使用率
        systemParam.setUtilizationRateOfCPUSystem(DECIMAL_FORMAT.format(cSys * 1.0 / totalCpu));
        // cpu用户使用率
        systemParam.setUtilizationRateOfCPUUser(DECIMAL_FORMAT.format(user * 1.0 / totalCpu));
        // cpu当前等待率
        systemParam.setCurrentWaitingRateOfCPU(DECIMAL_FORMAT.format(iowait * 1.0 / totalCpu));
        // cpu当前空闲率
        systemParam.setCurrentIdleRateOfCPU(DECIMAL_FORMAT.format(idle * 1.0 / totalCpu));
    }
}

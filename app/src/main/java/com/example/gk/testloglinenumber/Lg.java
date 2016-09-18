package com.example.gk.testloglinenumber;

import android.util.Log;

/**
 * 项目名称：TestLogLineNumber
 * 类描述：
 * 创建人：gk
 * 创建时间：2016/9/18 15:55
 * 修改人：gk
 * 修改时间：2016/9/18 15:55
 * 修改备注：
 */
public class Lg {
    //是否打印log的标志位
    public static boolean isCanLog = true;

    /**
     * 打印行号的日志输出
     *
     * @param tag     tag名字
     * @param content 日志内容
     */
    public static void e_debug(String tag, String content) {
        if (BuildConfig.DEBUG || isCanLog) {
            StackTraceElement stackTraceElement = getCurrentStackTraceElement();
            if (null != stackTraceElement) {
                Log.e(tag, stackTraceElement.toString());
            }
            Log.e(tag, content);
        }
    }

    /**
     * @return 返回此次打印log的调用处的堆栈信息
     */
    private static StackTraceElement getCurrentStackTraceElement() {
        final int DIVIER = 2;//加2就是调用这个打印日志的那个方法那里了
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int resultPosition = 0;
        for (int i = 0; i < stackTraceElements.length; i++) {
            StackTraceElement temp = stackTraceElements[i];
            if (temp.getClassName().equals(Lg.class.getName())) {
                resultPosition = i + DIVIER;
                break;
            }
        }
        if (resultPosition >= 0 && resultPosition < stackTraceElements.length) {
            return stackTraceElements[resultPosition];
        } else {
            return null;
        }
    }
}

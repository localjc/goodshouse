package com.dockboys.goodshouse.ui;

import android.app.Activity;

import java.util.Stack;

/**
 * Desc :
 * Author : jiangcheng
 * Date : on 2016/3/7 0007
 */
public class AppManager {

    private static Stack<Activity> sStackActivities;
    private static AppManager sInstance;

    private AppManager() {
        if (sStackActivities == null) {
            sStackActivities = new Stack<>();
        }
    }

    public static AppManager getInstance() {
        if (sInstance == null) {
            sInstance = new AppManager();
        }
        return sInstance;
    }

    public void addActivity(Activity activity) {
        if (sStackActivities == null) {
            sStackActivities = new Stack<>();
        }
        sStackActivities.add(activity);
    }

    public Activity getCurrentActivity() {
        return sStackActivities.lastElement();
    }

    /**
     * 关闭当前的activity.
     */
    public void finishCurrentActivity() {
        Activity activity = sStackActivities.lastElement();
        finishActivity(activity);
    }

    public void removeActivity(Activity activity) {
        sStackActivities.remove(activity);
    }

    public void finishActivity(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            sStackActivities.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    public void finishAllActivity() {
        for (int i = 0, size = sStackActivities.size(); i < size; i++) {
            if (sStackActivities.get(i) != null) {
                finishActivity(sStackActivities.get(i));
            }
        }
        sStackActivities.clear();
    }

    /**
     * 根据class 文件 找到指定activity
     * @param cls
     * @return
     */
    public Activity getActivity(Class<?> cls) {
        if (sStackActivities != null) {
            for (Activity activity : sStackActivities) {
                if (activity.getClass().equals(cls)) {
                    return activity;
                }
            }
        }
        return null;
    }


    /**
     * 应用程序退出,先finish所有的activity 后杀死自己的进程
     */
    public void appExit() {
        try {
            finishAllActivity();
            android.os.Process.killProcess(android.os.Process.myPid());
        } catch (Exception e) {

        }
    }
}

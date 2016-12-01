package com.yuyh.reactnative.utils;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by Kyrie.Y on 2016/12/1.
 */
public class Utils {

    public static Project getProjectByEvent(AnActionEvent event) {
        return event.getData(PlatformDataKeys.PROJECT);
    }

    public synchronized static void sendCommand(String path, String cmd) {

        new Thread(() -> {
            Runtime run = Runtime.getRuntime();

            try {
                Process p = run.exec(cmd, null, new File(path));
                BufferedInputStream in = new BufferedInputStream(p.getErrorStream());
                BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
                String lineStr;
                while ((lineStr = inBr.readLine()) != null) {
                    System.out.println(lineStr);
                }

                p.waitFor();
                inBr.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}

package com.yuyh.reactnative;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.progress.util.StatusBarProgress;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.yuyh.reactnative.utils.Utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by Kyrie.Y on 2016/12/1.
 */
public class DevMenuPlugin extends AnAction {

    @Override
    public void update(AnActionEvent event) {
        event.getPresentation().setEnabledAndVisible(true);
    }

    @Override
    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        String path = project.getBasePath();

        String cmd = "cmd /c adb shell input keyevent 82";

        Utils.sendCommand(path, cmd);
    }
}

package com.yuyh.reactnative;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.yuyh.reactnative.utils.Utils;

/**
 * Created by Kyrie.Y on 2016/12/1.
 */
public class StartPlugin extends AnAction {

    @Override
    public void update(AnActionEvent event) {
        event.getPresentation().setEnabledAndVisible(true);
    }

    @Override
    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        String path = project.getBasePath();

        String cmd = "cmd /c start react-native start";

        Utils.sendCommand(path, cmd);
    }
}

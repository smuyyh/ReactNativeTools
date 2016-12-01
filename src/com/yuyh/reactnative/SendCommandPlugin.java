package com.yuyh.reactnative;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.yuyh.reactnative.utils.Utils;

/**
 * Created by Kyrie.Y on 2016/12/1.
 */
public class SendCommandPlugin extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        Project project = Utils.getProjectByEvent(event);
        String path = project.getBasePath();

        String cmd = showDialog(project);

        Utils.sendCommand(path, "cmd /c start " + cmd);
    }

    private String showDialog(Project project) {
        return Messages.showInputDialog(project, "input command", "Send command", null);
    }
}

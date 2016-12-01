package com.yuyh.reactnative;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.InputValidator;
import com.intellij.openapi.ui.Messages;
import com.sun.jndi.toolkit.url.Uri;
import com.yuyh.reactnative.utils.Utils;

import javax.swing.*;
import java.net.MalformedURLException;
import java.util.regex.Pattern;

/**
 * Created by Kyrie.Y on 2016/12/1.
 */
public class DebugUiPlugin extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent event) {

        String url = Messages.showInputDialog(Utils.getProjectByEvent(event),
                "input url",
                "open debugger-ui",
                new ImageIcon(Utils.getProjectByEvent(event) + "/resources/icons/chrome.png"),
                "http://localhost:8081/debugger-ui",
                new InputValidator() {
                    @Override
                    public boolean checkInput(String url) {
                        Pattern pattern = Pattern
                                .compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$");

                        return pattern.matcher(url).matches();
                    }

                    @Override
                    public boolean canClose(String s) {
                        return true;
                    }
                });


        //判断当前系统是否支持Java AWT Desktop扩展
        if (java.awt.Desktop.isDesktopSupported() && url != null && url.length() > 0) {
            try {
                //创建一个URI实例,注意不是URL
                java.net.URI uri = java.net.URI.create(url);
                //获取当前系统桌面扩展
                java.awt.Desktop dp = java.awt.Desktop.getDesktop();
                //判断系统桌面是否支持要执行的功能
                if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    //获取系统默认浏览器打开链接
                    dp.browse(uri);
                }
            } catch (NullPointerException e) {
                //此为uri为空时抛出异常
            } catch (java.io.IOException e) {
                //此为无法获取系统默认浏览器
            }
        }
    }
}

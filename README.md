# ReactNativeTools

IntelliJ plugin, to make it easier to execute react-native commands

<img src="https://github.com/smuyyh/ReactNativeTools/raw/master/screenshot/toolsmenu_1.png" height=250 />

## Guide

1. **install**

  File -> Settings -> Plugin -> Install plugin from disk -> select ReactNativeTools.jar -> OK -> Restart Intellij/Webstorm
  
2. Tools -> react-native -> run-android, this is equivalent to executing the following command
  ```
react-native run-android
  ```
3. Tools -> react-native -> open dev menu, this is equivalent to executing the following command

  ```
adb shell input keyevent 82
  ```
4. Tools -> react-native -> start server, this is equivalent to executing the following command

  ```
react-native start
  ```

5. Tools -> react-native -> open debugger-ui, this will open the debugger-ui in Chrome

  <img src="https://github.com/smuyyh/ReactNativeTools/raw/master/screenshot/opendebuggerui.png" height=160 />

6. Tools -> react-native -> Start, exec custom command
  
  <img src="https://github.com/smuyyh/ReactNativeTools/raw/master/screenshot/sendcommand.png" height=160 />
  
## License
```
 Copyright © 2016 smuyyh

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
```
   

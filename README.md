# TestDemo
测试项目，用来测试各种新内容的使用

#Tinker使用内容说明   

Tinker使用：  

1、调用assembleDebug编译，我们会将编译过的包保存在build/bakApk中。  

2、修改build.gradle中的参数，将编译保存的安装包路径拷贝到tinkerPatch中的oldApk参数中。  

   修改ext中的 tinkerOldApkPath = "${bakPath}/app-debug-1213-17-33-57.apk"  
   
3、调用tinkerPatchDebug, 补丁包与相关日志会保存在/build/outputs/tinkerPatch/。然后我们将patch_signed_7zip.apk推送到手机的sdcard中。  

4、调用 TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),
                        Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk"); 来执行补丁的修复。  
                        
   如果看到patch success, please restart process的toast，即可锁屏或者kill  
   
5、下次进入app后即可看到补丁修复的内容  

  
  
Release的使用方法  

Tinker的使用方式如下，以gradle接入的release包为例：  

每次编译或发包将安装包与mapping文件备份；  

若有补丁包的需要，按自身需要修改你的代码、库文件等；  

将备份的基准安装包与mapping文件输入到tinkerPatch的配置中；  

运行tinkerPatchRelease，即可自动编译最新的安装包，并与输入基准包作差异，得到最终的补丁包。  

#Tinker使用内容完毕




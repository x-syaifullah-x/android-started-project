package id.xxx.xposed

import de.robv.android.xposed.IXposedHookZygoteInit
import de.robv.android.xposed.XposedBridge

class MainXposedHookZygoteInit : IXposedHookZygoteInit {
    override fun initZygote(startupParam: IXposedHookZygoteInit.StartupParam) {
        XposedBridge.log("id.xxx.exposed: initZygote startsSystemServer ${startupParam.startsSystemServer}")
    }
}
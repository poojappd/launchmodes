package com.example.launchmodes

import android.app.ActivityManager
import android.app.ActivityManager.RunningTaskInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


open class MainActivity : AppCompatActivity() {
    protected var activityManager: ActivityManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        if(activityManager==null){
            activityManager=getSystemService(ACTIVITY_SERVICE) as ActivityManager;
        }
    }
    protected fun getNumberOfTasks(): Int {
        return activityManager!!.appTasks.size
    }

    protected fun getAppTaskState(): String? {
        val stringBuilder = StringBuilder()
        val totalNumberOfTasks: Int =
            activityManager!!.getRunningTasks(10).size //Returns total number of tasks - stacks
        stringBuilder.append("\nTotal Number of Tasks: $totalNumberOfTasks\n\n")
        val taskInfo: List<RunningTaskInfo> =
            activityManager!!.getRunningTasks(10) //returns List of RunningTaskInfo - corresponding to tasks - stacks
        for (info in taskInfo) {
            stringBuilder.append(
                """
                Task Id: ${info.id}, Number of Activities : ${info.numActivities}
                
                """.trimIndent()
            ) //Number of Activities in task - stack

            // Display the root Activity of task-stack
            stringBuilder.append(
                """
                TopActivity: ${
                    info.topActivity!!.className.replace(
                        "lauchmodesdemo.youtube.codetutor.com.activitylauchmodesdemo.",
                        ""
                    )
                }
                
                """.trimIndent()
            )

            // Display the top Activity of task-stack
            stringBuilder.append(
                """
                BaseActivity:${
                    info.baseActivity!!.className.replace(
                        "lauchmodesdemo.youtube.codetutor.com.activitylauchmodesdemo.",
                        ""
                    )
                }
                
                """.trimIndent()
            )
            stringBuilder.append("\n\n")
        }
        return stringBuilder.toString()
    }
}
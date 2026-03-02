package me.timeto.app.ui.apps

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import me.timeto.app.ui.navigation.LocalNavigationFs
import me.timeto.app.ui.shortcuts.apps.ShortcutAppsFs

@Composable
fun AppDrawerFs() {

    val navigationFs = LocalNavigationFs.current
    val context = LocalContext.current

    ShortcutAppsFs(
        onAppSelected = { shortcutApp ->
            val intent = context.packageManager.getLaunchIntentForPackage(shortcutApp.androidPackage)
            if (intent == null) {
                navigationFs.alert("App package not found")
            } else {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }
        },
    )
}

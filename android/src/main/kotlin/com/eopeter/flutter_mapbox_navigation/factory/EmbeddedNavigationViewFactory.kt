package com.eopeter.flutter_mapbox_navigation.factory

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import com.eopeter.flutter_mapbox_navigation.utilities.PluginUtilities
import com.eopeter.flutter_mapbox_navigation.models.views.EmbeddedNavigationMapView
import com.eopeter.flutter_mapbox_navigation.models.views.EmbeddedView
import com.eopeter.flutter_mapbox_navigation.models.views.NativeView
import eopeter.flutter_mapbox_navigation.R
import eopeter.flutter_mapbox_navigation.databinding.NavigationActivityBinding

import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

class EmbeddedNavigationViewFactory(
    private val messenger: BinaryMessenger,
    private val activity: Activity
) : PlatformViewFactory(StandardMessageCodec.INSTANCE) {
    override fun create(context: Context, viewId: Int, args: Any?): PlatformView {
        val inflater = LayoutInflater.from(context)
        val binding = NavigationActivityBinding.inflate(inflater)
        val accessToken = PluginUtilities.getResourceFromContext(context, "mapbox_access_token")
        val view = EmbeddedNavigationMapView(
            context,
            activity,
            binding,
            messenger,
            viewId,
            args,
            accessToken
        )
        activity.setTheme(R.style.Theme_AppCompat_NoActionBar)
        return view
    }
}
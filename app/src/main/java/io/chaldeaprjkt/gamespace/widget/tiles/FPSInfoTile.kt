/*
 * Copyright (C) 2021 Chaldeaprjkt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.chaldeaprjkt.gamespace.widget.tiles

import android.content.Context
import android.util.AttributeSet
import android.view.View
import io.chaldeaprjkt.gamespace.R

class FPSInfoTile @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : BaseTile(context, attrs) {


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        showFpsInfo = appSettings.showFps
        title?.text = context.getString(R.string.fps_Info_title)
        icon?.setImageResource(R.drawable.ic_fps)
    }

    private var showFpsInfo = false
        set(value) {
            field = value
            if (value) {
                summary?.text = context.getString(R.string.state_enabled)
            } else {
                summary?.text = context.getString(R.string.state_disabled)
            }
            appSettings.showFps = value
            isSelected = value
        }

    override fun onClick(v: View?) {
        super.onClick(v)
        showFpsInfo = !showFpsInfo
    }
}

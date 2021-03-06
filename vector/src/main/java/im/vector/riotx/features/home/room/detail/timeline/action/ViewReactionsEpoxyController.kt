/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.riotx.features.home.room.detail.timeline.action

import android.graphics.Typeface
import com.airbnb.epoxy.TypedEpoxyController

/**
 * Epoxy controller for reaction event list
 */
class ViewReactionsEpoxyController(private val emojiCompatTypeface: Typeface?) : TypedEpoxyController<DisplayReactionsViewState>() {

    override fun buildModels(state: DisplayReactionsViewState) {
        val map = state.mapReactionKeyToMemberList() ?: return
        map.forEach {
            reactionInfoSimpleItem {
                id(it.eventId)
                emojiTypeFace(emojiCompatTypeface)
                timeStamp(it.timestamp)
                reactionKey(it.reactionKey)
                authorDisplayName(it.authorName ?: it.authorId)
            }
        }
    }
}
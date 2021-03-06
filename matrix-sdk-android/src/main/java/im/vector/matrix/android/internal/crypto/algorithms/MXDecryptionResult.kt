/*
 * Copyright 2016 OpenMarket Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.matrix.android.internal.crypto.algorithms

import im.vector.matrix.android.api.util.JsonDict

/**
 * This class represents the decryption result.
 */
data class MXDecryptionResult(
        /**
         * The decrypted payload (with properties 'type', 'content')
         */
        var payload: JsonDict? = null,

        /**
         * keys that the sender of the event claims ownership of:
         * map from key type to base64-encoded key.
         */
        var keysClaimed: Map<String, String>? = null,

        /**
         * The curve25519 key that the sender of the event is known to have ownership of.
         */
        var senderKey: String? = null,

        /**
         * Devices which forwarded this session to us (normally empty).
         */
        var forwardingCurve25519KeyChain: List<String>? = null
)
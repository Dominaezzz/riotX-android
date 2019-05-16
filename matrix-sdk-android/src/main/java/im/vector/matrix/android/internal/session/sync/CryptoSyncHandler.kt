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

package im.vector.matrix.android.internal.session.sync

import im.vector.matrix.android.internal.crypto.CryptoManager
import im.vector.matrix.android.internal.crypto.verification.DefaultSasVerificationService
import im.vector.matrix.android.internal.session.sync.model.SyncResponse
import im.vector.matrix.android.internal.session.sync.model.ToDeviceSyncResponse


internal class CryptoSyncHandler(private val cryptoManager: CryptoManager,
                                 private val sasVerificationService: DefaultSasVerificationService) {

    fun handleToDevice(toDevice: ToDeviceSyncResponse) {
        toDevice.events?.forEach {
            sasVerificationService.onToDeviceEvent(it)
            cryptoManager.onToDeviceEvent(it)
        }

    }

    fun onSyncCompleted(syncResponse: SyncResponse, fromToken: String?, catchingUp: Boolean) {
        cryptoManager.onSyncCompleted(syncResponse, fromToken, catchingUp)
    }

}
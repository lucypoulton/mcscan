/*
 * Copyright © 2021 Lucy Poulton
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package net.lucypoulton.mcscan

import kotlinx.serialization.Serializable
import net.lucypoulton.mcscan.serialiser.ChatSerialiser
import net.lucypoulton.mcscan.serialiser.UUIDSerializer
import java.util.UUID

@Serializable
data class ServerListPingResponse(
    val version: ServerVersion,
    @Serializable(with = ChatSerialiser::class) val description: String,
    val favicon: String? = null,
    val players: PlayerCount
) {

    @Serializable
    data class ServerVersion(val name: String, val protocol: Int)

    @Serializable
    data class PlayerCount(val max: Int, val online: Int, val sample: Array<Player> = emptyArray()) {
        @Serializable
        data class Player(val name: String, @Serializable(with = UUIDSerializer::class) val id: UUID)
    }
}

